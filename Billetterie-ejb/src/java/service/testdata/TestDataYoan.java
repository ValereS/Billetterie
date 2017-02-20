/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.testdata;

import entities.Fonction;
import entities.Groupe;
import entities.Participant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestDataYoan implements TestDataYoanLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    public void create0() {
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

        //===========================PERSISTANCE=======================
        // Persistance des fonctions
        em.persist(f01);
        em.persist(f02);
        em.persist(f03);
        em.persist(f04);
        em.persist(f05);
        em.persist(f06);
        em.persist(f07);
        // em.persist(f08);
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
    }

    @Override
    public void create() {  
        //------------------------- GROUPES -----------------------------------
        // MUSIQUE
        Groupe g01 = new Groupe("Maroon 5");

        //---------------------------- ROLES -----------------------------------
        Fonction f01 = new Fonction("basse");
        Fonction f02 = new Fonction("chant");
        Fonction f03 = new Fonction("clavier");
        Fonction f04 = new Fonction("guitare solo");
        Fonction f05 = new Fonction("choeur");
        Fonction f06 = new Fonction("guitare rythmique");
        Fonction f07 = new Fonction("batterie");

        f01.setGroupe(g01);
        
        em.persist(f01);


    }

}
