package service;

import entities.Client;
import enums.CiviliteClient;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Stateless
public class ClientGestion implements ClientGestionLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public Client selectByEmailPwd(String email, String mdp) {
        Client c = selectByEmail(email);
        return c != null && c.checkMotPasse(mdp) ? c : null;
    }

    @Override
    public Client selectByEmail(String email) {
        Query qr = em.createNamedQuery("entities.Client.selectByEmail");
        qr.setParameter("paramEmail", email);
        try {
            Client c = (Client) qr.getSingleResult();
            return c;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void create(Client client) {
        em.persist(client);
    }

    @Override
    public Client updateClient(Client cl) {
        return em.merge(cl);
    }

}
