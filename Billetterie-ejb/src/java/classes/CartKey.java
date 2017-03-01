/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Objects;

/**
 *
 * @author cdi505
 */
public class CartKey {

    private final int categoryId;
    private final int rateId;

    public CartKey(int categoryId, int rateId) {
        this.categoryId = categoryId;
        this.rateId = rateId;
    }

    public int getCategory() {
        return categoryId;
    }

    public int getRate() {
        return rateId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.categoryId);
        hash = 83 * hash + Objects.hashCode(this.rateId);
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
        if (!Objects.equals(this.categoryId, other.categoryId)) {
            return false;
        }
        if (!Objects.equals(this.rateId, other.rateId)) {
            return false;
        }
        return true;
    }

}
