package service;

import entities.Spectacle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi515
 */
@Local
public interface SpectacleGestionLocal {

    List<Spectacle> select(int pageNumber, int maxResults);

    long count();

    List<Spectacle> selectBySearch(int pageNumber, int maxResults, String paramSearch);

    long countBySearch(String paramSearch);
    
}
