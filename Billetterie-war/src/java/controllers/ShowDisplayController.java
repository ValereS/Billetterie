/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Categorie;
import entities.Seance;
import entities.Spectacle;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.CategorieGestionLocal;
import service.SeanceGestionLocal;
import service.SpectacleGestionLocal;

/**
 *
 * @author cdi505
 */
public class ShowDisplayController implements SubControllerInterface {

    SeanceGestionLocal seanceGestion = lookupSeanceGestionLocal();
    CategorieGestionLocal categorieGestion = lookupCategorieGestionLocal();
    SpectacleGestionLocal spectacleGestion = lookupSpectacleGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
//        String action = request.getParameter("action");
        long id;
        long seanceId;
        Spectacle show;
        Seance seance;
        try {
            id = Long.parseLong(request.getParameter("id"));
            show = spectacleGestion.selectById(id);
            if (show == null) {
                throw new IllegalArgumentException("Spectacle inexistant");
            }
        } catch (IllegalArgumentException ex) {
            request.setAttribute("message", ex.getMessage());
            return "includes/store/show-error";
        }
        request.setAttribute("show", show);

        try {
            seanceId = Long.parseLong(request.getParameter("seanceId"));
            seance = seanceGestion.getById(seanceId);
            request.setAttribute("seanceId", seanceId);
        } catch (IllegalArgumentException ex) {
            seance = null;
        }

        if (seance != null) {
            List<Categorie> categories = seanceGestion.getCategoriesFromBillets(seance.getBillets());
            request.setAttribute("seance", seance);
            request.setAttribute("categories", categories);
        }

        return "includes/store/show-display";
    }

    private SpectacleGestionLocal lookupSpectacleGestionLocal() {
        try {
            Context c = new InitialContext();
            return (SpectacleGestionLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/SpectacleGestion!service.SpectacleGestionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CategorieGestionLocal lookupCategorieGestionLocal() {
        try {
            Context c = new InitialContext();
            return (CategorieGestionLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/CategorieGestion!service.CategorieGestionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
