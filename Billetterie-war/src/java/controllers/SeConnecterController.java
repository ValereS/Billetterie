package controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ClientGestionLocal;

/**
 *
 * @author cdi515
 */
public class SeConnecterController implements SubControllerInterface{
    ClientGestionLocal clientGestion = lookupClientGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "seConnecter";
    }
    
    
    private ClientGestionLocal lookupClientGestionLocal() {
        try {
            Context c = new InitialContext();
            return (ClientGestionLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/ClientGestion!service.ClientGestionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
}
