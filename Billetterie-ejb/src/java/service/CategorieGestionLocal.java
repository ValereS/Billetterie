/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Categorie;
import entities.Seance;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi506
 */
@Local
public interface CategorieGestionLocal {

    public List<Categorie> selectCategorieBySeance(Seance seance);
    
}
