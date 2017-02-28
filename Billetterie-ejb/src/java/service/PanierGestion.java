/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import classes.CartKey;
import entities.LigneCommande;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi505
 */
@Stateful
public class PanierGestion implements PanierGestionLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    private Map<CartKey, LigneCommande> cart;

    @PostConstruct
    public void init() {
        cart = new LinkedHashMap<>();
    }

    @Override
    public void addOrderLine(LigneCommande orderLine) {
    }

    @Override
    public boolean removeOrderLine(LigneCommande orderLine) {
        return false;
    }

    @Override
    public Collection<LigneCommande> getOrderLines() {
        return null;
    }

    @Override
    public void clear() {
    }

    @Override
    public BigDecimal getTotalHT() {
        return null;
    }

    @Override
    public BigDecimal getTotalTTC() {
        return null;
    }

}
