/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.LigneCommande;
import java.math.BigDecimal;
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
        CartWar cartWar = (CartWar) session.getAttribute("shoppingCartWar");

        if (cartWar == null) {
            cartWar = new CartWar();
            session.setAttribute("shoppingCartWar", cartWar);
        }

        PanierGestionLocal panierGestion = cartWar.getPanierGestion();
        String action = request.getParameter("action");

        int categoryId;
        int rateId;
        int quantity;        
        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
            rateId = Integer.parseInt(request.getParameter("rateId"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException ex) {
                request.setAttribute("message", ex.getMessage());
                return "error";
        }
        
        

        if ("add".equalsIgnoreCase(action)) {
            //LigneCommande orderLine = new LigneCommande(BigDecimal.ZERO, tauxTva, tauxPromo);

            //panierGestion.addOrderLine(orderLine);
        }

        return "cart";
    }

}
