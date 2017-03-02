/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Billet;
import entities.Categorie;
import entities.Seance;
import entities.Tarif;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi506
 */
@Stateless
public class SeanceGestion implements SeanceGestionLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public Seance getById(long id) {
        Seance seance = em.find(Seance.class, id);
        Query qr = em.createNamedQuery("entities.Billet.selectBySeance");
        qr.setParameter("paramSeance", seance);
        List<Billet> billets = qr.getResultList();
        seance.setBillets(billets);
        return seance;
    }

    @Override
    public List<Categorie> getCategoriesFromBillets(Collection<Billet> billets) {
        Set<Categorie> categoriesSet = new HashSet();

        for (Billet billet : billets) {
            categoriesSet.add(billet.getCategorie());
        }

        List<Categorie> categories = categoriesSet.stream().sorted().collect(Collectors.toList());

        for (Categorie categorie : categories) {
            Query qrTarif = em.createNamedQuery("entities.Tarif.selectByCategorie");
            qrTarif.setParameter("paramCategorie", categorie);
            List<Tarif> tarifs = qrTarif.getResultList();
            categorie.setTarifs(tarifs);
        }

        return categories;
    }

}
