package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchController implements SubControllerInterface {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String paramSearch =  request.getParameter("paramSearch");
        request.setAttribute("paramSearch", paramSearch);
        return "includes/search-form";
    }

}
