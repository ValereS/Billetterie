/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.testdata;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cdi515
 */
@Stateless
public class TestData implements TestDataLocal {
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
}
