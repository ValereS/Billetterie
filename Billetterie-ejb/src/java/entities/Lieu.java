
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
import javax.persistence.ManyToOne;
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
    
    @OneToMany(mappedBy = "lieu")
    private List<Seance> seances;
    
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Coordonnees coordonnees;

    public Lieu() {
        zones = new ArrayList<>();
        seances = new ArrayList<>();
    }

    public Lieu(String nom, String salle, String description) {
        this();
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

    public Collection<Zone> getZones() {
        return zones;
    }

    public void setZones(Collection<Zone> zones) {
        this.zones = zones;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnee) {
        this.coordonnees = coordonnee;
    }
    
}
