/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author cdi505
 */
@Entity
public class Ville implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "VILLENOM")
    private String nom;
    @Id
    private String codePostal;

    @OneToMany(mappedBy = "ville")
    private Collection<Coordonnees> coordonnees;
    @ManyToOne(cascade = CascadeType.ALL)
    private Region region;

    public Ville() {
        coordonnees = new ArrayList<>();
    }

    public Ville(String nom, String codePostal) {
        this.nom = nom;
        this.codePostal = codePostal;
    }

    public Ville(String nom, String codePostal, Region region) {
        this(nom, codePostal);
        this.region = region;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Collection<Coordonnees> getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Collection<Coordonnees> coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
