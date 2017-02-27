
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Groupe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    
    
    @OneToMany(mappedBy = "groupe",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<Fonction> fonctions;
    
    
    @ManyToOne()
    private Spectacle spectacle;

    public Groupe() {
        fonctions = new ArrayList<>();
    }

    public Groupe(String nom) {
        this();
        this.nom = nom;
    }

    public Collection<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(Collection<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

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

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    @Override
    public String toString() {
        return "entities.Groupe[ id=" + id + " ]";
    }
    
}
