package service.testdata;

import java.text.ParseException;
import javax.ejb.Local;

@Local
public interface TestDataValereLocal {
    public void creerDonnees();
}
