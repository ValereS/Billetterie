/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Billet;
import entities.Place;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author cdi505
 */
@Stateless
public class BilletGestion implements BilletGestionLocal {

    @Override
    public boolean checkContiguousSeats(Collection<Billet> tickets) {
        for (Billet ticket : tickets) {
            Place seat = ticket.getPlace();
            if (seat == null) {
                return false;
            }
        }
        return false;
    }
}
