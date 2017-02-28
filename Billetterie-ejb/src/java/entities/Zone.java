
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Lieu lieu;
    
    @OneToMany(mappedBy = "zone")
    private Collection<Place> places;
    @ManyToMany(mappedBy = "zones")
    private List<Categorie> categories;
    

    public Zone() {
        places = new ArrayList<>();
    }

    public Zone(String nom, String entree, String description) {
        this();
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

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Collection<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Collection<Place> places) {
        this.places = places;
    }
    
}
