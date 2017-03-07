/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.testdata;

import entities.Billet;
import entities.Categorie;
import entities.Client;
import entities.Commande;
import entities.Coordonnees;
import entities.Evenement;
import entities.Fonction;
import entities.Groupe;
import entities.Image;
import entities.Lieu;
import entities.LigneCommande;
import entities.ModeExpedition;
import entities.Paiement;
import entities.Participant;
import entities.Pays;
import entities.Place;
import entities.PointRetrait;
import entities.Region;
import entities.Seance;
import entities.SousTheme;
import entities.Spectacle;
import entities.Tarif;
import entities.Theme;
import entities.Tva;
import entities.TypeBillet;
import entities.Ville;
import entities.Zone;
import enums.CiviliteClient;
import enums.ModePaiement;
import enums.StatutClient;
import enums.StatutCommande;
import enums.StatutModeExpedition;
import enums.StatutPointRetrait;
import enums.StatutSeance;
import enums.StatutSpectacle;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TestData implements TestDataLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public boolean exists() {
        Query qr = em.createNamedQuery("entities.Spectacle.countAll");
        long count = (long) qr.getSingleResult();
        return count > 0;
    }

    @Override
    public void create() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            sdf.setLenient(false);

            /////////////////////////////// start Valère !!!!
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
 //================================== ZONE ======================================
            Zone z01 = new Zone("A1", "1", "Tribune est");
            Zone z02 = new Zone("B1", "2", "Tribune sud");
            Zone z03 = new Zone("C1", "3", "Tribune nord");
            Zone z04 = new Zone("A2", "1", "Tribune nord-est");
            Zone z05 = new Zone("B2", "2", "Tribune sud-ouest");
            Zone z06 = new Zone("C2", "3", "Tribune ouest");
            Zone z07 = new Zone("A3", "4", "Fosse");
            Zone z08 = new Zone("B3", "3", "Fosse");
            Zone entreeParc = new Zone(null,null,"Libre");
            Zone balcond = new Zone("VIP","Entrée A","balcon droit");
            Zone balcong = new Zone("VIP","Entrée B","balcon gauche");
            
            
//-----------------------[ CATEGORIE ]----------------------------
            Categorie cat01 = new Categorie("A");
            Categorie cat02 = new Categorie("B");
            Categorie cat03 = new Categorie("C");
            Categorie catParcAttraction01 = new Categorie("AAA");
            Categorie catPlaceDebout = new Categorie("Fosse");
            Categorie catPlaceAssise = new Categorie("Balcon");
            
            catPlaceAssise.getZones().add(balcond);
            catPlaceAssise.getZones().add(balcong);
            catPlaceDebout.getZones().add(z07);
            catPlaceDebout.getZones().add(z08);
            cat01.getZones().add(z01);
            cat01.getZones().add(z04);
            cat01.getZones().add(z07);
            cat02.getZones().add(z02);
            cat02.getZones().add(z05);
            cat02.getZones().add(z08);
            cat03.getZones().add(z03);
            cat03.getZones().add(z06);
            catParcAttraction01.getZones().add(entreeParc);
            
            em.persist(cat01);
            em.persist(cat02);
            em.persist(cat03);
            em.persist(catParcAttraction01);
            em.persist(catPlaceDebout);
            em.persist(catPlaceAssise);


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
            Theme t01 = new Theme("Musique");
            concert.setTheme(t01);

//-----------------------[  DATE  ]----------------------------
            String s = "03/07/2017 21:00:00";
            Date d01;
            Spectacle spctmaroon6;
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
//============================== SOUS THEME ====================================
            //   Musique
            SousTheme st01 = concert;//new SousTheme("Concert");
            SousTheme st02 = new SousTheme("Festival");
            SousTheme st03 = new SousTheme("Classique et Opéra");
            SousTheme st04 = new SousTheme("Spectacle et Comédie Musicale");
            //   Arts & Spectacles

            SousTheme st06 = new SousTheme("Humour");
            SousTheme st07 = new SousTheme("Exposition et Musée");
            SousTheme st08 = new SousTheme("Théâtre");

            SousTheme st10 = new SousTheme("Famille / Enfants");
            SousTheme st11 = new SousTheme("Danse");
            SousTheme st12 = new SousTheme("Cabaret");
            //    Sport
            SousTheme st13 = football;//new SousTheme("Football");
            SousTheme st14 = new SousTheme("Rugby");
            SousTheme st15 = new SousTheme("Basket");
            SousTheme st16 = new SousTheme("Handball");
            SousTheme st17 = new SousTheme("Volley");
            SousTheme st18 = new SousTheme("Hockey");
            SousTheme st19 = new SousTheme("Auto");
            SousTheme st20 = new SousTheme("Moto");
            SousTheme st21 = new SousTheme("Tennis");
            SousTheme st22 = new SousTheme("Combat");
            SousTheme st23 = new SousTheme("Athlétiste");
            SousTheme st24 = new SousTheme("Autre");
            //    Famille & loisirs
            SousTheme st25 = new SousTheme("Parc");
            SousTheme st26 = new SousTheme("Salon");

            SousTheme st28 = new SousTheme("Monuments / Lieux Touristiques");

            SousTheme st30 = cirque;//new SousTheme("Cirque");
            SousTheme st31 = new SousTheme("Loisirs et Tourisme");

//============================ EVENEMENT =======================================
            Evenement ev01 = new Evenement("Championnat du monde hockey");
            Evenement ev02 = new Evenement("Salon international de l'agriculture");
            Evenement ev03 = new Evenement("Jeux Olympique 2016");
            Evenement ev04 = new Evenement("Jeux Olympique 2020");
            Evenement ev05 = new Evenement("Euro");
            Evenement ev06 = new Evenement("Fête de la musique 2017");
            Evenement ev07 = new Evenement("Summer Break");
            Evenement ev08 = new Evenement("Solde Parc");            
//-----------------------[ SPECTACLES ]----------------------------

            Spectacle spctPSJMonaco = new Spectacle("PSJ - Monaco", "125ème représentation sportive", StatutSpectacle.ACTIF,st13,ev05);
            spctPSJMonaco.setImage(imgLaibach);
            Spectacle spctDisneyLando = new Spectacle("DisneyLandoCadrissian", "Il est ou mickey ?", StatutSpectacle.ACTIF,st25,ev08);
            spctPSJMonaco.setImage(imgPsjMonaco);
            spctDisneyLando.setImage(imgDisneyLando);
            spctmaroon6 = new Spectacle("Maroon 6", "Maroon 5 est un groupe américain de pop rock, originaire de Los Angeles, en Californie.", StatutSpectacle.ACTIF,null,ev06);
            spctmaroon6.setImage(imgMaroon5);
            spctmaroon6.setSousTheme(concert);
            Spectacle spctlaibach = new Spectacle("Laibach", "Lalilalilaloum", StatutSpectacle.ACTIF,null,ev06);
            spctlaibach.setImage(imgLaibach);
            spctlaibach.setSousTheme(concert);

//-----------------------[ SEANCE ]----------------------------            
            Seance s01 = new Seance(d01, StatutSeance.ACTIF, spctmaroon6);
            // test valérian afficher un lieu pour une séance ( SHOWDISPLAY )
            Lieu l01 = new Lieu("Grosse salle", "Carto", "Cette salle est grosse");
            s01.setLieu(l01);
            
            Ville reims = new Ville("Reims", "51100");
            Coordonnees testCo = new Coordonnees("", "", "v", "84", "rue", "du Dr Lemoine", "03", "06", reims);
            l01.setCoordonnees(testCo);
            Image imageCarto = new Image("http://bonnesadressesremoises.fr/wp-content/uploads/2014/02/cartonnerie-reims-credit-collectif_marge_noire.jpg");
            l01.setImage(imageCarto);

            Seance s02 = new Seance(d02, StatutSeance.ACTIF, spctmaroon6);
            s02.getCategories().add(cat03);
            s02.getCategories().add(cat02);
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


        /////////////////////////////// stop Valère !!!!

            // Phi-Long
            Pays paysFrance = new Pays("France");
            Pays paysSuisse = new Pays("Suisse");

            Region regionIleDeFrance = new Region("Île-de-France", paysFrance);
            Region regionPicardie = new Region("Picardie", paysFrance);
            Region regionProvenceAlpesCotedAzur = new Region("Provence-Alpes-Côte d'Azur", paysFrance);
            Region cantonDeGeneve = new Region("Canton de Genève", paysSuisse);

            Ville villeParis = new Ville("Paris 12e", "75012", regionIleDeFrance);
            Ville villeAmiens = new Ville("Amiens", "80000", regionPicardie);
            Ville villeMarseille = new Ville("Marseille 2er", "13002", regionProvenceAlpesCotedAzur);
            Ville villeGeneve = new Ville("Genève", "1200", cantonDeGeneve);

            Coordonnees coord01 = new Coordonnees("VU", "Jean", null, "30 bis", "rue", "Victor Hugo", "+33149302017", null, villeParis);
            Coordonnees coord02 = new Coordonnees("DUROND", "Olivier", null, "8", "rue", "de Paris", "+33345159498", null, villeAmiens);
            Coordonnees coord03 = new Coordonnees("LEGENDRE", "Yoann", null, "33", "rue", "du Marché", "+33445159498", null, villeMarseille);
            Coordonnees coord04 = new Coordonnees("MARIE", "Stéphanie", null, "8", "rue", "Voltaire", "+4145649548", null, villeGeneve);
            Coordonnees coordPointRetrait = new Coordonnees(null, null, "Billetterie", "6-8", "rue", "Georges et Maï Politzer", "+33174564894", null, villeParis);
            
            
            
            Client client01 = new Client(CiviliteClient.M, "VU", "Jean", "jean.vu@gmail.com", "toto", new GregorianCalendar(1980, 9, 22).getTime(), StatutClient.ACTIF, "");
            client01.setCoordonneesFacturation(coord01);

            Client client02 = new Client(CiviliteClient.M, "DUROND", "Olivier", "olivier.durond@gmail.com", "toto", new GregorianCalendar(1981, 0, 1).getTime(), StatutClient.ACTIF, "");
            client02.setCoordonneesFacturation(coord02);
            client02.getListeCoordonneesLivraison().add(coord03);
            client02.getListeCoordonneesLivraison().add(coord04);

            PointRetrait pointRetrait = new PointRetrait("Point Retrait 1", StatutPointRetrait.ACTIF, coordPointRetrait);

            em.persist(client01);
            em.persist(client02);
            em.persist(pointRetrait);
        // Phi-Long

            // Yoan

            //---------------------------- ROLES -----------------------------------
            Fonction f01 = new Fonction("basse");
            Fonction f02 = new Fonction("chant");
            Fonction f03 = new Fonction("clavier");
            Fonction f04 = new Fonction("guitare solo");
            Fonction f05 = new Fonction("choeur");
            Fonction f06 = new Fonction("guitare rythmique");
            Fonction f07 = new Fonction("batterie");
    //Fonction f08= new Fonction("percussions");

            //------------------------------------------------------------------------
            Fonction f20 = new Fonction("Jeff");
            Fonction f21 = new Fonction("Jean-Marc");
            Fonction f22 = new Fonction("Jacqueline"); // A voir    

            //------------------------------------------------------------------------
            Fonction f09 = new Fonction("Gardien de but");
            Fonction f10 = new Fonction("Defenseur");
            Fonction f11 = new Fonction("Milieu de terrain");
            Fonction f12 = new Fonction("Attaquant");
            Fonction f13 = new Fonction("Entraineur");

            //---------------------------------------------------------------------
            Fonction f14 = new Fonction("Anna");
            Fonction f15 = new Fonction("Elsa");
            Fonction f16 = new Fonction("Olaf le bonhomme de neige");
            Fonction f17 = new Fonction("Kristoff");
            Fonction f18 = new Fonction("Sven le renne");
            Fonction f19 = new Fonction("Hans le prince");
            Fonction f23 = new Fonction("Figurant01");
            Fonction f24 = new Fonction("Figurant02");

            //---------------------------- PARTICIPANT --------------------------------
            Participant p01 = new Participant("Jesse Carmichael");
            Participant p02 = new Participant("Adam Levine");
            Participant p03 = new Participant("James Valentine");
            Participant p04 = new Participant("Mickey Madden");
            Participant p05 = new Participant("Sam Farrar");
            Participant p06 = new Participant("Matt Flynn");

            //----------------------------------------------------------------------------
            Participant p07 = new Participant("Jeff Panacloc");

            //----------------------------------------------------------------------------
            // Gardien
            Participant p08 = new Participant("Kevin Trapp");
            Participant p09 = new Participant("Danijel Subasic");

            // DEF
            Participant p10 = new Participant("Thiago Silva");
            Participant p11 = new Participant("Djibril Sidibé");

            // MIL
            Participant p12 = new Participant("Marco Verratti");
            Participant p13 = new Participant("Thomas Lemar");

            // ATT
            Participant p14 = new Participant("Edinson Cavani");
            Participant p15 = new Participant("Radamel Falcao");

            // COACH
            Participant p16 = new Participant("Unai Emery");
            Participant p17 = new Participant("Leonardo Jardim");

            //---------------------------------------------------------------
            Participant p18 = new Participant("participant01");
            Participant p19 = new Participant("participant02");
            Participant p20 = new Participant("participant03");
            Participant p21 = new Participant("participant04");
            Participant p22 = new Participant("participant05");
            Participant p23 = new Participant("participant06");
            Participant p24 = new Participant("participant07"); // /!\ On sait jamais!!

            //================= ASSOCIATION FONCTIONS/PARTICIPANTS =====================
            // MARROON 5 ;
            f01.getParticipants().add(p04); // mickey madden bassiste
            f02.getParticipants().add(p02); // Adam Levine chant
            f03.getParticipants().add(p01); // Jesse Carmichael clavier
            f04.getParticipants().add(p03); // James Valentine guitare solo
            f05.getParticipants().add(p01); // Jesse Carmichael Choeur
            f05.getParticipants().add(p03); // James Valentine Choeur
            f05.getParticipants().add(p05); // Sam Farrar Choeur
            f06.getParticipants().add(p05); // Sam Farrar guitare rythmique
            f07.getParticipants().add(p06); // Matt Flynn batterie

            // JEFF PANACLOC
            f20.getParticipants().add(p07); // JEFF PANACLOC
            f21.getParticipants().add(p07); // Jean- Marc
            f22.getParticipants().add(p07); // Jacqueline

            // COUPE DE LA LIGUE 
            f09.getParticipants().add(p08); // Gardiens de but
            f09.getParticipants().add(p09);
            f10.getParticipants().add(p10); // Defenseurs
            f10.getParticipants().add(p11);
            f11.getParticipants().add(p12); // Millieu de terrain
            f11.getParticipants().add(p13);
            f12.getParticipants().add(p14); // Attaquants
            f12.getParticipants().add(p15);
            f13.getParticipants().add(p16); // Entraineurs
            f13.getParticipants().add(p17);

            // Disney sur Glace
            f14.getParticipants().add(p18); // Anna
            f15.getParticipants().add(p19); // Elsa
            f16.getParticipants().add(p20); // Olaf
            f17.getParticipants().add(p21); // Kristoff
            f18.getParticipants().add(p22); // Sven
            f19.getParticipants().add(p23); // Hans
            f23.getParticipants().add(p24); // Participant 07
            f24.getParticipants().add(p24); // Participant 07



            //===========================PERSISTANCE=======================
            // Persistance des fonctions
            em.persist(p01);
            em.persist(f01);
            em.persist(f02);
            em.persist(f03);
            em.persist(f04);
            em.persist(f05);
            em.persist(f06);
            em.persist(f07);
//        em.persist(f08);
            em.persist(f09);
            em.persist(f10);
            em.persist(f11);
            em.persist(f12);
            em.persist(f13);
            em.persist(f14);
            em.persist(f15);
            em.persist(f16);
            em.persist(f17);
            em.persist(f18);
            em.persist(f19);
            em.persist(f20);
            em.persist(f21);
            em.persist(f22);
            em.persist(f23);
            em.persist(f24);
        // Yoan

            // Valérian
       
//================================== PLACE =====================================
            Place pl01 = new Place("0321", "1", "Numérotée");
            Place pl02 = new Place("5468", "1", "Numérotée");
            Place pl03 = new Place("1536", "1", "Numérotée");
            Place pl04 = new Place("0151", "1", "Numérotée");
            Place pl05 = new Place("0981", "1", "Numérotée");
            Place pl06 = new Place("9621", "1", "Numérotée");
            Place pl07 = new Place("5621", "1", "Numérotée");
            Place pl08 = new Place("0661", "1", "Numérotée");
            Place pl09 = new Place("0991", "1", "Numérotée");
            Place pl10 = new Place("0881", "1", "Numérotée");
            Place pl11 = new Place("3541", "1", "Numérotée");
            Place pl12 = new Place("4591", "1", "Numérotée");
            
            pl01.setZone(z01);
            pl02.setZone(z02);
            pl03.setZone(z03);
            pl04.setZone(z04);
            pl05.setZone(z05);
            pl06.setZone(z06);
            pl07.setZone(z07);
            pl08.setZone(z08);
            pl09.setZone(z01);
            pl10.setZone(z02);
            pl11.setZone(z03);
            pl12.setZone(z04);
            
            em.persist(pl01);
            em.persist(pl02);
            em.persist(pl03);
            em.persist(pl04);
            em.persist(pl05);
            em.persist(pl06);
            em.persist(pl07);
            em.persist(pl08);
            em.persist(pl09);
            em.persist(pl10);
            em.persist(pl11);
            em.persist(pl12);
            
            
//================================== THEME =====================================        
            //Theme t01 = new Theme("Musique");
            Theme t02 = new Theme("Arts & Spectacles");
            Theme t03 = new Theme("Sport");
            Theme t04 = new Theme("Famille & Loisirs");

//=============================  COMMANDE ======================================  
            Commande co01 = new Commande(new BigDecimal("3.3"), StatutCommande.LIVREE, new GregorianCalendar(2017, 1, 3).getTime());
            Commande co02 = new Commande(new BigDecimal("6.35"), StatutCommande.ANNULEE, new GregorianCalendar(2017, 2, 17).getTime());
            Commande co03 = new Commande(new BigDecimal("0"), StatutCommande.COMMANDEE, new GregorianCalendar(2017, 1, 20).getTime());
            Commande co04 = new Commande(new BigDecimal("0"), StatutCommande.PAYEE, new GregorianCalendar(2017, 2, 10).getTime());
            Commande co05 = new Commande(new BigDecimal("14.5"), StatutCommande.LIVREE, new GregorianCalendar(2017, 1, 28).getTime());
            
            co01.setClient(client02);
            co02.setClient(client01);
            co03.setClient(client02);
            co04.setClient(client01);
            co05.setClient(client02);
            //facturation
            co01.setAdresseFacturation(coord01);
            co02.setAdresseFacturation(coord02);
            co03.setAdresseFacturation(coord04);
            co04.setAdresseFacturation(coord01);
            co05.setAdresseFacturation(coord01);
            //livraison
            co01.setAdresseLivraison(coordPointRetrait);
            co02.setAdresseLivraison(coord02);
            co03.setAdresseLivraison(coord04);
            co04.setAdresseLivraison(coord04);
            co05.setAdresseLivraison(coord03);
//============================= LIGNE COMMANDE =================================        
            //LigneCommande lc01 = new LigneCommande(new BigDecimal("44"), 0.2f, 0);
            LigneCommande lc02 = new LigneCommande(new BigDecimal("22"), 0.2f, 0.1f);
            LigneCommande lc03 = new LigneCommande(new BigDecimal("30"), 0.2f, 0);
            LigneCommande lc04 = new LigneCommande(new BigDecimal("25"), 0.2f, 0.1f);
            LigneCommande lc05 = new LigneCommande(new BigDecimal("49.99"), 0.2f, 0);

//============================ PAIEMENT ========================================
            Paiement paie01 = new Paiement(new BigDecimal("69.3"), ModePaiement.CB, new GregorianCalendar(2017, 1, 3).getTime());
            Paiement paie02 = new Paiement(new BigDecimal("25"), ModePaiement.CHEQUE, new GregorianCalendar(2017, 2, 16).getTime());
            Paiement paie03 = new Paiement(new BigDecimal("10"), ModePaiement.CHEQUE_CULTURE, new GregorianCalendar(2017, 2, 4).getTime());
            Paiement paie04 = new Paiement(new BigDecimal("20"), ModePaiement.CB, new GregorianCalendar(2017, 1, 28).getTime());
//================================= MODE EXPEDITION ============================
            ModeExpedition me01 = new ModeExpedition("Courrier Simple", new BigDecimal("3.30"), "Envoi postal par lettre simple. Cet envoi n'est pas proposé si les billets sont non numérotés.", StatutModeExpedition.ACTIF);
            ModeExpedition me02 = new ModeExpedition("Recommandé", new BigDecimal("6.35"), "Possibilité de tracer en temps réel sur internet où ce situe votre pli.", StatutModeExpedition.ACTIF);
            ModeExpedition me03 = new ModeExpedition("Retrait Magasin", new BigDecimal("0"), "Les billets sont à retirer uniquement dans les magasins participants.", StatutModeExpedition.ACTIF);
            ModeExpedition me04 = new ModeExpedition("Recommandé Etrangé", new BigDecimal("14.50"), "Possibilité de tracer en temps réel sur internet où ce situe votre pli.", StatutModeExpedition.ACTIF);

            co01.setModeExpedition(me01);
            co02.setModeExpedition(me02);
            co03.setModeExpedition(me03);
            co04.setModeExpedition(me03);
            co05.setModeExpedition(me04);
//============================== PAIEMENT COMMANDE =============================
            paie01.setCommande(co01);
            paie02.setCommande(co04);
            paie03.setCommande(co05);
            paie04.setCommande(co05);
//============================= COMMANDE// LIGNE ===============================
            lc01.setCommande(co01);
            lc02.setCommande(co02);
            lc03.setCommande(co03);
            lc04.setCommande(co04);
            lc03.setCommande(co05);
            lc02.setCommande(co01);
            lc04.setCommande(co02);
            lc05.setCommande(co03);

//============================= Assos THEME/SOUSTHEME ==========================   
            st01.setTheme(t01);
            st02.setTheme(t01);
            st03.setTheme(t01);
            st04.setTheme(t01);
            st06.setTheme(t02);
            st07.setTheme(t02);
            st08.setTheme(t02);
            st10.setTheme(t02);
            st11.setTheme(t02);
            st12.setTheme(t02);
            st13.setTheme(t03);
            st14.setTheme(t03);
            st15.setTheme(t03);
            st16.setTheme(t03);
            st17.setTheme(t03);
            st18.setTheme(t03);
            st19.setTheme(t03);
            st20.setTheme(t03);
            st21.setTheme(t03);
            st22.setTheme(t03);
            st23.setTheme(t03);
            st24.setTheme(t03);

            st25.setTheme(t04);
            st26.setTheme(t04);

            st28.setTheme(t04);

            st30.setTheme(t04);
            st31.setTheme(t04);
//==================================== PERSIST =================================        
            em.persist(st01);
            em.persist(st02);
            em.persist(st03);
            em.persist(st04);
            em.persist(st06);
            em.persist(st07);
            em.persist(st08);
            em.persist(st10);
            em.persist(st11);
            em.persist(st12);
            em.persist(st13);
            em.persist(st14);
            em.persist(st15);
            em.persist(st16);
            em.persist(st17);
            em.persist(st18);
            em.persist(st19);
            em.persist(st20);
            em.persist(st23);
            em.persist(st24);
            em.persist(st25);
            em.persist(st26);
            em.persist(st28);
            em.persist(st30);
            em.persist(st31);

            em.persist(ev01);
            em.persist(ev02);
            em.persist(ev03);
            em.persist(ev04);
            em.persist(ev05);
            em.persist(ev06);
            em.persist(ev07);
            em.persist(ev08);

            em.persist(lc01);
            em.persist(lc02);
            em.persist(lc03);
            em.persist(lc04);
            em.persist(lc05);

            em.persist(p01);
            em.persist(p02);
            em.persist(p03);
            em.persist(p04);
// Valérian

            // Inna
            //-----------------------[ DATES ]----------------------------
            sdf.setLenient(false);

            Date d20_ = sdf.parse("13/03/2017 18:00:00");
            Date d21 = sdf.parse("14/03/2017 18:00:00");
            Date d22 = sdf.parse("15/03/2017 18:00:00");
            Date d23 = sdf.parse("25/03/2017 18:00:00");
            Date d24 = sdf.parse("16/03/2017 19:00:00");
            Date d25 = sdf.parse("17/03/2017 19:00:00");
            Date d26 = sdf.parse("18/03/2017 19:00:00");
            Date d27 = sdf.parse("19/03/2017 19:00:00");
            Date d28 = sdf.parse("20/03/2017 19:00:00");
            Date d29 = sdf.parse("01/04/2017 21:00:00");
            Date d30 = sdf.parse("025/04/2017 18:00:00");
            Date d31 = sdf.parse("025/04/2017 21:00:00");

//-----------------------[ SPECTACLES ]---------------------------------------
            Spectacle spctMozart = new Spectacle("REQUIEM DE MOZART", " WOLFGANG AMADEUS MOZART", StatutSpectacle.ACTIF,st03,null);
            spctMozart.setImage(new Image("http://lechoeurderiom.free.fr/Medias/affiches/requiem_mozart.JPG"));
            Spectacle spctBach = new Spectacle("PASSION SELON SAINT JEAN FRANCOIS DEJARDIN", "JOHANN SEBASTIAN BACH", StatutSpectacle.ACTIF,st04,null);
            spctBach.setImage(new Image("http://www.harmoniamundi.com/__media/document/1808/901748.49_G.jpg"));
            Spectacle spctFoot1 = new Spectacle("FINALE COUPE DE LA LIGUE", "J'adore courir après la baballe", StatutSpectacle.ACTIF,football,ev05);
            spctFoot1.setImage(new Image("http://www.francebillet.com/static/0/visuel/600/347/FINALE-COUPE-DE-LA-LIGUE-2017_3476961719077401827.jpg?1478605101000"));
            Spectacle spctFoot2 = new Spectacle("OLYMPIQUE DE MARSEILLE / PSG", " PARIS SAINT-GERMAIN, OLYMPIQUE DE MARSEILLE", StatutSpectacle.ACTIF,football,null);
            spctFoot2.setImage(new Image("http://france3-regions.francetvinfo.fr/auvergne-rhone-alpes/sites/regions_france3/files/styles/top_big/public/assets/images/2015/09/20/pronostic-om-ol.jpg?itok=b_iM2Y2C"));
            Spectacle spctCirque1 = new Spectacle("GRAND CIRQUE ST PETERSBOURG", "CIRQUE TRADITIONNEL", StatutSpectacle.ACTIF,st30,null);
            spctCirque1.setImage(new Image("http://static2.digitick.com/commun/images/upload/evenements/aff_Affiche2A4StPET_640.jpg"));
            Spectacle spctCirque2 = new Spectacle("GRAND CIRQUE MEDRANO", "CIRQUE TRADITIONNEL", StatutSpectacle.ACTIF,st30,ev07);
            spctCirque2.setImage(new Image("https://pbs.twimg.com/profile_images/524480611856044034/vpZ8iIFw.jpeg"));
            
            //------------------------- GROUPES -----------------------------------
            // MUSIQUE
            Groupe g01 = new Groupe("Maroon 5");
            Groupe g001 = new Groupe("Orchestre", spctMozart);
            // ARTS & SPECTACLES
            Groupe g02 = new Groupe("Jeff Panacloc",spctlaibach);
            // SPORT ( FINALE DE LA COUPE DE LA LIGUE)
            Groupe g03 = new Groupe("AS Monaco",spctPSJMonaco);
            Groupe g04 = new Groupe("Paris Saint-Germain",spctPSJMonaco);
            Groupe g041 = new Groupe("L'Olympique de Marseille",spctFoot2);
//            spctFoot2.getGroupes().add(g04);
            //FAMILLE & LOISIRS
            Groupe g05 = new Groupe("Disney sur glace",spctDisneyLando);
            // CIRQUE
            Groupe g06 = new Groupe("La troupe Semianyki Express",spctCirque1);
            Groupe g07 = new Groupe("La troupe Kadavresky",spctCirque2);      
            //===================GROUPES/FONCTIONS====================
            // Marroon 5
            f01.setGroupe(g01);
            f02.setGroupe(g01);
            f03.setGroupe(g01);
            f04.setGroupe(g01);
            f05.setGroupe(g01);
            f06.setGroupe(g01);
            f07.setGroupe(g01);

            // JEFF
            f20.setGroupe(g02);
            f21.setGroupe(g02);
            f22.setGroupe(g02);

            // CDL MONACO
            f09.setGroupe(g03);
            f10.setGroupe(g03);
            f11.setGroupe(g03);
            f12.setGroupe(g03);
            f13.setGroupe(g03);

            // CDL PSG
            f09.setGroupe(g04);
            f10.setGroupe(g04);
            f11.setGroupe(g04);
            f12.setGroupe(g04);
            f13.setGroupe(g04);

            //Disney
            f14.setGroupe(g05);
            f15.setGroupe(g05);
            f16.setGroupe(g05);
            f17.setGroupe(g05);
            f18.setGroupe(g05);
            f19.setGroupe(g05);
            f23.setGroupe(g05);
            f24.setGroupe(g05);

            // Association d'un spectacle à des groupes
            g01.setSpectacle(spctmaroon6);            

//-----------------------[ LIEU ]------------------------------------------
            Lieu madelaine = new Lieu("Eglise de la Madeleine", "salle01", "Eglise satanique");
            Image imadelaine = new Image("http://mylene.net/img_data/mylene-farmer_concerts-2009_saint-petersbourg_001min.jpg");
            Lieu stadeLyon = new Lieu("PARC OLYMPIQUE LYONNAIS", null, "Ce stade est grand");
            Image istadeLyon = new Image("http://static.ticketmaster.fr/assets/ctx/ticketnet-1/static/images/plans/l_9090.gif");
            Lieu stadeMarceille = new Lieu("ORANGE VELODROME - MARSEILLE", null, "ce stade est petit");
            Lieu parc1 = new Lieu("PARC DES EXPOS- BVD KENNEDY", "salle02", "Les ponneys sont grands et beaux");
            Lieu parc2 = new Lieu("HIPPODROME DE SENE", "stade01", "Les cheveaux sont petits et laids");
            
                        // Association
            s03.setLieu(l01);
            s04.setLieu(madelaine);
            s05.setLieu(stadeMarceille);
            s06.setLieu(parc1);
            s07.setLieu(parc2);
            s08.setLieu(stadeLyon);
            s09.setLieu(madelaine);
            s10.setLieu(madelaine);
            s11.setLieu(stadeMarceille);
            s12.setLieu(l01);
            s13.setLieu(madelaine);
            s14.setLieu(stadeLyon);
            s15.setLieu(parc1);
            s16.setLieu(parc2);
            
            
            madelaine.setImage(imadelaine);
            stadeLyon.setImage(istadeLyon);
            stadeMarceille.setImage(istadeLyon);
            parc1.setImage(istadeLyon);
            parc2.setImage(istadeLyon);
            
            z01.setLieu(madelaine);
            z02.setLieu(stadeLyon);
            z03.setLieu(stadeMarceille);
            z04.setLieu(stadeLyon);
            z05.setLieu(stadeLyon);
            z06.setLieu(parc1);
            z07.setLieu(parc2);
            z08.setLieu(stadeMarceille);
            
            madelaine.setCoordonnees(coord01);
            stadeLyon.setCoordonnees(coord02);
            stadeMarceille.setCoordonnees(coord03);
            parc1.setCoordonnees(coord04);
            parc2.setCoordonnees(coordPointRetrait);

//-----------------------[ SEANCES ]------------------------------------------
            Seance s06_ = new Seance(d20_, StatutSeance.ACTIF, spctMozart);
            s06.setLieu(madelaine);
            Seance s07_ = new Seance(d21, StatutSeance.ACTIF, spctMozart);
            s07.setLieu(madelaine);
            Seance s08_ = new Seance(d22, StatutSeance.ACTIF, spctMozart);
            s08.setLieu(madelaine);
            Seance s09_ = new Seance(d23, StatutSeance.ACTIF, spctMozart);
            s09.setLieu(madelaine);

            Seance s10_ = new Seance(d24, StatutSeance.ACTIF, spctBach);
            s10.setLieu(madelaine);
            Seance s11_ = new Seance(d25, StatutSeance.ACTIF, spctBach);
            s11.setLieu(madelaine);
            Seance s12_ = new Seance(d26, StatutSeance.ACTIF, spctBach);
            s12.setLieu(madelaine);
            Seance s13_ = new Seance(d27, StatutSeance.ACTIF, spctBach);
            s13.setLieu(madelaine);
            Seance s14_ = new Seance(d28, StatutSeance.ANNULE, spctBach);
            s14.setLieu(madelaine);

            Seance s15_ = new Seance(d29, StatutSeance.ACTIF, spctFoot1);
            s15.setLieu(stadeLyon);

            Seance s16_ = new Seance(d26, StatutSeance.ACTIF, spctFoot2);
            s16.setLieu(stadeMarceille);

            Seance s17 = new Seance(d30, StatutSeance.ACTIF, spctCirque1);
            s17.setLieu(parc1);

            Seance s18 = new Seance(d31, StatutSeance.ACTIF, spctCirque1);
            s18.setLieu(parc1);

            Seance s19 = new Seance(d30, StatutSeance.ACTIF, spctCirque2);
            s19.setLieu(parc1);
            Seance s20 = new Seance(d20_, StatutSeance.ACTIF, spctCirque2);
            s20.setLieu(parc1);

            Seance s21 = new Seance(d21, StatutSeance.ACTIF, spctCirque2);
            s21.setLieu(parc1);

            Seance s22 = new Seance(d22, StatutSeance.ACTIF, spctCirque2);
            s22.setLieu(parc1);

            Seance s23 = new Seance(d23, StatutSeance.ACTIF, spctCirque2);
            s23.setLieu(parc1);

            em.persist(s06_);
            em.persist(s07_);
            em.persist(s08_);
            em.persist(s09_);
            em.persist(s10_);
            em.persist(s11_);
            em.persist(s12_);
            em.persist(s13_);
            em.persist(s14_);
            em.persist(s15_);
            em.persist(s16_);
            em.persist(s17);
            em.persist(s18);
            em.persist(s19);
            em.persist(s20);
            em.persist(s21);
            em.persist(s22);
            em.persist(s23);
            
//-----------------------[ BILLET ]----------------------------
            Billet b01 = new Billet("AA001", tva5v5p, tbPlacesNumerotees, s01, cat01,pl01);
            Billet b02 = new Billet("AA002", tva5v5p, tbPlacesNumerotees, s01, cat02,pl02);
            Billet b03 = new Billet("AA003", tva5v5p, tbPlaceLibre, s01, cat03,pl09);
            Billet b04 = new Billet("AA004", tva5v5p, tbPlacesNumerotees, s01, cat02,pl03,lc01);
            Billet b05 = new Billet("AA005", tva5v5p, tbPlacesNumerotees, s01, cat01,pl04);
            Billet b06 = new Billet("AA006", tva5v5p, tbPlaceLibre, s01, cat03,pl09);

            Billet b07 = new Billet("AA007", tva5v5p, tbPlaceLibre, s02, cat03,pl09);
            Billet b08 = new Billet("AA008", tva5v5p, tbPlaceLibre, s02, cat03,pl10);
            Billet b09 = new Billet("AA009", tva5v5p, tbPlaceLibre, s02, cat03,pl11);
            Billet b10 = new Billet("AA010", tva5v5p, tbPlaceLibre, s02, cat03,pl12);

            Billet b11 = new Billet("01BT0A011", tva10p, tbPlaceLibre, s03, catParcAttraction01,pl09);
            Billet b12 = new Billet("01BT0A012", tva10p, tbPlaceLibre, s03, catParcAttraction01,pl10,lc02);
            Billet b13 = new Billet("01BT0A013", tva10p, tbPlaceLibre, s03, catParcAttraction01,pl11);
            Billet b14 = new Billet("02BT0A014", tva10p, tbPlaceLibre, s03, catParcAttraction01,pl12);
            Billet b15 = new Billet("02BT0A015", tva10p, tbPlaceLibre, s03, catParcAttraction01,pl09);
            Billet b16 = new Billet("02BT0A016", tva10p, tbPlaceLibre, s03, catParcAttraction01,pl10);

            Billet b17 = new Billet("01LGBT0A017", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl01);
            Billet b18 = new Billet("01LGBT0A018", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl02);
            Billet b19 = new Billet("01LGBT0A019", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl03);
            Billet b20 = new Billet("01LGBT0A020", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl04);
            Billet b21 = new Billet("01LGBT0A021", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl05);
            Billet b22 = new Billet("01LGBT0A022", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl06);
            Billet b23 = new Billet("01LGBT0A023", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl07,lc03);
            Billet b24 = new Billet("01LGBT0A024", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl08);
            Billet b25 = new Billet("01LGBT0A025", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl01);
            Billet b26 = new Billet("01LGBT0A026", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl02);
            Billet b27 = new Billet("01LGBT0A027", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl03);
            Billet b28 = new Billet("01LGBT0A028", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl04,lc04);
            Billet b29 = new Billet("01LGBT0A029", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl05);
            Billet b30 = new Billet("01LGBT0A030", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl06);
            Billet b31 = new Billet("01LGBT0A031", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl07);
            Billet b32 = new Billet("01LGBT0A032", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl08);
            Billet b33 = new Billet("01LGBT0A033", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl01);
            Billet b34 = new Billet("01LGBT0A034", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl02);
            Billet b35 = new Billet("01LGBT0A035", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl03);
            Billet b36 = new Billet("01LGBT0A036", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl04);
            Billet b37 = new Billet("01LGBT0A037", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl05);
            Billet b38 = new Billet("01LGBT0A038", tva5v5p, tbPlaceLibre, s04, catPlaceDebout,pl06);

            Billet b39 = new Billet("02LGBT0A001", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise,pl01);
            Billet b40 = new Billet("02LGBT0A002", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise,pl02,lc05);
            Billet b41 = new Billet("02LGBT0A003", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise,pl03);
            Billet b42 = new Billet("02LGBT0A004", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise,pl04);
            Billet b43 = new Billet("02LGBT0A005", tva5v5p, tbPlacesNumerotees, s04, catPlaceAssise,pl05);

            Billet b44 = new Billet("HGD01", tva5v5p, tbPlacesNumerotees, s05, catPlaceAssise,pl06);
            Billet b45 = new Billet("HGD02", tva5v5p, tbPlacesNumerotees, s05, catPlaceAssise,pl07,lc05);
            Billet b46 = new Billet("HGD03", tva5v5p, tbPlacesNumerotees, s05, catPlaceAssise,pl08);
            Billet b47 = new Billet("HGD04", tva5v5p, tbPlacesNumerotees, s05, catPlaceAssise,pl01);

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

            // Inna
        } catch (ParseException ex) {
            Logger.getLogger(TestData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
