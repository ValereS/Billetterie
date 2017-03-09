/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class CartDisplayController implements SubControllerInterface {

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
        BigDecimal totalPriceATI = panierGestion.getTotalPriceATI();
        request.setAttribute("orderLines", panierGestion.getOrderLines());
        request.setAttribute("totalPrice", totalPriceATI);
        return "includes/store/cart-display";
    }

}
