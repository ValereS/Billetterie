/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Client;
import entities.Commande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi505
 */
@Local
public interface CommandeGestionLocal {

    List<Commande> getCommandesByClient(Client client);
    List<Commande> getCommandesByClient(Client client, int monthsAmount);
    
}
