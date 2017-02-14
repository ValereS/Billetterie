package service.testdata;

import entities.Billet;
import entities.TVA;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestDataValere implements TestDataValereLocal {
    @PersistenceContext(unitName = "magasinEJB-v02-ejbPU")
    private EntityManager em;

    @Override
    public void creerLesDonnees(){
        TVA tva01 = new TVA();
        tva01.setTaux(0.055f);
        
        Billet b01 = new Billet();
        b01.setNumero("A00001");
        b01.setTva(tva01);
        
        em.persist(b01);
        
    }
}
