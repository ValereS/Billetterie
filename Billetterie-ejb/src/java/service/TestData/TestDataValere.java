package service.TestData;

import entities.Billet;
import entities.Categorie;
import entities.LigneCommande;
import entities.Seance;
import entities.Tarif;
import entities.Tva;
import entities.TypeBillet;
import enums.StatutSeance;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestDataValere implements TestDataValereLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;


    public void creerDonneesNotWorking() {
        Tarif tf01 = new Tarif(new BigDecimal("20"), "TARIF JEUNE");
        Tarif tf02 = new Tarif(new BigDecimal("15"), "TARIF ENFANT");
        Tarif tf03 = new Tarif(new BigDecimal("25.99"), "TARIF NORMAL");
        
        ArrayList<Tarif> tarifNJE = new ArrayList<>();
        tarifNJE.add(tf01);
        tarifNJE.add(tf02);
        tarifNJE.add(tf03);

        ArrayList<Tarif> tarifN = new ArrayList<>();
        tarifNJE.add(tf03);

        ArrayList<Tarif> tarifNE = new ArrayList<>();
        tarifNJE.add(tf02);
        tarifNJE.add(tf03);
        
        Categorie cat01 = new Categorie("A");
        Categorie cat02 = new Categorie("B");
        Categorie cat03 = new Categorie("C");
        cat01.setTarifs(tarifN);
        cat02.setTarifs(tarifNE);
        cat03.setTarifs(tarifNJE);
        
//        tf01.setCategorie(cat01);
//        tf02.setCategorie(cat02);
//        tf03.setCategorie(cat03);
//        tf02.setCategorie(cat02);
//        tf01.setCategorie(cat01);
        
        
        em.persist(cat01);em.persist(cat02);em.persist(cat03);
    }

    @Override
    public void creerDonnees() {

//-----------------------[  TVA  ]----------------------------
        
        Tva tva5v5p = new Tva(0.055f);
        Tva tva2v1p = new Tva(0.021f);
        Tva tva10p = new Tva(0.1f);
        
//-----------------------[ TARIF ]----------------------------
        BigDecimal bd01 = new BigDecimal(BigInteger.ONE);

        Tarif tf01J = new Tarif(new BigDecimal("20"), "TARIF JEUNE");
        Tarif tf01E = new Tarif(new BigDecimal("15"), "TARIF ENFANT");
        Tarif tf01N = new Tarif(new BigDecimal("25.99"), "TARIF NORMAL");

        Tarif tf02J = new Tarif(new BigDecimal("30"), "TARIF JEUNE");
        Tarif tf02E = new Tarif(new BigDecimal("20"), "TARIF ENFANT");
        Tarif tf02N = new Tarif(new BigDecimal("35.99"), "TARIF NORMAL");

        Tarif tfParc01 = new Tarif(new BigDecimal("39.99"), "TARIF ENFANT");
        Tarif tfParc02 = new Tarif(new BigDecimal("65"), "TARIF NORMAL");
        
//-----------------------[ CATEGORIE ]----------------------------
        
        Categorie cat01 = new Categorie("A");
        Categorie cat02 = new Categorie("B");
        Categorie cat03 = new Categorie("C");
        Categorie catParcAttraction01 = new Categorie("AAA");
        
//-------------------[ TARIF SET CATEGORIE ]------------------------
        tf01J.setCategorie(cat01);
        tf01N.setCategorie(cat02);
        tf01E.setCategorie(cat03);
        tf02N.setCategorie(cat01);
        tf02E.setCategorie(cat02);
        tf02J.setCategorie(cat03);
        
        tfParc01.setCategorie(catParcAttraction01);
        tfParc02.setCategorie(catParcAttraction01);
        
//-----------------------[ TYPEBILLET ]----------------------------
        
        TypeBillet tb01 = new TypeBillet("places numérotées");
        TypeBillet tb02 = new TypeBillet("places non-numérotées");
        
//-----------------------[ LIGNECOMMANDE ]----------------------------
        
        LigneCommande lc01 = new LigneCommande();
        lc01.setPrix(tf02J.getPrix());
        lc01.setTauxTva(tva5v5p.getTaux());


//-----------------------[ SEANCE ]----------------------------
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf.setLenient(false);
        String s = "03/07/2017 21:00:00";
        Date d01;
        try {
            d01 = sdf.parse(s);
            Date d02 = sdf.parse("03/07/2017 18:00:00");
            Date d03 = sdf.parse("03/07/2017 21:00:00");
            Date d04 = sdf.parse("04/07/2017 18:00:00");
            Date d05 = sdf.parse("04/07/2017 21:00:00");
            Date d06 = sdf.parse("05/07/2017 18:00:00");
            Date d07 = sdf.parse("05/07/2017 21:00:00");
            Date d08 = sdf.parse("06/07/2017 18:00:00");
            Date d09 = sdf.parse("06/07/2017 21:00:00");

            Date d10 = sdf.parse("10/07/2017 09:00:00");
            Date d11 = sdf.parse("11/07/2017 09:00:00");
            Date d12 = sdf.parse("12/07/2017 09:00:00");
            Date d13 = sdf.parse("13/07/2017 09:00:00");
            Date d14 = sdf.parse("14/07/2017 09:00:00");
            Date d15 = sdf.parse("15/07/2017 09:00:00");

            Date d16 = sdf.parse("16/07/2017 20:30:00");
            Date d17 = sdf.parse("17/07/2017 20:30:00");
            Date d18 = sdf.parse("18/07/2017 20:30:00");
            Date d19 = sdf.parse("19/07/2017 20:30:00");
            Date d20 = sdf.parse("20/07/2017 20:30:00");

            Seance s01 = new Seance(d01, StatutSeance.ACTIF);
            Seance s02 = new Seance(d02, StatutSeance.ACTIF);
            
            Seance s03 = new Seance(d10, StatutSeance.ACTIF);
            
            Seance s04 = new Seance(d04, StatutSeance.ACTIF);
            Seance s05 = new Seance(d05, StatutSeance.ACTIF);
            Seance s06 = new Seance(d06, StatutSeance.ACTIF);
            Seance s07 = new Seance(d07, StatutSeance.ACTIF);
            Seance s08 = new Seance(d08, StatutSeance.ACTIF);
            Seance s09 = new Seance(d09, StatutSeance.ACTIF);
            Seance s10 = new Seance(d10, StatutSeance.ACTIF);
            Seance s11 = new Seance(d11, StatutSeance.ACTIF);
            Seance s12 = new Seance(d12, StatutSeance.ACTIF);
            Seance s13 = new Seance(d13, StatutSeance.ACTIF);
            Seance s14 = new Seance(d14, StatutSeance.ACTIF);
            Seance s15 = new Seance(d15, StatutSeance.ACTIF);
            Seance s16 = new Seance(d16, StatutSeance.ACTIF);

//-----------------------[ BILLET ]----------------------------
            Billet b01 = new Billet("AA001", tva5v5p, tb01, s01, cat01);
            Billet b02 = new Billet("AA002", tva5v5p, tb01, s01,cat02);
            Billet b03 = new Billet("AA003", tva5v5p, tb02, s01,cat03);
            Billet b04 = new Billet("AA004", tva5v5p, tb01, s01,cat02);
            Billet b05 = new Billet("AA005", tva5v5p, tb01, s01,cat01);
            Billet b06 = new Billet("AA006", tva5v5p, tb02, s01,cat03);

            Billet b07 = new Billet("AA007", tva5v5p, tb02, s02, cat03);
            Billet b08 = new Billet("AA008", tva5v5p, tb02, s02, cat03);
            Billet b09 = new Billet("AA009", tva5v5p, tb02, s02, cat03);
            Billet b10 = new Billet("AA010", tva5v5p, tb02, s02, cat03);

            Billet b11 = new Billet("01BT0A011", tva2v1p, tb02, s03, catParcAttraction01);
            Billet b12 = new Billet("01BT0A012", tva2v1p, tb02, s03, catParcAttraction01);
            Billet b13 = new Billet("01BT0A013", tva2v1p, tb02, s03, catParcAttraction01);
            Billet b14 = new Billet("02BT0A014", tva2v1p, tb02, s03, catParcAttraction01);
            Billet b15 = new Billet("02BT0A015", tva2v1p, tb02, s03, catParcAttraction01);
            Billet b16 = new Billet("02BT0A016", tva2v1p, tb02, s03, catParcAttraction01);
            
            Billet b17 = new Billet("01BT0A017", tva5v5p, tb02, cat03);
            Billet b18 = new Billet("01BT0A018", tva5v5p, tb02, cat03);
            Billet b19 = new Billet("01BT0A019", tva5v5p, tb02, cat03);
            Billet b20 = new Billet("01BT0A020", tva5v5p, tb02, cat03);

//-----------------------[ PLACE ]----------------------------

            em.persist(b01);
            em.persist(b02);
            em.persist(b03);
            em.persist(b04);
            em.persist(b05);
            em.persist(b06);
            em.persist(b07);
            em.persist(b08);
            em.persist(b09);
            em.persist(b10);
            em.persist(b11);
            em.persist(b12);
            em.persist(b13);
            em.persist(b14);
            em.persist(b15);
            em.persist(b16);
            em.persist(b17);
            em.persist(b18);
            em.persist(b19);
            em.persist(b20);

            em.persist(lc01);
        } catch (ParseException ex) {
            Logger.getLogger(TestDataValere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
