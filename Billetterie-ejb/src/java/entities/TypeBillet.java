package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeBillet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(nullable = false, length = 200)
    private String description;
//-------------------------------------------------

    public TypeBillet() {
    }

    public TypeBillet(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "entities.TypeBillet[ id=" + id + " ]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TypeBillet other = (TypeBillet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public static enum Type {

        NUMEROTE(1L, "Placement numéroté"),
        LIBRE(2L, "Placement libre");

        private final Long id;
        private final String description;

        Type(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Long getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }
    }

}
