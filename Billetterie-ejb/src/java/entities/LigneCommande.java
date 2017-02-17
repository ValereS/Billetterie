package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LigneCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private BigDecimal prix;
    @Column(nullable = false)
    private float tauxTva;
    @Column(nullable = false)
    private float tauxPromo;
    @Column(nullable = false)
    private int quantite;
//--------------------------------------------------
    
    @ManyToOne
    private Commande commande;
    
    @OneToMany(mappedBy = "ligneCommande")
    private Collection<Billet> billets;

    public LigneCommande() {
    }

    public LigneCommande(BigDecimal prixUnitaireHt, float tauxTva, float tauxPromo) {
        this.prix = prixUnitaireHt;
        this.tauxTva = tauxTva;
        this.tauxPromo = tauxPromo;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public float getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(float tauxTva) {
        this.tauxTva = tauxTva;
    }

    public float getTauxPromo() {
        return tauxPromo;
    }

    public void setTauxPromo(float tauxPromo) {
        this.tauxPromo = tauxPromo;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Collection<Billet> getBillets() {
        return billets;
    }

    public void setBillets(Collection<Billet> billets) {
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
        return "entities.LigneCommande[ id=" + id + " ]";
    }
    
}