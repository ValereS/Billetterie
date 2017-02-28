package service;

import entities.SousTheme;
import entities.Spectacle;
import entities.Theme;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.NoResultException;

/**
 *
 * @author cdi515
 */
@Local
public interface SpectacleGestionLocal {


    Spectacle selectById(int id);

    List<Spectacle> select(int pageNumber, int maxResults);

    long count();

    List<Spectacle> selectBySearch(int pageNumber, int maxResults, String paramSearch);

    long countBySearch(String paramSearch);

    public long countBySubTheme(String sousThemeNom);

    public List<Spectacle> selectBySubTheme(int pageNumber, int maxResults, String sousThemeNom);

    public long countByTheme(String themeNom);

    public List<Spectacle> selectByTheme(int pageNumber, int maxResults, String themeNom);
}
