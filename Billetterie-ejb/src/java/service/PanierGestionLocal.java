/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.LigneCommande;
import javax.ejb.Local;

/**
 *
 * @author cdi505
 */
@Local
public interface PanierGestionLocal {

    void addOrderLine(LigneCommande orderLine);

    boolean removeOrderLine(LigneCommande oderLine);
    
}
