/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Client;
import entities.Commande;
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
        List<Commande> commandes = qr.getResultList();
        return commandes;
    }

    @Override
    public List<Commande> getCommandesByClient(Client client) {
        return getCommandesByClient(client, DEFAULT_MONTHS_AMOUNT);
    }

}
