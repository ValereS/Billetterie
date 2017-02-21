/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public List<Spectacle> selectAll();
    
}
