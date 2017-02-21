package controllers;

import entities.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ClientGestionLocal;

/**
 *
 * @author cdi515
 */
public class ClientController implements SubControllerInterface{
    
    
    
    ClientGestionLocal clientGestion = lookupClientGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if ("login".equalsIgnoreCase(action)){
            String email = request.getParameter("email");
            String mdp = request.getParameter("mdp");
            Client client = clientGestion.selectClientByEmail(email, mdp);
            if (client == null){
                request.setAttribute("errorMessage", "malbona kombino retpoŝta / PWD");
                return "login";
            }else{
                session.setAttribute("client", client);
                return "home";
            }
        }
        if ("logout".equalsIgnoreCase(action)){
            session.removeAttribute("client");
        }
        return "login";
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
