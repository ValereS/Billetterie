package service.TestData;

import entities.Billet;
import entities.Tva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestDataValere implements TestDataValereLocal {
    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public void creerDonnees(){
        Tva tva01 = new Tva(0.055f);
        Tva tva02 = new Tva(0.021f);
        
        Billet b01 = new Billet();
        b01.setTva(tva02);
        b01.setNumero("toto");
        
        em.persist(tva01);
        em.persist(b01);
    }
}
