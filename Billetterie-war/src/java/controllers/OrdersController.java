/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import entities.Commande;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.CommandeGestionLocal;

/**
 *
 * @author cdi505
 */
public class OrdersController implements SubControllerInterface {

    CommandeGestionLocal commandeGestion = lookupCommandeGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");

        if (client == null) {
            return "login";
        }

        List<Commande> orders = commandeGestion.getCommandesByClient(client);
        request.setAttribute("orders", orders);

        return "orders";
    }

    private CommandeGestionLocal lookupCommandeGestionLocal() {
        try {
            Context c = new InitialContext();
            return (CommandeGestionLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/CommandeGestion!service.CommandeGestionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
