/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Billet;
import entities.Place;
import entities.TypeBillet;
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
        if (!tickets.stream().allMatch(ticket -> ticket.getTypeBillet().getId().equals(TypeBillet.Type.NUMEROTE.getId()))) {
            return false;
        }
        
        
        
        return false;
    }
}
