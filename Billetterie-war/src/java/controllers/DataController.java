package controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.testdata.TestDataLocal;

public class DataController implements SubControllerInterface {

    TestDataLocal testData = lookupTestDataLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if ("create".equalsIgnoreCase(action)) {
            if (!testData.exists()) {
                testData.create();
                request.setAttribute("message", "Test data created!");
            } else {
                request.setAttribute("message", "Test data already created!");
            }
        }
        return "home";
    }

    private TestDataLocal lookupTestDataLocal() {
        try {
            Context c = new InitialContext();
            return (TestDataLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/TestData!service.testdata.TestDataLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
