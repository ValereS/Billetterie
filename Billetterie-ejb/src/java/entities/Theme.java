package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Theme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id   
    @Column (nullable = false,length = 150)
    private String nom;
    
    //@OneToMany (mappedBy = "soustheme",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @OneToMany(mappedBy = "theme",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Collection<SousTheme> sousThemes;

    public Theme() {
        sousThemes = new ArrayList<>();
    }

    public Theme(String nom) {
        this();
        this.nom = nom;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<SousTheme> getSousThemes() {
        return sousThemes;
    }

    public void setSousThemes(Collection<SousTheme> sousThemes) {
        this.sousThemes = sousThemes;
    }
   
    @Override
    public String toString() {
        return "entities.Theme{" + "nom=" + nom + '}';
    }
}
