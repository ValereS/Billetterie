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
    public void addOrderLine(Long categoryId, Long rateId, LigneCommande orderLine) {
        CartKey cartKey = new CartKey(categoryId, getRateFromId(rateId).getNom());
        cart.put(cartKey, orderLine);
    }

    @Override
    public LigneCommande removeOrderLine(Long categoryId, Long rateId) {
        CartKey cartKey = new CartKey(categoryId, getRateFromId(rateId).getNom());
        return cart.remove(cartKey);
    }

    @Override
    public LigneCommande removeOrderLine(Long categoryId, String rateName) {
        CartKey cartKey = new CartKey(categoryId, rateName);
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
    public LigneCommande createOrderLine(Long showingId, Long categoryId, Long rateId, int quantity) throws CartError {
        if (quantity < 1) {
            throw new CartError("Quantity must be > 0");
        }

        Seance showing = em.find(Seance.class, showingId);
        if (showing == null) {
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
        qr.setParameter("paramShowing", showing);
        qr.setParameter("paramCategory", category);
        qr.setParameter("paramRate", rate);

        List<Billet> tickets = qr.getResultList();
        try {
            tickets = tickets.subList(0, quantity);
        } catch (IndexOutOfBoundsException ex) {
            throw new CartError("Not enough tickets");
        }
        Billet ticket = tickets.get(0);
        float vatRate = ticket.getTva().getTaux();
        float promotionRate = category.getPromotion() != null ? category.getPromotion().getTaux() : 0;

        LigneCommande orderLine = new LigneCommande(rate, vatRate, promotionRate);
        orderLine.setBillets(tickets);

        return orderLine;
    }

    @Override
    public Tarif getRateFromId(long id) {
        Tarif tarif = em.find(Tarif.class, id);
        return tarif;
    }

}
