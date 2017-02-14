package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class SousTheme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column (nullable = false, length = 150)
    private String nom;
    
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Theme theme;

    public SousTheme() {
    }

    public SousTheme(String nom) {
        this.nom = nom;
    }
    
    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "entities.SousTheme{" + "nom=" + nom + '}';
    }
}
