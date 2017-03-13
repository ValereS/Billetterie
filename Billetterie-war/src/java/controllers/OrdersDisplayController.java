/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi505
 */
public class OrdersDisplayController implements SubControllerInterface {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "includes/store/orders-display";
    }
    
}
