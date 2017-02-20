/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.testdata;

import entities.Pays;
import entities.Region;
import entities.Ville;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi515
 */
@Stateless
public class TestDataPhiLong implements TestDataPhiLongLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public void create() {
        Pays paysFrance = new Pays("France");
        Pays paysSuisse = new Pays("Suisse");
        
        Region regionIleDeFrance = new Region("Île-de-France", paysFrance);
        Region regionPicardie = new Region("Picardie", paysFrance);
        Region regionProvenceAlpesCotedAzur = new Region("Provence-Alpes-Côte d'Azur", paysFrance);
        
        Ville villeParis = new Ville("Paris", "75000", regionIleDeFrance);
        
        em.persist(villeParis);
        
        em.persist(paysFrance);
        em.persist(paysSuisse);
    }
}
