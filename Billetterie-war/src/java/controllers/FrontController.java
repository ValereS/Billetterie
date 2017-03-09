/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.PanierGestionLocal;

/**
 *
 * @author cdi505
 */
public class FrontController extends HttpServlet {

    PanierGestionLocal panierGestion = lookupPanierGestionLocal();

    private Map<String, SubControllerInterface> map;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        map = new HashMap<>();
        Enumeration<String> names = config.getInitParameterNames();

        while (names.hasMoreElements()) {
            String section = names.nextElement();
            String value = config.getInitParameter(section);

            try {
                SubControllerInterface sc = (SubControllerInterface) Class.forName(value).newInstance();
                map.put(section, sc);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
                System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            }
        }
        
        panierGestion.releaseTickets();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url;
        String section = request.getParameter("section");
        SubControllerInterface pc = map.get(section);

        if (pc != null) {
            url = pc.execute(request, response);
        } else {
            url = "home";
        }

        url = String.format("/WEB-INF/%s.jsp", url);
        url = response.encodeURL(url);

//        String url = "/WEB-INF/home.jsp";
        getServletContext().getRequestDispatcher(url).include(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

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
