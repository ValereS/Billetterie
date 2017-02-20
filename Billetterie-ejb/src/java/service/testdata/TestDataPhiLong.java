/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.testdata;

import entities.Client;
import entities.Coordonnees;
import entities.Pays;
import entities.PointRetrait;
import entities.Region;
import entities.Ville;
import enums.CiviliteClient;
import enums.StatutClient;
import enums.StatutPointRetrait;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi515
 */
@Stateless
public class TestDataPhiLong implements TestDataPhiLongLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public void create() {
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
    }
}
