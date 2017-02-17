
package entities;

import java.io.Serializable;
import java.net.URL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private URL url;
         
    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Image() {
    }

    public Image(URL url) {
       
        this.url = url;
    }
//      
    

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Image)) {
//            return false;
//        }

    @Override
    public String toString() {
        return "entities.Image[ url=" + url + " ]";
    }

}


