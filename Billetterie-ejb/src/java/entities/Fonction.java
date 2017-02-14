
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Fonction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String nom;

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


    @Override
    public String toString() {
        return "entities.Role[ nom=" + nom + " ]";
    }
    
}
