/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entities.Categorie;
import entities.Tarif;
import java.util.Objects;

/**
 *
 * @author cdi505
 */
public class CartKey {

    private final Categorie category;
    private final Tarif rate;

    public CartKey(Categorie category, Tarif rate) {
        this.category = category;
        this.rate = rate;
    }

    public Categorie getCategory() {
        return category;
    }

    public Tarif getRate() {
        return rate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.category);
        hash = 83 * hash + Objects.hashCode(this.rate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CartKey other = (CartKey) obj;
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.rate, other.rate)) {
            return false;
        }
        return true;
    }

}
