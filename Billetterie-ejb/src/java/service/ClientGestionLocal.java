
package service;

import entities.Client;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;


@Local
public interface ClientGestionLocal {

    public Client selectByEmailPwd(String email, String mdp);
    
    public Client updateClient(Client cl);

    Client selectByEmail(String email);

    void create(Client client);

    
    
}
