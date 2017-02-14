package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TVA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private float taux;
//-----------------------------------------------------
    public TVA() {
        
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
    
    @Override
    public String toString() {
        return "entities.Tva[ id=" + id + " ]";
    }
    
}
