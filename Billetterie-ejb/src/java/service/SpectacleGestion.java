package service;

import entities.Spectacle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SpectacleGestion implements SpectacleGestionLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public List<Spectacle> select(int pageNumber, int maxResults) {
        Query qr = em.createNamedQuery("entities.Spectacle.select");
        int firstResult = (pageNumber - 1) * maxResults;
        qr.setFirstResult(firstResult);
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public Spectacle selectById(int id) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectById");
        qr.setParameter("paramId", id);
        Spectacle show = (Spectacle)qr.getSingleResult();
        qr = em.createNamedQuery("entities.Seance.selectByShow");
        qr.setParameter("paramShow", show);
        show.setSeances(qr.getResultList());
        return show;
    }   
    
    @Override
    public long count() {
        Query qr = em.createNamedQuery("entities.Spectacle.count");
        return (long) qr.getSingleResult();
    }

    @Override
    public List<Spectacle> selectBySearch(int pageNumber, int maxResults, String paramSearch) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectBySearch");
        qr.setParameter("paramSearch", "%" + paramSearch + "%");
        int firstResult = (pageNumber - 1) * maxResults;
        qr.setFirstResult(firstResult);
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public long countBySearch(String paramSearch) {
        Query qr = em.createNamedQuery("entities.Spectacle.countBySearch");
        qr.setParameter("paramSearch", "%" + paramSearch + "%");
        return (long) qr.getSingleResult();
    }

}
