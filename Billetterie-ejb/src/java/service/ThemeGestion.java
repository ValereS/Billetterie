package service;

import entities.SousTheme;
import entities.Theme;
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
public class ThemeGestion implements ThemeGestionLocal {
    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public List<Theme> selectAll() {
        Query qr =em.createNamedQuery("entities.Theme.selectAll");
        List<Theme> themes = qr.getResultList();
        
        for (Theme theme : themes) {
            theme.setSousThemes(selectSousThemeByTheme(theme));
        }
        
        return themes;
    }

    @Override
    public List<SousTheme> selectSousThemeByTheme(Theme theme) {
        Query qr = em.createNamedQuery("entities.SousTheme.selectByTheme");
        qr.setParameter("paramTheme", theme);
        return qr.getResultList();
    }
}
