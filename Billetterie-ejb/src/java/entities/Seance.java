
package entities;

import enums.StatutSeance;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity
public class Seance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    private StatutSeance statut;
    
//------------------------------------------------------------------------------
    
    @OneToMany(mappedBy = "seance")
    private Collection<Billet> billets;
    
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Spectacle spectacle;
    
    @ManyToMany(cascade = {})
    private Collection<Categorie> categories;
    
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Lieu lieu;
    
//------------------------------------------------------------------------------    
    public Seance() {
        billets=new ArrayList<>();
        categories=new ArrayList<>();
    }

    public Seance(Date date, StatutSeance statut) {
        this();
        this.date = date;
        this.statut = statut;
    }

    public Seance(Date date, StatutSeance statut, Spectacle spectacle) {
        this();
        this.date = date;
        this.statut = statut;
        this.spectacle = spectacle;
    }
    

    public Seance(Date date, StatutSeance statut, Collection<Billet> billets) {
        this();
        this.date = date;
        this.statut = statut;
        this.billets = billets;
    }

    public Seance(Date date, StatutSeance statut, Collection<Billet> billets, Spectacle spectacle) {
        this();
        this.date = date;
        this.statut = statut;
        this.billets = billets;
        this.spectacle = spectacle;
    }

    public Seance(Date date, StatutSeance statut, Collection<Billet> billets, Spectacle spectacle, Collection<Categorie> categories, Lieu lieu) {
        this();
        this.date = date;
        this.statut = statut;
        this.billets = billets;
        this.spectacle = spectacle;
        this.categories = categories;
        this.lieu = lieu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "entities.Seance[ id=" + id + " ]" + "Date : " + date;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatutSeance getStatut() {
        return statut;
    }

    public void setStatut(StatutSeance statut) {
        this.statut = statut;
    }

    public Collection<Billet> getBillets() {
        return billets;
    }

    public void setBillets(Collection<Billet> billets) {
        this.billets = billets;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public Collection<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Categorie> categories) {
        this.categories = categories;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
    
    
}
