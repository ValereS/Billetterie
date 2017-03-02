package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartController implements SubControllerInterface{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "includes/cart-header";
    }
    
}
