
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lieu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // propriétés
    private Long id;
    private String nom;
    private String salle;
    private String description;
    
    
    @OneToMany(mappedBy = "lieu")
    private Collection<Zone> zones;
    

    public Lieu() {
    }

    public Lieu(String nom, String salle, String description) {
    
        this.nom = nom;
        this.salle = salle;
        this.description = description;
    }
    
    // getters & setters
    
    
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

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    @Override
    public String toString() {
        return "entities.Lieu[ id=" + id + " ]";
    }
    
}
