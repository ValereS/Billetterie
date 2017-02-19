
package essais;

import entities.Fonction;
import entities.Groupe;
import entities.Participant;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JeuEssaiYo02 {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Billetterie-ejbPU");
    EntityManager em = emf.createEntityManager();
    
    
    //------------------------- GROUPES -----------------------------------
    
    // MUSIQUE
    Groupe g01 = new Groupe("Maroon 5");
    // ARTS & SPECTACLES
    Groupe g02 = new Groupe("Jeff Panacloc");
    // SPORT ( FINALE DE LA COUPE DE LA LIGUE)
    Groupe g03 = new Groupe("AS Monaco");
    Groupe g04 = new Groupe("Paris Saint-Germain");
    //FAMILLE & LOISIRS
    Groupe g05 = new Groupe("Disney sur glace");
    
    
    
    //---------------------------- ROLES -----------------------------------
    Fonction f01= new Fonction("basse");
    Fonction f02= new Fonction("chant");
    Fonction f03= new Fonction("clavier");
    Fonction f04= new Fonction("guitare solo");
    Fonction f05= new Fonction("choeur");
    Fonction f06= new Fonction("guitare rythmique");
    Fonction f07= new Fonction("batterie");
    Fonction f08= new Fonction("percussions");
    
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
    Participant p08 = new  Participant("Kevin Trapp");
    Participant p09 = new  Participant("Danijel Subasic");
    
    // DEF
    Participant p10 = new  Participant("Thiago Silva");
    Participant p11 = new  Participant("Djibril Sidibé");
    
    // MIL
    Participant p12 = new  Participant("Marco Verratti");
    Participant p13 = new  Participant("Thomas Lemar");
    
    // ATT
    Participant p14 = new  Participant("Edinson Cavani");
    Participant p15 = new  Participant("Radamel Falcao");
    
    // COACH
    Participant p16 = new  Participant("Unai Emery");
    Participant p17 = new  Participant("Leonardo Jardim");
    
    //---------------------------------------------------------------
    
    
    Participant p18 = new Participant("participant01");
    Participant p19 = new Participant("participant02");
    Participant p20 = new Participant("participant03");
    Participant p21 = new Participant("participant04");
    Participant p22 = new Participant("participant05");
    Participant p23 = new Participant("participant06");
    Participant p24 = new Participant("participant07"); // /!\ On sait jamais!!
    
    
    
    
    
    
    
    
    
    
    
    
}
