package service;

import entities.Categorie;
import entities.Seance;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CategorieGestion implements CategorieGestionLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public List<Categorie> selectCategorieBySeance(Seance seance) {
        Query qr = em.createNamedQuery("entities.Categorie.selectBySeance");
        qr.setParameter("paramSeance", seance);
        return qr.getResultList();
    }
}
