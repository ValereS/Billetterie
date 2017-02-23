/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Spectacle;
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
public class ShowDisplayController implements SubControllerInterface {

    SpectacleGestionLocal spectacleGestion = lookupSpectacleGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "Bad ID");
            return "includes/store/show-error";
        }

        Spectacle show = spectacleGestion.selectById(id);
        request.setAttribute("show", show);

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

}
