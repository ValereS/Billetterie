package controllers;

import entities.Client;
import enums.CiviliteClient;
import enums.StatutClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ClientController implements SubControllerInterface {

    ClientGestionLocal clientGestion = lookupClientGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if ("login".equalsIgnoreCase(action)) {
            String email = request.getParameter("email");
            String mdp = request.getParameter("mdp");
            Client client = clientGestion.selectByEmailPwd(email, mdp);
            if (client == null) {
                request.setAttribute("errorMessage", "malbona kombino retpoŝta / PWD");
                return "login";
            } else {
                session.setAttribute("client", client);
                return "home";
            }
        }
        if ("logout".equalsIgnoreCase(action)) {
            session.removeAttribute("client");
        }
        if ("signup".equalsIgnoreCase(action)) {
            String email = request.getParameter("email");
            Client client = clientGestion.selectByEmail(email);
            if (client == null) {
                String civilite = request.getParameter("civilite");
                try {
                    CiviliteClient cc = CiviliteClient.valueOf(civilite);
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    email = request.getParameter("email");
                    String mdp = request.getParameter("mdp");
                    String date = request.getParameter("dateNaissance");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(true);
                    Date dateNaissance;
                    try {
                        dateNaissance = sdf.parse(date);
                    } catch (ParseException ex) {
                        dateNaissance = null;
                    }
                    client = new Client(cc, nom, prenom, email, mdp, dateNaissance, StatutClient.ACTIF, null);
                    clientGestion.create(client);
                } catch (IllegalArgumentException ex) {
                    request.setAttribute("errorMessage", "mauvaise civilité !:" + civilite);
                    return "signup";
                }
                session.setAttribute("client", client);
                return "home";
            } else {
                request.setAttribute("errorMessage", "cet email est déjà utilisé !");
                return "signup";
            }
        }

        if ("manage".equalsIgnoreCase(action)) {
            Client client = (Client) session.getAttribute("client");
            if (client == null) {
                return "login";
            }
            String doIt = request.getParameter("doIt");
            if (doIt != null) {
                 
                request.setAttribute("message","Modification de compte valider !");
            } else {
                
            }
            return "client";
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
