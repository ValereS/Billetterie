package controllers;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.PanierGestionLocal;
import util.CartWar;

public class CartController implements SubControllerInterface {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        CartWar cartWar = (CartWar) session.getAttribute("cartWar");

        if (cartWar == null) {
            cartWar = new CartWar();
            session.setAttribute("cartWar", cartWar);
        }
        PanierGestionLocal panierGestion = cartWar.getPanierGestion();
        BigDecimal totalPriceATI = panierGestion.getTotalPriceATI();
        session.setAttribute("totalPrice", totalPriceATI);

        return "includes/cart-header";
    }

}
