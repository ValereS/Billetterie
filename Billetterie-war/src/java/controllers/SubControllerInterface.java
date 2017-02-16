package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface SubControllerInterface {
    String execute(HttpServletRequest request, HttpServletResponse response);
}
