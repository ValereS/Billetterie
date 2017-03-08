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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
        Map<Categorie, List<Billet>> categoriesMap = new HashMap<>();

        for (Billet billet : billets) {
            Categorie categorie = billet.getCategorie();
            if (!categoriesMap.containsKey(categorie)) {
                categoriesMap.put(categorie, new ArrayList<>());
            }
            categoriesMap.get(categorie).add(billet);
        }

        List<Categorie> categories = categoriesMap.keySet().stream().sorted().collect(Collectors.toList());

        for (Categorie categorie : categories) {
            Query qrTarif = em.createNamedQuery("entities.Tarif.selectByCategorie");
            qrTarif.setParameter("paramCategorie", categorie);
            List<Tarif> tarifs = qrTarif.getResultList();
            categorie.setTarifs(tarifs);
            categorie.setBillets(categoriesMap.get(categorie));
        }

        return categories;
    }

    @Override
    public List<String> getTarifsNomFromCategories(List<Categorie> categories) {
        Set<Tarif> tarifsSet = new HashSet<>();

        for (Categorie categorie : categories) {
            for (Tarif tarif : categorie.getTarifs()) {
                tarifsSet.add(tarif);
            }
        }

        List<Tarif> tarifs = tarifsSet.stream().sorted().collect(Collectors.toList());
        List<String> tarifsNom = new ArrayList<>();

        for (Tarif tarif : tarifs) {
            if (tarifsNom.indexOf(tarif.getNom()) < 0) {
                tarifsNom.add(tarif.getNom());
            }
        }

        return tarifsNom;
    }

    @Override
    public Map<Categorie, Map<String, Tarif>> getMapTarifsFromCategories(List<Categorie> categories) {
        Map<Categorie, Map<String, Tarif>> mapTarifs = new HashMap<>();
        for (Categorie categorie : categories) {
            Map<String, Tarif> map = new HashMap<>();
            mapTarifs.put(categorie, map);
            for (Tarif tarif : categorie.getTarifs()) {
                map.put(tarif.getNom(), tarif);
            }
        }
        return mapTarifs;
    }

}
