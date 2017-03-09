/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.LigneCommande;
import entities.Tarif;
import exceptions.CartError;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author cdi505
 */
@Local
public interface PanierGestionLocal {

    void addOrderLine(Long categoryId, Long rateId, LigneCommande orderLine);

    LigneCommande removeOrderLine(Long categoryId, String rateName);

    Collection<LigneCommande> getOrderLines();

    void clear();

    BigDecimal getTotalPrice();

    BigDecimal getTotalPriceATI();

    LigneCommande createOrderLine(Long showingId, Long categoryId, Long rateId, int quantity) throws CartError;

    Tarif getRateFromId(long id);

    LigneCommande removeOrderLine(Long categoryId, Long rateId);

}
