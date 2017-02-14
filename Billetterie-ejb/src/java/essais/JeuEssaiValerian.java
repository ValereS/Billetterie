package essais;

import entities.SousTheme;
import entities.Theme;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JeuEssaiValerian {
    public static void main(String[] args) {
        JeuValerian();
    }
    public static void JeuValerian() { 

        EntityManagerFactory emf
        = Persistence.createEntityManagerFactory("Billetterie-ejbPU");
        EntityManager em = emf.createEntityManager();
        
        
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
        SousTheme st05 = new SousTheme("Spectacle et Comédie Musicale");
        SousTheme st06 = new SousTheme("Humour");
        SousTheme st07 = new SousTheme("Exposition et Musée");
        SousTheme st08 = new SousTheme("Théâtre");
        SousTheme st09 = new SousTheme("Cirque");
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
        SousTheme st27 = new SousTheme("Exposition et Musée");
        SousTheme st28 = new SousTheme("Monuments / Lieux Touristiques");
        SousTheme st29 = new SousTheme("Famille / Enfants");
        SousTheme st30 = new SousTheme("Cirque");
        SousTheme st31 = new SousTheme("Loisirs et Tourisme");
//============================= Assos THEME/SOUSTHEME ==========================        
        st01.setTheme(t01);
        st02.setTheme(t01);
        st03.setTheme(t01);
        st04.setTheme(t01);
        
        st05.setTheme(t02);
        st06.setTheme(t02);
        st07.setTheme(t02);
        st08.setTheme(t02);
        st09.setTheme(t02);
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
        st27.setTheme(t04);
        st28.setTheme(t04);
        st29.setTheme(t04);
        st30.setTheme(t04);
        st31.setTheme(t04);

        em.persist(t01);
        em.persist(t02);
        em.persist(t03);
        em.persist(t04);

    }
}
