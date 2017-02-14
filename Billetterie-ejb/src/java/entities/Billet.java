package entities;

import java.io.Serializable;
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
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return "entities.Billet[ id=" + numero + " ]";
    }
}
