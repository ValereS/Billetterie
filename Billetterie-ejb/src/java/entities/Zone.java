
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Zone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String entree;
    private String description;
    @ManyToOne
    private Lieu lieu;
    
    @OneToMany(mappedBy = "zone")
    private Collection<Place> places;

    public Zone() {
    }

    public Zone(Long id, String nom, String entree, String description) {
        this.id = id;
        this.nom = nom;
        this.entree = entree;
        this.description = description;
    }
    
    //getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
    
    @Override
    public String toString() {
        return "entities.Zone[ id=" + id + " ]";
    }
    
}
