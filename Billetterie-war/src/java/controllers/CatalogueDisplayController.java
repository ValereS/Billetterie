/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Spectacle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SpectacleGestionLocal;

/**
 *
 * @author cdi505
 */
public class CatalogueDisplayController implements SubControllerInterface {

    SpectacleGestionLocal spectacleGestion = lookupSpectacleGestionLocal();
    public static int DEFAULT_MAX_RESULTS = 3;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String paramSearch = request.getParameter("paramSearch");

        int pageNumber;
        try {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        } catch (NumberFormatException ex) {
            pageNumber = 1;
        }

        int maxResults;
        try {
            maxResults = Integer.parseInt(request.getParameter("maxResults"));
        } catch (NumberFormatException ex) {
            maxResults = DEFAULT_MAX_RESULTS;
        }

        List<Spectacle> shows;
        long count;

        if (paramSearch == null || paramSearch.trim().isEmpty()) {
            count = spectacleGestion.count();
            shows = spectacleGestion.select(pageNumber, maxResults);
        } else {
            count = spectacleGestion.countBySearch(paramSearch);
            shows = spectacleGestion.selectBySearch(pageNumber, maxResults, paramSearch);
        }

        long numPages = (long) Math.ceil((double) count / maxResults);
        List<Integer> pageNumbers = new ArrayList();
        for (int i = 1; i <= numPages; ++i) {
            pageNumbers.add(i);
        }

        request.setAttribute("shows", shows);
        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("maxResults", maxResults);
        request.setAttribute("pageNumbers", pageNumbers);
        request.setAttribute("paramSearch", paramSearch);
        return "includes/store/catalogue-display";
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

}
