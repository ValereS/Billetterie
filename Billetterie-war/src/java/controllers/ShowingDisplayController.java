/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Categorie;
import entities.Seance;
import entities.Tarif;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SeanceGestionLocal;

/**
 *
 * @author philo
 */
public class ShowingDisplayController implements SubControllerInterface {

    SeanceGestionLocal seanceGestion = lookupSeanceGestionLocal();
    private final int MAX_NUM_TICKETS = 20;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        long seanceId;
        Seance seance;
        try {
            seanceId = Long.parseLong(request.getParameter("seanceId"));
            seance = seanceGestion.getById(seanceId);
            request.setAttribute("seanceId", seanceId);
        } catch (IllegalArgumentException ex) {
            seance = null;
        }

        if (seance != null) {
            List<Categorie> categories = seanceGestion.getCategoriesFromBillets(seance.getBillets());
            List<String> tarifNoms = seanceGestion.getTarifNomsFromCategories(categories);
            Map<Categorie, Map<String, Tarif>> mapTarifs = seanceGestion.getMapTarifsFromCategories(categories);
            List<Integer> nombreBillets = new ArrayList();
            for (int i = 0; i <= MAX_NUM_TICKETS; ++i) {
                nombreBillets.add(i);
            }

            request.setAttribute("seance", seance);
            request.setAttribute("categories", categories);
            request.setAttribute("tarifNoms", tarifNoms);
            request.setAttribute("mapTarifs", mapTarifs);
            request.setAttribute("nombreBillets", nombreBillets);
        }
        return "includes/store/showing-display";
    }

    private SeanceGestionLocal lookupSeanceGestionLocal() {
        try {
            Context c = new InitialContext();
            return (SeanceGestionLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/SeanceGestion!service.SeanceGestionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
