/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.LigneCommande;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author cdi505
 */
@Local
public interface PanierGestionLocal {

    void addOrderLine(LigneCommande orderLine);

    boolean removeOrderLine(LigneCommande orderLine);

    Collection<LigneCommande> getOrderLines();

    void clear();

    BigDecimal getTotalHT();

    BigDecimal getTotalTTC();
    
}
