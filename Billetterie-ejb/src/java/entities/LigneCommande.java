package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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

    @Column
    private String nomTarif;
    @Column(nullable = false, scale = 2, precision = 10)
    private BigDecimal prix;
    @Column(nullable = false)
    private float tauxTva;
    @Column(nullable = false)
    private float tauxPromo;
    @Column(nullable = false)
    private int quantite;
//--------------------------------------------------

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Commande commande;

    @OneToMany(mappedBy = "ligneCommande")
    private List<Billet> billets;

    public LigneCommande() {
        billets = new ArrayList<>();
    }

    public LigneCommande(BigDecimal prixUnitaireHt, float tauxTva, float tauxPromo) {
        this();
        this.prix = prixUnitaireHt;
        this.tauxTva = tauxTva;
        this.tauxPromo = tauxPromo;
    }

    public LigneCommande(Tarif tarif, float tauxTva, float tauxPromo) {
        this();
        this.nomTarif = tarif.getNom();
        this.prix = tarif.getPrix();
        this.tauxTva = tauxTva;
        this.tauxPromo = tauxPromo;
    }

    public String getNomTarif() {
        return nomTarif;
    }

    public void setNomTarif(String nomTarif) {
        this.nomTarif = nomTarif;
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

    public List<Billet> getBillets() {
        return billets;
    }

    public void setBillets(List<Billet> billets) {
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

    public BigDecimal getTotalPrice() {
        BigDecimal price = getPrix().multiply(new BigDecimal(getBillets().size()));
        return roundPrice(price);
    }

    public BigDecimal getTotalPriceATI() {
        BigDecimal price = getTotalPrice().multiply(getPromotionMultiplier()).multiply(getVATMultiplier());
        return roundPrice(price);
    }

    private BigDecimal getPromotionMultiplier() {
        return new BigDecimal(1 - getTauxPromo());
    }

    private BigDecimal getVATMultiplier() {
        return new BigDecimal(1 + getTauxTva());
    }

    private BigDecimal roundPrice(BigDecimal price) {
        return price.setScale(2, RoundingMode.HALF_UP);
    }

    public int getQuantiteBillets() {
        return getBillets().size();
    }

    public Seance getSeance() {
        return getBillets().get(0).getSeance();
    }

    public Categorie getCategorie() {
        return getBillets().get(0).getCategorie();
    }

}
