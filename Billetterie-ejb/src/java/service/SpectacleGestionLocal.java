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
    public List<Spectacle> selectAllSpectacle();
    
}
