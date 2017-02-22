/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi505
 */
@Stateless
public class ClientGestion implements ClientGestionLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    
    @Override
    public Client selectByEmailPwd(String email, String mdp) {
        Query qr = em.createNamedQuery("entities.Client.selectByEmailPwd");
        qr.setParameter("paramEmail", email);
        qr.setParameter("paramHashMotPasse", mdp);
        try {
            Client c = (Client) qr.getSingleResult();
            return c;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Client selectByEmail(String email) {
        Query qr = em.createNamedQuery("entities.Client.selectByEmail");
        qr.setParameter("paramEmail", email);
        try {
            Client c = (Client) qr.getSingleResult();
            return c;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void create(Client client) {
        em.persist(client);
    }
    

}
