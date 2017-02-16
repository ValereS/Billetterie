package service.TestData;

import entities.Billet;
import entities.Categorie;
import entities.LigneCommande;
import entities.Seance;
import entities.Tarif;
import entities.Tva;
import entities.TypeBillet;
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

    @Override
    public void creerDonnees() {
        Tva tva01 = new Tva(0.055f);
        Tva tva02 = new Tva(0.021f);
        Tva tva03 = new Tva(0.1f);
        
        em.persist(tva01);
        em.persist(tva02);
        em.persist(tva03);
    }
    
    public void creerDonnees2() {
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

            Seance s01 = new Seance(d01, "");
            Seance s02 = new Seance(d02, "");
            Seance s03 = new Seance(d03, "");
            Seance s04 = new Seance(d04, "");
            Seance s05 = new Seance(d05, "");
            Seance s06 = new Seance(d06, "");
            Seance s07 = new Seance(d07, "");
            Seance s08 = new Seance(d08, "");
            Seance s09 = new Seance(d09, "");
            Seance s10 = new Seance(d10, "");
            Seance s11 = new Seance(d11, "");
            Seance s12 = new Seance(d12, "");
            Seance s13 = new Seance(d13, "");
            Seance s14 = new Seance(d14, "");
            Seance s15 = new Seance(d15, "");
            Seance s16 = new Seance(d16, "");

//-----------------------[ BILLET ]----------------------------
            Billet b01 = new Billet("AA001", tva01, tb01, s01, cat01);
            Billet b02 = new Billet("AA002", tva01, tb01, cat02);
            Billet b03 = new Billet("AA003", tva01, tb02, cat03);
            Billet b04 = new Billet("AA004", tva01, tb01, cat02);
            Billet b05 = new Billet("AA005", tva01, tb01, cat01);
            Billet b06 = new Billet("AA006", tva01, tb02, cat03);
            Billet b07 = new Billet("AA007", tva01, tb02, s02, cat03);
            Billet b08 = new Billet("AA008", tva01, tb02, s02, cat03);
            Billet b09 = new Billet("AA009", tva01, tb02, s02, cat03);
            Billet b10 = new Billet("AA010", tva01, tb02, s02, cat03);

            Billet b11 = new Billet("AA010", tva01, tb02, cat03);
            Billet b12 = new Billet("AA010", tva01, tb02, cat03);
            Billet b13 = new Billet("AA010", tva01, tb02, cat03);
            Billet b14 = new Billet("AA010", tva01, tb02, cat03);
            Billet b15 = new Billet("AA010", tva01, tb02, cat03);
            Billet b16 = new Billet("AA010", tva01, tb02, cat03);
            Billet b17 = new Billet("AA010", tva01, tb02, cat03);
            Billet b18 = new Billet("AA010", tva01, tb02, cat03);
            Billet b19 = new Billet("AA010", tva01, tb02, cat03);
            Billet b20 = new Billet("AA010", tva01, tb02, cat03);

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
        } catch (ParseException ex) {
            Logger.getLogger(TestDataValere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
