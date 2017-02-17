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
import javax.persistence.Embedded;
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
    @Embedded
    private VillePK pk;

    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    private Collection<Coordonnees> coordonnees;
    @ManyToOne(cascade = CascadeType.ALL)
    private Region region;

    public Ville() {
        coordonnees = new ArrayList<>();
    }

    public Ville(VillePK pk) {
        this.pk = pk;
    }

    public Ville(VillePK pk, Region region) {
        this.pk = pk;
        this.region = region;
    }

    public VillePK getPK() {
        return pk;
    }

    public void setPK(VillePK pk) {
        this.pk = pk;
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
