package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "entities.Tarif.selectByCategorie", query = "SELECT t FROM Tarif t WHERE t.categorie = :paramCategorie ORDER BY t.prix DESC"),
    @NamedQuery(name = "entities.Tarif.selectByCategoriePrix", query = "SELECT t FROM Tarif t WHERE t.categorie = :paramCategorie AND t.prix = :paramPrix")

})
public class Tarif implements Serializable, Comparable<Tarif> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, scale = 2, precision = 10)
    private BigDecimal prix;
    private String nom;
//--------------------------------------------------
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Categorie categorie;

    public Tarif() {
    }

    public Tarif(BigDecimal prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "entities.Tarif[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Tarif o) {
        return -getPrix().compareTo(o.getPrix());
    }

}
