package service;

import entities.Client;
import entities.Coordonnees;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface ClientGestionLocal {

    public Client selectByEmailPwd(String email, String mdp);

    public Client updateClient(Client cl);

    Client selectByEmail(String email);

    void create(Client client);

    public Client addAddress(Client cl, Coordonnees cc);

}
