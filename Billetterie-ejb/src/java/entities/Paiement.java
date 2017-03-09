package entities;

import enums.ModePaiement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, scale = 2, precision = 10)
    private BigDecimal montant;

    private ModePaiement modePaiement;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Commande commande;

    public Paiement() {
    }

    public Paiement(BigDecimal montant, ModePaiement modePaiement, Date date) {
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "Paiement{" + "id=" + id + ", montant=" + montant + ", modePaiement=" + modePaiement + ", date=" + date + '}';
    }

}
