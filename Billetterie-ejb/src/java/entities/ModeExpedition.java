package entities;

import enums.StatutModeExpedition;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ModeExpedition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nom;
    @Column(nullable = false, scale = 2, precision = 10)
    private BigDecimal frais;

    private String Description;

    private StatutModeExpedition statutModeExpedition;

    @OneToMany(mappedBy = "modeExpedition")
    private Collection<Commande> commandes;

    public ModeExpedition() {
    }

    public ModeExpedition(String nom, BigDecimal frais, String Description, StatutModeExpedition statutModeExpedition) {
        this.nom = nom;
        this.frais = frais;
        this.Description = Description;
        this.statutModeExpedition = statutModeExpedition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getFrais() {
        return frais;
    }

    public void setFrais(BigDecimal frais) {
        this.frais = frais;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public StatutModeExpedition getStatutModeExpedition() {
        return statutModeExpedition;
    }

    public void setStatutModeExpedition(StatutModeExpedition statutModeExpedition) {
        this.statutModeExpedition = statutModeExpedition;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return "ModeExpedition{" + "nom=" + nom + ", frais=" + frais + ", Description=" + Description + ", statutModeExpedition=" + statutModeExpedition + '}';
    }

}
