/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import service.PanierGestionLocal;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> sessionDestroyed");
        HttpSession session = event.getSession();
        CartWar cartWar = (CartWar) session.getAttribute("cartWar");
        if (cartWar != null) {
            PanierGestionLocal panierGestion = cartWar.getPanierGestion();
            panierGestion.clear();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> cart cleared");
        }
    }
}
