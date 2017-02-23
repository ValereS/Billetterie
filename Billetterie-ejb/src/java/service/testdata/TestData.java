/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.testdata;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TestData implements TestDataLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @EJB
    private TestDataValerianLocal testDataValerian;

    @EJB
    private TestDataValereLocal testDataValere;

    @EJB
    private TestDataPhiLongLocal testDataPhiLong;

    @EJB
    private TestDataYoanLocal testDataYoan;

    @EJB
    private TestDataInnaLocal testDataInna;

    @Override
    public void create() {
        testDataValere.creerDonnees();
        testDataPhiLong.create();
        testDataYoan.create();
        testDataValerian.jeuValerian();
        testDataInna.create();
    }

    @Override
    public boolean exists() {
        Query qr = em.createNamedQuery("entities.Spectacle.select");
        List resultList = qr.getResultList();
        return !resultList.isEmpty();
    }

}
