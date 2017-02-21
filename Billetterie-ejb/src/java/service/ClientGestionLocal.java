/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Client;
import javax.ejb.Local;

/**
 *
 * @author cdi505
 */
@Local
public interface ClientGestionLocal {

    public Client selectClientByEmail(String email, String mdp);
    
}
