/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.LigneCommande;
import javax.ejb.Stateful;

/**
 *
 * @author cdi505
 */
@Stateful
public class PanierGestion implements PanierGestionLocal {

    @Override
    public void addOrderLine(LigneCommande orderLine) {
    }

    @Override
    public boolean removeOrderLine(LigneCommande oderLine) {
        return false;
    }

    
}
