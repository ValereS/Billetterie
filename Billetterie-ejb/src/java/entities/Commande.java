package entities;

import enums.StatutCommande;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
@NamedQueries({
    @NamedQuery(name = "entities.Commande.getByClient", query = "SELECT DISTINCT c FROM Commande c JOIN c.lignesCommande lc JOIN lc.billets b WHERE c.client = :paramClient and b.seance.date >= :paramDate ORDER BY c.date DESC")
})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @Column(nullable = false, scale = 2, precision = 10)
    private BigDecimal frais;

    private StatutCommande statut;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "commande")
    private Collection<Paiement> paiements;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private Collection<LigneCommande> lignesCommande;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Client client;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private ModeExpedition modeExpedition;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Coordonnees adresseFacturation;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Coordonnees adresseLivraison;

    public Commande() {
        paiements = new ArrayList<>();
        lignesCommande = new ArrayList<>();
    }

    public Commande(BigDecimal frais, StatutCommande statut, Date date) {
        this();
        this.frais = frais;
        this.statut = statut;
        this.date = date;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public BigDecimal getFrais() {
        return frais;
    }

    public void setFrais(BigDecimal frais) {
        this.frais = frais;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(Collection<Paiement> paiements) {
        this.paiements = paiements;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ModeExpedition getModeExpedition() {
        return modeExpedition;
    }

    public void setModeExpedition(ModeExpedition modeExpedition) {
        this.modeExpedition = modeExpedition;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + numero + ", frais=" + frais + ", statut=" + statut + ", date=" + date + ", paiements=" + paiements + ", lignesCommande=" + lignesCommande + ", client=" + client + ", modeExpedition=" + modeExpedition + ", adresseFacturation=" + adresseFacturation + ", adresseLivraison=" + adresseLivraison + '}';
    }

    public Collection<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(Collection<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }

    public Coordonnees getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(Coordonnees adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public Coordonnees getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(Coordonnees adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = getFrais();
        for (LigneCommande orderLine : lignesCommande) {
            total = total.add(orderLine.getTotalPrice());
        }
        return total;
    }

    public BigDecimal getTotalPriceATI() {
        BigDecimal total = getFrais();
        for (LigneCommande orderLine : lignesCommande) {
            total = total.add(orderLine.getTotalPriceATI());
        }
        return total;
    }

}
