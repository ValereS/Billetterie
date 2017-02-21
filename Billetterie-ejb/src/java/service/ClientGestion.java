/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

    public Client selectClientByEmail(String email, String mdp){
        Query qr = em.createNamedQuery("entities.Client.selectClientByEmail");
        qr.setParameter("paramEmail", email);
        qr.setParameter("paramHashMotPasse", mdp);
        Client c = (Client) qr.getSingleResult();
        return c;
    }
            
}
