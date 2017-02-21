package service.testdata;

import entities.Commande;
import entities.Evenement;
import entities.LigneCommande;
import entities.ModeExpedition;
import entities.Paiement;
import entities.SousTheme;
import entities.Theme;
import enums.ModePaiement;
import enums.StatutCommande;
import enums.StatutModeExpedition;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestDataValerian implements TestDataValerianLocal {
    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public void jeuValerian() { 
//================================== THEME =====================================        
        Theme t01 = new Theme("Musique");
        Theme t02 = new Theme("Arts & Spectacles");
        Theme t03 = new Theme("Sport");
        Theme t04 = new Theme("Famille & Loisirs");
//============================== SOUS THEME ====================================
      //   Musique
        SousTheme st01 = new SousTheme("Concert");
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
        SousTheme st13 = new SousTheme("Football");
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
 
        SousTheme st30 = new SousTheme("Cirque");
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
//=============================  COMMANDE ======================================  
        Commande co01 = new Commande(new BigDecimal("3.3"), StatutCommande.LIVREE, new GregorianCalendar(2017, 1, 3).getTime());
        Commande co02 = new Commande(new BigDecimal("6.35"), StatutCommande.ANNULEE, new GregorianCalendar(2017, 2, 17).getTime());
        Commande co03 = new Commande(new BigDecimal("0"), StatutCommande.COMMANDEE, new GregorianCalendar(2017, 1, 20).getTime());
        Commande co04 = new Commande(new BigDecimal("0"), StatutCommande.PAYEE, new GregorianCalendar(2017, 2, 10).getTime());
        Commande co05 = new Commande(new BigDecimal("14.5"), StatutCommande.LIVREE, new GregorianCalendar(2017, 1, 28).getTime());
//============================= LIGNE COMMANDE =================================        
        LigneCommande lc01 = new LigneCommande(new BigDecimal("44"), 0.2f, 0);
        LigneCommande lc02 = new LigneCommande(new BigDecimal("22"), 0.2f, 0.1f);
        LigneCommande lc03 = new LigneCommande(new BigDecimal("30"), 0.2f, 0);
        LigneCommande lc04 = new LigneCommande(new BigDecimal("25"), 0.2f, 0.1f);
        LigneCommande lc05 = new LigneCommande(new BigDecimal("49.99"), 0.2f, 0);
        
//============================ PAIEMENT ========================================
        Paiement p01 = new Paiement(new BigDecimal("69.3"), ModePaiement.CB, new GregorianCalendar(2017, 1, 3).getTime());
        Paiement p02 = new Paiement(new BigDecimal("25"), ModePaiement.CHEQUE, new GregorianCalendar(2017, 2, 16).getTime());
        Paiement p03 = new Paiement(new BigDecimal("10"), ModePaiement.CHEQUE_CULTURE, new GregorianCalendar(2017, 2, 4).getTime());
        Paiement p04 = new Paiement(new BigDecimal("20"), ModePaiement.CB, new GregorianCalendar(2017, 1, 28).getTime());
//================================= MODE EXPEDITION ============================
        ModeExpedition me01 = new ModeExpedition("Courrier Simple",new BigDecimal("3.30"), "Envoi postal par lettre simple. Cet envoi n'est pas proposé si les billets sont non numérotés.", StatutModeExpedition.ACTIF);
        ModeExpedition me02 = new ModeExpedition("Recommandé", new BigDecimal("6.35"), "Possibilité de tracer en temps réel sur internet où ce situe votre pli.", StatutModeExpedition.ACTIF);
        ModeExpedition me03 = new ModeExpedition("Retrait Magasin", new BigDecimal("0"), "Les billets sont à retirer uniquement dans les magasins participants.", StatutModeExpedition.ACTIF);
        ModeExpedition me04 = new ModeExpedition("Recommandé Etrangé", new BigDecimal("14.50"), "Possibilité de tracer en temps réel sur internet où ce situe votre pli.", StatutModeExpedition.ACTIF);
        
        co01.setModeExpedition(me01);
        co02.setModeExpedition(me02);
        co03.setModeExpedition(me03);
        co04.setModeExpedition(me03);
        co05.setModeExpedition(me04);
//============================== PAIEMENT COMMANDE =============================
        p01.setCommande(co01);
        p02.setCommande(co04);
        p03.setCommande(co05);
        p04.setCommande(co05);
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
    }
}
