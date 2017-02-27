package service;

import entities.Spectacle;
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

    
}
