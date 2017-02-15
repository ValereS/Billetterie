package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Billet implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String numero;
//--------------------------------------------------
    @ManyToOne
    private Tva tva;
    
    @ManyToOne
    private TypeBillet typeBillet;
    
//    @ManyToOne
//    private Seance seance;
    
    @ManyToOne
    private Categorie categorie;
    
//    @ManyToOne
//    private Place place;
    
    @ManyToOne
    private LigneCommande ligneCommande;

    public Billet() {
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
}
