package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "entities.Billet.selectBySeanceCategorieTarif", query = "SELECT DISTINCT b FROM Billet b JOIN b.seance s JOIN b.categorie c JOIN c.tarifs t WHERE s = :paramShowing AND c = :paramCategory AND t = :paramRate ORDER BY b.numero"),
    @NamedQuery(name = "entities.Billet.selectBySeance", query = "SELECT b FROM Billet b WHERE b.seance = :paramSeance"),
    @NamedQuery(name = "entities.Billet.selectReleasable", query = "SELECT b FROM Billet b WHERE b.ligneCommande IS NULL AND b.statut = :paramStatut")
})
public class Billet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String numero;
//--------------------------------------------------
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Tva tva;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private TypeBillet typeBillet;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Seance seance;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Categorie categorie;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Place place;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private LigneCommande ligneCommande;

    public Billet() {
    }

    public Billet(String numero, Tva tva, TypeBillet typeBillet, Categorie categorie) {
        this.numero = numero;
        this.tva = tva;
        this.typeBillet = typeBillet;
        this.categorie = categorie;
    }

    public Billet(String numero, Tva tva, TypeBillet typeBillet, Seance seance, Categorie categorie) {
        this.numero = numero;
        this.tva = tva;
        this.typeBillet = typeBillet;
        this.seance = seance;
        this.categorie = categorie;
    }

    public Billet(String numero, Tva tva, TypeBillet typeBillet, Seance seance, Categorie categorie, Place place) {
        this.numero = numero;
        this.tva = tva;
        this.typeBillet = typeBillet;
        this.seance = seance;
        this.categorie = categorie;
        this.place = place;
    }

    public Billet(String numero, Tva tva, TypeBillet typeBillet, Seance seance, Categorie categorie, Place place, LigneCommande ligneCommande) {
        this.numero = numero;
        this.tva = tva;
        this.typeBillet = typeBillet;
        this.seance = seance;
        this.categorie = categorie;
        this.place = place;
        this.ligneCommande = ligneCommande;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public TypeBillet getTypeBillet() {
        return typeBillet;
    }

    public void setTypeBillet(TypeBillet typeBillet) {
        this.typeBillet = typeBillet;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    @Override
    public String toString() {
        return "entities.Billet[ id=" + numero + " ]";
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
