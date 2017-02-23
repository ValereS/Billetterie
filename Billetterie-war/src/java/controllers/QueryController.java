/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.QueryGestionLocal;

/**
 *
 * @author cdi505
 */
public class QueryController implements SubControllerInterface {

    QueryGestionLocal queryGestion = lookupQueryGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String query = request.getParameter("query");
        if (query == null || query.trim().isEmpty()) {
            query = "SELECT s FROM Spectacle s";
        }
        try {
            List<Object> resultList = queryGestion.execute(query);
            request.setAttribute("resultList", resultList);
        } catch (Exception ex) {
            request.setAttribute("message", String.format("%s: %s", ex.getClass().getName(), ex.getMessage()));
        }
        request.setAttribute("query", query);
        return "query";
    }

    private QueryGestionLocal lookupQueryGestionLocal() {
        try {
            Context c = new InitialContext();
            return (QueryGestionLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/QueryGestion!service.QueryGestionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
