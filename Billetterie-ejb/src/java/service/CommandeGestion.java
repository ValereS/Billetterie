/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Billet;
import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi505
 */
@Stateless
public class CommandeGestion implements CommandeGestionLocal {

    private static final int DEFAULT_MONTHS_AMOUNT = 36;

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public List<Commande> getCommandesByClient(Client client, int monthsAmount) {
        Calendar calNow = Calendar.getInstance();
        calNow.add(Calendar.MONTH, -Math.abs(monthsAmount));
        Date date = calNow.getTime();

        Query qr = em.createNamedQuery("entities.Commande.getByClient");
        qr.setParameter("paramClient", client);
        qr.setParameter("paramDate", date);
        List<Commande> orders = qr.getResultList();

        for (Commande order : orders) {
            retrieveOrderLines(order);
        }

        return orders;
    }

    @Override
    public List<Commande> getCommandesByClient(Client client) {
        return getCommandesByClient(client, DEFAULT_MONTHS_AMOUNT);
    }

    @Override
    public Commande getCommandeByNumero(long number) {
        Commande order = em.find(Commande.class, number);
        retrieveOrderLines(order);
        return order;
    }

    @Override
    public Commande getCommandeByNumero(long number, Client client) {
        Commande order = getCommandeByNumero(number);
        return order.getClient().equals(client) ? order : null;
    }

    private void retrieveOrderLines(Commande order) {
        Query qrOrder = em.createNamedQuery("entities.LigneCommande.getByCommande");
        qrOrder.setParameter("paramCommande", order);
        List<LigneCommande> orderLines = qrOrder.getResultList();
        order.setLignesCommande(orderLines);
        for (LigneCommande orderLine : orderLines) {
            retrieveTickets(orderLine);
        }
    }

    private void retrieveTickets(LigneCommande orderLine) {
        Query qrOrderLine = em.createNamedQuery("entities.Billet.selectByLigneCommande");
        qrOrderLine.setParameter("paramLigneCommande", orderLine);
        List<Billet> tickets = qrOrderLine.getResultList();
        orderLine.setBillets(tickets);
    }

}
