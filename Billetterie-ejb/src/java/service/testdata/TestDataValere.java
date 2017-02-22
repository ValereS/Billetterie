package service.testdata;

import entities.Billet;
import entities.Categorie;
import entities.Image;
import entities.LigneCommande;
import entities.Place;
import entities.Seance;
import entities.SousTheme;
import entities.Spectacle;
import entities.Tarif;
import entities.Tva;
import entities.TypeBillet;
import enums.StatutSeance;
import enums.StatutSpectacle;
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
        
//-----------------------[ IMAGE ]----------------------------

        Image imgDisneyLando = new Image("http://www.hellodisneyland.com/wp-content/uploads/2017/01/titreSOF.jpg");
        Image imgMaroon5 = new Image("http://www.kiss985.com/sites/g/files/giy656/f/styles/delta__775x515/public/Events/Maroon5.jpg?itok=O2fZP3eD&c=a540186afedfbae631a6b24b5f8304d9");
        Image imgLaibach = new Image("http://www.lagrosseradio.com/webzine/images/11215.jpg");
        Image imgPsjMonaco = new Image("http://resize-football.ladmedia.fr/r/920,/crop/920,512/img/images/media/ligue-1/articles/rennes-monaco-les-notes/rennes-monaco-notes/5497562-1-fre-FR/rennes-monaco-notes.png");
        
//-----------------------[  TVA  ]----------------------------
        Tva tva5v5p = new Tva(0.055f);
        Tva tva2v1p = new Tva(0.021f);
        Tva tva10p = new Tva(0.1f);

//-----------------------[ TARIF ]----------------------------

        Tarif tf01J = new Tarif(new BigDecimal("20"), "TARIF JEUNE");
        Tarif tf01E = new Tarif(new BigDecimal("15"), "TARIF ENFANT");
        Tarif tf01N = new Tarif(new BigDecimal("25.99"), "TARIF NORMAL");

        Tarif tf02J = new Tarif(new BigDecimal("30"), "TARIF JEUNE");
        Tarif tf02E = new Tarif(new BigDecimal("20"), "TARIF ENFANT");
        Tarif tf02N = new Tarif(new BigDecimal("35.99"), "TARIF NORMAL");

        Tarif tfParc01 = new Tarif(new BigDecimal("39.99"), "TARIF ENFANT");
        Tarif tfParc02 = new Tarif(new BigDecimal("60"), "TARIF NORMAL");
        
        Tarif tfLaibachF = new Tarif(new BigDecimal("64"), "TARIF NORMAL");
        Tarif tfLaibachD = new Tarif(new BigDecimal("90"), "TARIF NORMAL");
        
//-----------------------[ IMAGE ]----------------------------

        Image imgDisneyLando = new Image("http://www.hellodisneyland.com/wp-content/uploads/2017/01/titreSOF.jpg");
        Image imgMaroon5 = new Image("http://www.kiss985.com/sites/g/files/giy656/f/styles/delta__775x515/public/Events/Maroon5.jpg?itok=O2fZP3eD&c=a540186afedfbae631a6b24b5f8304d9");
        Image imgLaibach = new Image("http://www.lagrosseradio.com/webzine/images/11215.jpg");
        Image imgPsjMonaco = new Image("http://resize-football.ladmedia.fr/r/920,/crop/920,512/img/images/media/ligue-1/articles/rennes-monaco-les-notes/rennes-monaco-notes/5497562-1-fre-FR/rennes-monaco-notes.png");
        

//-----------------------[ CATEGORIE ]----------------------------
        Categorie cat01 = new Categorie("A");
        Categorie cat02 = new Categorie("B");
        Categorie cat03 = new Categorie("C");
        Categorie catParcAttraction01 = new Categorie("AAA");
        Categorie catPlaceDebout = new Categorie("Fosse");
        Categorie catPlaceAssise = new Categorie("Balcon");

//-------------------[ TARIF SET CATEGORIE ]------------------------
        tf01J.setCategorie(cat01);
        tf01N.setCategorie(cat02);
        tf01E.setCategorie(cat03);
        tf02N.setCategorie(cat01);
        tf02E.setCategorie(cat02);
        tf02J.setCategorie(cat03);
        tfLaibachD.setCategorie(catPlaceAssise);
        tfLaibachF.setCategorie(catPlaceDebout);

        em.persist(tf01J);
        em.persist(tf01E);
        em.persist(tf01N);
        em.persist(tf02J);
        em.persist(tf02N);
        em.persist(tf02E);
        em.persist(tfParc01);
        em.persist(tfParc02);
        
        em.persist(tfLaibachD);
        em.persist(tfLaibachF);
        
        tfParc01.setCategorie(catParcAttraction01);
        tfParc02.setCategorie(catParcAttraction01);

//-----------------------[ TYPEBILLET ]----------------------------
        TypeBillet tbPlacesNumerotees = new TypeBillet("places numérotées");
        TypeBillet tbPlaceLibre = new TypeBillet("places non-numérotées");

            
//-----------------------[ LIGNECOMMANDE ]----------------------------
        LigneCommande lc01 = new LigneCommande();
        lc01.setPrix(tf02J.getPrix());
        lc01.setTauxTva(tva5v5p.getTaux());

//-----------------------[ SOUSTHEMES ]----------------------------
            
            SousTheme football = new SousTheme("Football");
            SousTheme famille = new SousTheme("Famille");
            SousTheme cirque = new SousTheme("Cirque");
            SousTheme parcAttr = new SousTheme("Parc d'Attraction");
            SousTheme concert = new SousTheme("Concert");
            
            
//-----------------------[  DATE  ]----------------------------
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
//-----------------------[ SPECTACLES ]----------------------------
            
            Spectacle spctPSJMonaco = new Spectacle("PSJ - Monaco", "125ème représentation sportive", StatutSpectacle.ACTIF);
            spctPSJMonaco.setImage(imgPsjMonaco);
            spctPSJMonaco.setSoustheme(football);
            Spectacle spctDisneyLando = new Spectacle("DisneyLandoCadrissian", "", StatutSpectacle.ACTIF);
            spctDisneyLando.setImage(imgDisneyLando);
            spctDisneyLando.setSoustheme(parcAttr);
            Spectacle spctmaroon6 = new Spectacle("Maroon 6", "", StatutSpectacle.ACTIF);
            spctmaroon6.setImage(imgMaroon5);
            spctmaroon6.setSoustheme(concert);
            Spectacle spctlaibach = new Spectacle("Laibach", "", StatutSpectacle.ACTIF);
            spctlaibach.setImage(imgLaibach);
            spctlaibach.setSoustheme(concert);
//-----------------------[ SEANCE ]----------------------------            
            Seance s01 = new Seance(d01, StatutSeance.ACTIF, spctmaroon6);
            Seance s02 = new Seance(d02, StatutSeance.ACTIF, spctmaroon6);

            Seance s03 = new Seance(d10, StatutSeance.ACTIF, spctDisneyLando);

            Seance s04 = new Seance(d05, StatutSeance.ACTIF, spctlaibach);
            
            Seance s05 = new Seance(d05, StatutSeance.ACTIF, spctPSJMonaco);
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
            Billet b01 = new Billet("AA001", tva5v5p, tbPlacesNumerotees, s01, cat01);
            Billet b02 = new Billet("AA002", tva5v5p, tbPlacesNumerotees, s01, cat02);
            Billet b03 = new Billet("AA003", tva5v5p, tbPlaceLibre, s01, cat03);
            Billet b04 = new Billet("AA004", tva5v5p, tbPlacesNumerotees, s01, cat02);
            Billet b05 = new Billet("AA005", tva5v5p, tbPlacesNumerotees, s01, cat01);
            Billet b06 = new Billet("AA006", tva5v5p, tbPlaceLibre, s01, cat03);

            Billet b07 = new Billet("AA007", tva5v5p, tbPlaceLibre, s02, cat03);
            Billet b08 = new Billet("AA008", tva5v5p, tbPlaceLibre, s02, cat03);
            Billet b09 = new Billet("AA009", tva5v5p, tbPlaceLibre, s02, cat03);
            Billet b10 = new Billet("AA010", tva5v5p, tbPlaceLibre, s02, cat03);

            Billet b11 = new Billet("01BT0A011", tva10p, tbPlaceLibre, s03, catParcAttraction01);
            Billet b12 = new Billet("01BT0A012", tva10p, tbPlaceLibre, s03, catParcAttraction01);
            Billet b13 = new Billet("01BT0A013", tva10p, tbPlaceLibre, s03, catParcAttraction01);
            Billet b14 = new Billet("02BT0A014", tva10p, tbPlaceLibre, s03, catParcAttraction01);
            Billet b15 = new Billet("02BT0A015", tva10p, tbPlaceLibre, s03, catParcAttraction01);
            Billet b16 = new Billet("02BT0A016", tva10p, tbPlaceLibre, s03, catParcAttraction01);

            Billet b17 = new Billet("01LGBT0A017", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b18 = new Billet("01LGBT0A018", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b19 = new Billet("01LGBT0A019", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b20 = new Billet("01LGBT0A020", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b21 = new Billet("01LGBT0A021", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b22 = new Billet("01LGBT0A022", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b23 = new Billet("01LGBT0A023", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b24 = new Billet("01LGBT0A024", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b25 = new Billet("01LGBT0A025", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b26 = new Billet("01LGBT0A026", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b27 = new Billet("01LGBT0A027", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b28 = new Billet("01LGBT0A028", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b29 = new Billet("01LGBT0A029", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b30 = new Billet("01LGBT0A030", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b31 = new Billet("01LGBT0A031", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b32 = new Billet("01LGBT0A032", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b33 = new Billet("01LGBT0A033", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b34 = new Billet("01LGBT0A034", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b35 = new Billet("01LGBT0A035", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b36 = new Billet("01LGBT0A036", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b37 = new Billet("01LGBT0A037", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            Billet b38 = new Billet("01LGBT0A038", tva5v5p, tbPlaceLibre, s04, catPlaceDebout);
            
            Billet b39 = new Billet("02LGBT0A001", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise);
            Billet b40 = new Billet("02LGBT0A002", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise);
            Billet b41 = new Billet("02LGBT0A003", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise);
            Billet b42 = new Billet("02LGBT0A004", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise);
            Billet b43 = new Billet("02LGBT0A005", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise);
            
            Billet b44 = new Billet("HGD01", tva5v5p, tbPlacesNumerotees, s05, catPlaceAssise);
            Billet b45 = new Billet("HGD02", tva5v5p, tbPlacesNumerotees, s05, catPlaceAssise);
            Billet b46 = new Billet("HGD03", tva5v5p, tbPlacesNumerotees, s05, catPlaceAssise);
            Billet b47 = new Billet("HGD04", tva5v5p, tbPlacesNumerotees, s05, catPlaceAssise);

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
            em.persist(b21);
            em.persist(b22);
            em.persist(b23);
            em.persist(b24);
            em.persist(b25);
            em.persist(b26);
            em.persist(b27);
            em.persist(b28);
            em.persist(b29);
            em.persist(b30);
            em.persist(b31);
            em.persist(b32);
            em.persist(b33);
            em.persist(b34);
            em.persist(b35);
            em.persist(b36);
            em.persist(b37);
            em.persist(b38);
            em.persist(b39);
            em.persist(b40);
            em.persist(b41);
            em.persist(b42);
            em.persist(b43);
            em.persist(b44);
            em.persist(b45);
            em.persist(b46);
            em.persist(b47);

            em.persist(lc01);
        } catch (ParseException ex) {
            Logger.getLogger(TestDataValere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
