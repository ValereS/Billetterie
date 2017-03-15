/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Spectacle;
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
public class HomeController implements SubControllerInterface {

    SpectacleGestionLocal spectacleGestion = lookupSpectacleGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Spectacle> shows = spectacleGestion.selectBestSelling();
        request.setAttribute("shows", shows);
        return "home";
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
