package service.TestData;

import entities.Billet;
import entities.Categorie;
import entities.LigneCommande;
import entities.Tarif;
import entities.Tva;
import entities.TypeBillet;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
        Tva tva03 = new Tva(0.1f);

//-----------------------[ TARIF ]----------------------------
        
        BigDecimal bd01 = new BigDecimal(BigInteger.ONE);
        
        Tarif tf01 = new Tarif(BigDecimal.valueOf(20d), "TARIF JEUNE");
        Tarif tf02 = new Tarif(BigDecimal.valueOf(15d), "TARIF ENFANT");
        Tarif tf03 = new Tarif(BigDecimal.valueOf(25d), "TARIF NORMAL");
        
        ArrayList<Tarif> tarifNJE = new ArrayList<>();
        tarifNJE.add(tf01);
        tarifNJE.add(tf02);
        tarifNJE.add(tf03);
        
        ArrayList<Tarif> tarifN = new ArrayList<>();
        tarifNJE.add(tf03);
        
        ArrayList<Tarif> tarifNE = new ArrayList<>();
        tarifNJE.add(tf02);
        tarifNJE.add(tf03);
        
        
        TypeBillet tb01 = new TypeBillet("places numérotées");
        TypeBillet tb02 = new TypeBillet("places non-numérotées");
        
        LigneCommande lc01 = new LigneCommande();
        lc01.setPrix(tf01.getPrix());
        lc01.setTauxTva(tva01.getTaux());

//-----------------------[ CATEGORIE ]----------------------------
        Categorie cat01 = new Categorie("A");
        Categorie cat02 = new Categorie("B");
        Categorie cat03 = new Categorie("C");
        cat01.setTarifs(tarifN);
        cat02.setTarifs(tarifNE);
        cat03.setTarifs(tarifNJE);
        
//-----------------------[ BILLET ]----------------------------
        
        Billet b01 = new Billet("AA001", tva01, tb01, cat01);
        Billet b02 = new Billet("AA002", tva01, tb01, cat02);
        Billet b03 = new Billet("AA003", tva01, tb02, cat03);
        Billet b04 = new Billet("AA004", tva01, tb01, cat02);
        Billet b05 = new Billet("AA005", tva01, tb01, cat01);
        Billet b06 = new Billet("AA006", tva01, tb02, cat03);
        
//-----------------------[ PLACE ]----------------------------
        
        em.persist(tb01);
        em.persist(tb02);
        
        em.persist(cat01);
        em.persist(cat02);
        em.persist(cat03);
        
//        em.persist(tf01);
//        em.persist(tf02);
//        em.persist(tf03);
        
        em.persist(b01);
        em.persist(b02);
        em.persist(b03);
        em.persist(b04);
        em.persist(b05);
        em.persist(b06);
        
        em.persist(lc01);
    }
}
