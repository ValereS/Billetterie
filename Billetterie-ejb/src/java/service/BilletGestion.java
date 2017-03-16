/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Billet;
import entities.TypeBillet;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;

/**
 *
 * @author cdi505
 */
@Stateless
public class BilletGestion implements BilletGestionLocal {

    @Override
    public boolean checkContiguousSeats(Collection<Billet> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            return false;
        }

        if (!tickets.stream().allMatch(
                ticket -> ticket.getTypeBillet().getId()
                .equals(TypeBillet.Type.NUMEROTE.getId()))) {
            return false;
        }

        Set<Billet> set = new HashSet(tickets);
        Set<Billet> contiguous = new HashSet();
        Deque<Billet> deque = new ArrayDeque<>();

        Billet firstTicket = set.iterator().next();
        contiguous.add(firstTicket);
        deque.add(firstTicket);

        while (deque.peek() != null) {
            Billet currentTicket = deque.remove();
            for (Billet ticket : set) {
                if (!contiguous.contains(ticket)
                        && currentTicket.getPlace()
                        .isContiguous(ticket.getPlace())) {
                    contiguous.add(ticket);
                    deque.add(ticket);
                }
            }
        }

        return set.equals(contiguous);
    }
}
