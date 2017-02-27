package service;

import entities.Spectacle;
import enums.StatutSpectacle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SpectacleGestion implements SpectacleGestionLocal {

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
    public Spectacle selectById(int id) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectById");
        qr.setParameter("paramId", id);
        try {
            Spectacle show = (Spectacle) qr.getSingleResult();
            qr = em.createNamedQuery("entities.Spectacle.selectSeancesBySpectacle");
            qr.setParameter("paramSpectacle", show);
            show.setSeances(qr.getResultList());
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
        qr.setParameter("paramSearch", "%" + paramSearch + "%");
        int firstResult = (pageNumber - 1) * maxResults;
        qr.setFirstResult(firstResult);
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public long countBySearch(String paramSearch) {
        Query qr = em.createNamedQuery("entities.Spectacle.countBySearch");
        qr.setParameter("paramStatut", StatutSpectacle.ACTIF);
        qr.setParameter("paramSearch", "%" + paramSearch + "%");
        return (long) qr.getSingleResult();
    }

}
