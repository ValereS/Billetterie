package service;

import entities.Spectacle;
import enums.StatutSpectacle;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SpectacleGestion implements SpectacleGestionLocal {

    public static int DEFAULT_BEST_SELLING_MAX_RESULTS = 5;

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public List<Spectacle> select(int pageNumber, int maxResults) {
        Query qr = em.createNamedQuery("entities.Spectacle.select");
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        int firstResult = (pageNumber - 1) * maxResults;
        qr.setFirstResult(firstResult);
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public Spectacle selectById(long id) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectById");
        qr.setParameter("paramId", id);
        try {
            Spectacle show = (Spectacle) qr.getSingleResult();
            qr = em.createNamedQuery("entities.Spectacle.selectSeancesBySpectacle");
            qr.setParameter("paramSpectacle", show);
            show.setSeances(qr.getResultList());
            qr = em.createNamedQuery("entities.Spectacle.selectGroupeBySpectacle");
            qr.setParameter("paramSpectacle", show);
            show.setGroupes(qr.getResultList());

            // C'est une collection et je dois retrouver un objet en fonction de ce qu'il sera choisi dans la comboBox
//            qr = em.createNamedQuery("entities.Spectacle.selectCategorie"); 
//            qr.setParameter("paramSeance", show.getSeances());
//            show.getSeances().addAll(qr.getResultList());
            return show;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public long count() {
        Query qr = em.createNamedQuery("entities.Spectacle.count");
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        return (long) qr.getSingleResult();
    }

    @Override
    public List<Spectacle> selectBySearch(int pageNumber, int maxResults, String paramSearch) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectBySearch");
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        qr.setParameter("paramTitle", "%" + paramSearch + "%");
        qr.setParameter("paramDescription", "%" + paramSearch + "%");
        qr.setParameter("paramEventName", "%" + paramSearch + "%");
        qr.setParameter("paramParticipantName", "%" + paramSearch + "%");
        int firstResult = (pageNumber - 1) * maxResults;
        qr.setFirstResult(firstResult);
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public long countBySearch(String paramSearch) {
        Query qr = em.createNamedQuery("entities.Spectacle.countBySearch");
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        qr.setParameter("paramTitle", "%" + paramSearch + "%");
        qr.setParameter("paramDescription", "%" + paramSearch + "%");
        qr.setParameter("paramEventName", "%" + paramSearch + "%");
        qr.setParameter("paramParticipantName", "%" + paramSearch + "%");
        long count = (long) qr.getSingleResult();
        return count;
    }

    @Override
    public List<Spectacle> selectBySubTheme(int pageNumber, int maxResults, String sousThemeNom) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectBySubTheme");
        qr.setParameter("paramSubThemeNom", sousThemeNom);
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        int firstResult = (pageNumber - 1) * maxResults;
        qr.setFirstResult(firstResult);
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public long countBySubTheme(String sousThemeNom) {
        Query qr = em.createNamedQuery("entities.Spectacle.countBySubTheme");
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        qr.setParameter("paramSubThemeNom", sousThemeNom);
        return (long) qr.getSingleResult();
    }

    @Override
    public List<Spectacle> selectByTheme(int pageNumber, int maxResults, String themeNom) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectByTheme");
        qr.setParameter("paramThemeNom", themeNom);
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        int firstResult = (pageNumber - 1) * maxResults;
        qr.setFirstResult(firstResult);
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public long countByTheme(String themeNom) {
        Query qr = em.createNamedQuery("entities.Spectacle.countByTheme");
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        qr.setParameter("paramThemeNom", themeNom);
        return (long) qr.getSingleResult();
    }

    @Override
    public List<Spectacle> selectBestSelling(int maxResults) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectBestSelling");
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public List<Spectacle> selectBestSelling() {
        return selectBestSelling(DEFAULT_BEST_SELLING_MAX_RESULTS);
    }

}
