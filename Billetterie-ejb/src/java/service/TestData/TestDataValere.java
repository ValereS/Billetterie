package service.TestData;

import entities.Billet;
import entities.Tva;
import entities.TypeBillet;
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
        
        TypeBillet tb01 = new TypeBillet();
        tb01.setDescription("places numerotees");
        
        Billet b01 = new Billet();
        b01.setTva(tva02);
        b01.setNumero("tata");
        b01.setTypeBillet(tb01);
        
        
        
        em.persist(tva01);
        em.persist(tva02);
        em.persist(tb01);
        em.persist(b01);
    }
}
