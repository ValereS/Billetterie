/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.TestData;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi505
 */
@Stateless
public class TestData implements TestDataLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @EJB
    private TestDataValereLocal testDataValere;

    @EJB
    private TestDataPhiLongLocal testDataPhiLong;

    @Override
    public void create() {
        testDataValere.creerDonnees();
        testDataPhiLong.create();
    }
}
