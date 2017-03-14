/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Billet;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author cdi505
 */
@Local
public interface BilletGestionLocal {

    public boolean checkContiguousSeats(Collection<Billet> tickets);
    
}
