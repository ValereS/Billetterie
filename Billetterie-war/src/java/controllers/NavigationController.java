package controllers;

import entities.Theme;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ThemeGestionLocal;


public class NavigationController implements SubControllerInterface {
    ThemeGestionLocal themeGestion = lookupThemeGestionLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Theme> themes = themeGestion.selectAll();
        request.setAttribute("themes", themes);
        return "menus/menu-main";
    }

    private ThemeGestionLocal lookupThemeGestionLocal() {
        try {
            Context c = new InitialContext();
            return (ThemeGestionLocal) c.lookup("java:global/Billetterie/Billetterie-ejb/ThemeGestion!service.ThemeGestionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
