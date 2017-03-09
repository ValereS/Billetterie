package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private float taux;
//-----------------------------------------------------

    public Tva() {
    }

    public Tva(float taux) {
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
        if (taux >= 0) {
            this.taux = taux;
        }
    }

    @Override
    public String toString() {
        return "entities.Tva[ id=" + id + " ]";
    }

}
