/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author cdi505
 */
public enum TypeBillet {

    NUMEROTE(1L, "Placement numéroté"),
    LIBRE(2L, "Placement libre");

    private final Long id;
    private final String description;

    TypeBillet(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
