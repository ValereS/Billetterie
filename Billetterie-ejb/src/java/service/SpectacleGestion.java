package service;

import entities.Spectacle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi515
 */
@Stateless
public class SpectacleGestion implements SpectacleGestionLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public List<Spectacle> selectAll() {
        Query qr = em.createNamedQuery("entities.Spectacle.selectAll");
        return qr.getResultList();
    }

    @Override
    public List<Spectacle> select(int pageNumber, int maxResults) {
        Query qr = em.createNamedQuery("entities.Spectacle.selectAll");
        int firstResult = (pageNumber - 1) * maxResults;
        qr.setFirstResult(firstResult);
        qr.setMaxResults(maxResults);
        return qr.getResultList();
    }

    @Override
    public long count() {
        Query qr = em.createNamedQuery("entities.Spectacle.count");
        return (long) qr.getSingleResult();
    }

}
