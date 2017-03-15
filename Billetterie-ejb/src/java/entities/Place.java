package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String rang;
    private String description;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Zone zone;

    @OneToMany(mappedBy = "place")
    private Collection<Billet> billets;

    @OneToMany
    private Set<Place> placesContigues;

    public Place() {
        billets = new ArrayList<>();
        placesContigues = new HashSet<>();
    }

    public Place(String numero, String rang, String description) {
        this();
        this.numero = numero;
        this.rang = rang;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "entities.Place[ id=" + id + " ]";
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Collection<Billet> getBillets() {
        return billets;
    }

    public void setBillets(Collection<Billet> billets) {
        this.billets = billets;
    }

    public Collection<Place> getPlacesContigues() {
        return placesContigues;
    }

    public void setPlacesContigues(Set<Place> placesContigues) {
        this.placesContigues = placesContigues;
    }

    public void setContiguous(Place other) {
        if (!equals(other)) {
            getPlacesContigues().add(other);
            other.getPlacesContigues().add(this);
        }
    }

    public boolean isContiguous(Place place) {
        return getPlacesContigues().contains(place);
    }

}
