package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Fonction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nom;
    
    // les assiociations de table
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) //
    private Groupe groupe;
    @ManyToMany
    private Collection<Participant> participants;


    public Fonction() {
    }

    public Fonction(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Collection<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Collection<Participant> participants) {
        this.participants = participants;
    }

    
    @Override
    public String toString() {
        return "entities.Role[ nom=" + nom + " ]";
    }

}
