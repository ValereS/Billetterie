/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import classes.CartKey;
import entities.Billet;
import entities.Categorie;
import entities.LigneCommande;
import entities.Seance;
import entities.Tarif;
import exceptions.CartError;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public void addOrderLine(int categoryId, int rateId, LigneCommande orderLine) {
        CartKey cartKey = new CartKey(categoryId, rateId);
        cart.put(cartKey, orderLine);
    }

    @Override
    public LigneCommande removeOrderLine(int categoryId, int rateId) {
        CartKey cartKey = new CartKey(categoryId, rateId);
        return cart.remove(cartKey);
    }

    @Override
    public Collection<LigneCommande> getOrderLines() {
        return cart.values();
    }

    @Override
    public void clear() {
        cart.clear();
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (LigneCommande lineOrder : cart.values()) {
            total = total.add(lineOrder.getTotalPrice());
        }
        return total;
    }

    @Override
    public BigDecimal getTotalPriceATI() {
        BigDecimal total = BigDecimal.ZERO;
        for (LigneCommande lineOrder : cart.values()) {
            total = total.add(lineOrder.getTotalPriceATI());
        }
        return total;
    }

    @Override
    public LigneCommande createOrderLine(int showingId, int categoryId, int rateId, int quantity) throws CartError {
        if (quantity < 1) {
            throw new CartError("Quantity must be > 0");
        }

        Seance seance = em.find(Seance.class, showingId);
        if (seance == null) {
            throw new CartError("Invalid showing ID");
        }
        Categorie category = em.find(Categorie.class, categoryId);
        if (category == null) {
            throw new CartError("Invalid category ID");
        }
        Tarif rate = em.find(Tarif.class, rateId);
        if (rate == null) {
            throw new CartError("Invalid rate ID");
        }

        Query qr = em.createNamedQuery("entities.Billet.selectBySeanceCategorieTarif");
        qr.setParameter("paramShowing", seance);
        qr.setParameter("paramCategory", category);
        qr.setParameter("paramRate", rate);

        List<Billet> tickets = qr.getResultList();
        tickets = tickets.subList(0, quantity);
        if (tickets.size() < quantity) {
            throw new CartError("Not enough tickets");
        }
        Billet ticket = tickets.get(0);
        BigDecimal price = rate.getPrix();
        float vatRate = ticket.getTva().getTaux();
        float promotionRate = category.getPromotion().getTaux();

        LigneCommande orderLine = new LigneCommande(price, vatRate, promotionRate);
        orderLine.setBillets(tickets);

        return orderLine;
    }

}
