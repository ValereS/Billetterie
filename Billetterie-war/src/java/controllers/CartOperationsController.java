/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.LigneCommande;
import exceptions.CartError;
import java.util.Enumeration;
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

        if ("add".equalsIgnoreCase(action)) {

            Long showingId;
            Long categoryId;
            Long rateId;
            int quantity;
            int numAdds = 0;
            String message = null;

            try {
                showingId = Long.parseLong(request.getParameter("showingId"));
            } catch (NumberFormatException ex) {
                request.setAttribute("message", ex.getMessage());
                return "error";
            }

            try {
                Enumeration<String> names = request.getParameterNames();
                while (names.hasMoreElements()) {
                    String name = names.nextElement();
                    if (name.startsWith("choixBillet")) {
                        String[] params = name.split(",");
                        categoryId = Long.parseLong(params[1]);
                        rateId = Long.parseLong(params[2]);
                        quantity = Integer.parseInt(request.getParameter(name));
                        if (quantity > 0) {
                            try {
                                LigneCommande orderLine = panierGestion.createOrderLine(showingId, categoryId, rateId, quantity);
                                panierGestion.addOrderLine(categoryId, rateId, orderLine);
                                ++numAdds;
                            } catch (CartError ex) {
                                message = "Tous vos billets n'ont pas pu être réservés pour cause de manque de stock.";
//                                request.setAttribute("message", ex.getMessage());
//                                return "error";
                            }
                        }
                    }
                }
            } catch (NumberFormatException ex) {
            }

            if (numAdds == 0) {
                try {
                    categoryId = Long.parseLong(request.getParameter("categoryId"));
                    rateId = Long.parseLong(request.getParameter("rateId"));
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                } catch (NumberFormatException ex) {
                    request.setAttribute("message", ex.getMessage());
                    return "error";
                }

                try {
                    LigneCommande orderLine = panierGestion.createOrderLine(showingId, categoryId, rateId, quantity);
                    panierGestion.addOrderLine(categoryId, rateId, orderLine);
                } catch (CartError ex) {
                    request.setAttribute("message", ex.getMessage());
                    return "error";
                }
            }

            request.setAttribute("orderLines", panierGestion.getOrderLines());
            request.setAttribute("message", message);
        }

        if ("remove".equalsIgnoreCase(action)) {
            long categoryId = Long.parseLong(request.getParameter("categoryId"));
            String rateName = request.getParameter("rateName");
            panierGestion.removeOrderLine(categoryId, rateName);
            request.setAttribute("orderLines", panierGestion.getOrderLines());
        }

        return "cart";
    }

}
