package entities;

import enums.StatutSpectacle;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Spectacle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private StatutSpectacle statut;
    
//--------------------------------------------------------------------------------------

    @ManyToOne
    private Image image;
    
    
//---------------------------------------------------------------------------------------
            
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutSpectacle getStatut() {
        return statut;
    }

    public void setStatut(StatutSpectacle statut) {
        this.statut = statut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Spectacle() {
    }

    public Spectacle(Long id, String titre, String description, StatutSpectacle statut) {
        this();
        this.titre = titre;
        this.description = description;
        this.statut = statut;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spectacle)) {
            return false;
        }
        Spectacle other = (Spectacle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "entities.Spectacle[ id=" + id + " ]" + "titre : " + titre;
    }

}
