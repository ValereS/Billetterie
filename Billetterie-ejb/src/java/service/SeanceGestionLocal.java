/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Billet;
import entities.Categorie;
import entities.Seance;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi506
 */
@Local
public interface SeanceGestionLocal {

    Seance getById(long id);

    public List<Categorie> getCategoriesFromBillets(Collection<Billet> billets);
    
}
