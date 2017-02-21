/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.testdata;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi515
 */
@Stateless
public class TestData implements TestDataLocal {
    @EJB
    private TestDataValerianLocal testDataValerian;

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @EJB
    private TestDataValereLocal testDataValere;

    @EJB
    private TestDataPhiLongLocal testDataPhiLong;
    
    @EJB
    private TestDataYoanLocal testDataYoan;
    
    
    @Override
    public void create() {
        testDataValere.creerDonnees();
        testDataPhiLong.create();
        testDataYoan.create();
        testDataValerian.jeuValerian();
    }
}
