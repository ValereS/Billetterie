/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.LigneCommande;
import exceptions.CartError;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.PanierGestionLocal;
import util.CartWar;

/**
 *
 * @author cdi505
 */
public class CartOperationsController implements SubControllerInterface {
 
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        CartWar cartWar = (CartWar) session.getAttribute("cartWar");

        if (cartWar == null) {
            cartWar = new CartWar();
            session.setAttribute("cartWar", cartWar);
        }

        PanierGestionLocal panierGestion = cartWar.getPanierGestion();
        String action = request.getParameter("action");

        Long showingId;
        Long categoryId;
        Long rateId;
        int quantity;        
        try {
            showingId = Long.parseLong(request.getParameter("showingId"));
            categoryId = Long.parseLong(request.getParameter("categoryId"));
            rateId = Long.parseLong(request.getParameter("rateId"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException ex) {
                request.setAttribute("message", ex.getMessage());
                return "error";
        }
        
        

        if ("add".equalsIgnoreCase(action)) {
            try {
                LigneCommande orderLine = panierGestion.createOrderLine(showingId, categoryId, rateId, quantity);
                panierGestion.addOrderLine(categoryId, rateId, orderLine);
            } catch (CartError ex) {
                request.setAttribute("message", ex.getMessage());
                return "error";
            }
            request.setAttribute("orderLines", panierGestion.getOrderLines());
        }

        return "cart";
    }

}
