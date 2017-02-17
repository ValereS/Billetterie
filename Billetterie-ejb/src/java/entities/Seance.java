
package entities;

import enums.StatutSeance;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
//------------------------------------------------------------------------------    
    
    public Seance() {
        billets=new ArrayList<>();
    }

    public Seance(Date date, StatutSeance statut) {
        this();
        this.date = date;
        this.statut = statut;
    }
    

    public Seance(Date date, StatutSeance statut, Collection<Billet> billets) {
        this();
        this.date = date;
        this.statut = statut;
        this.billets = billets;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seance)) {
            return false;
        }
        Seance other = (Seance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Collection<Billet> getBillets() {
        return billets;
    }

    public void setBillets(Collection<Billet> billets) {
        this.billets = billets;
    }

}
