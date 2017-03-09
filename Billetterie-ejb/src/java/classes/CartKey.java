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

    private final Long categoryId;
    private final String rateName;

    public CartKey(Long categoryId, String rateName) {
        this.categoryId = categoryId;
        this.rateName = rateName;
    }

    public Long getCategory() {
        return categoryId;
    }

    public String getRateName() {
        return rateName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.categoryId);
        hash = 83 * hash + Objects.hashCode(this.rateName);
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
        if (!Objects.equals(this.rateName, other.rateName)) {
            return false;
        }
        return true;
    }

}
