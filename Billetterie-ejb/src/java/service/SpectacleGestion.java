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

    public List<Spectacle> selectAllSpectacle(){
        Query qr = em.createNamedQuery("entities.Spectacle.selectAll");
        return qr.getResultList();
    }
}
