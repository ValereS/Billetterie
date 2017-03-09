package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float taux;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Categorie categorie;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Seance seance;

    public Promotion() {
    }

    public Promotion(Long id, float taux) {
        this();
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }
}
