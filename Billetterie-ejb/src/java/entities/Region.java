/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author cdi505
 */
@Entity
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nom;

    @OneToMany(mappedBy = "region")
    private Collection<Ville> villes;
    @ManyToOne
    private Pays pays;

    public Region() {
        villes = new ArrayList<>();
    }

    public Region(String nom) {
        this();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Ville> getVilles() {
        return villes;
    }

    public void setVilles(Collection<Ville> villes) {
        this.villes = villes;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Region[ id=" + nom + " ]";
    }

}
