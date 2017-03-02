/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import service.PanierGestionLocal;

/**
 *
 * @author cdi505
 */
public class CartWar implements Serializable {

    private final PanierGestionLocal panierGestion;

    public CartWar() {
        panierGestion = lookupPanierGestionLocal();
    }

    public PanierGestionLocal getPanierGestion() {
        return panierGestion;
    }

    private PanierGestionLocal lookupPanierGestionLocal() {
        try {
            Context c = new InitialContext();
            return (PanierGestionLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/PanierGestion!service.PanierGestionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
