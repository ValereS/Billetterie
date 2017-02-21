package entities;

import enums.StatutEvenement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    
    private StatutEvenement statut;
    
    @OneToMany(mappedBy = "evenement")
    private Collection<Spectacle> spectacles;

    public Evenement() {
        spectacles = new ArrayList<>();
    }

    public Evenement(String nom) {
        this();
        this.nom = nom;
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

    public Collection<Spectacle> getSpectacles() {
        return spectacles;
    }

    public void setSpectacles(Collection<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", nom=" + nom + '}';
    }
}