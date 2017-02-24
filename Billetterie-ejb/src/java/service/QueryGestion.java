/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi505
 */
@Stateless
public class QueryGestion implements QueryGestionLocal {

    @PersistenceContext(unitName = "Billetterie-ejbPU")
    private EntityManager em;

    @Override
    public List<Object> getResultList(String query) {
        Query qr = em.createQuery(query);
        return qr.getResultList();
    }

    @Override
    public int executeUpdate(String query) {
        Query qr = em.createQuery(query);
        return qr.executeUpdate();
    }

    @Override
    public List<Object> execute(String query) {
        List<Object> resultList;
        if (StringStartsWithIgnoreCase(query, "update")
                || StringStartsWithIgnoreCase(query, "delete")) {
            resultList = Arrays.asList(executeUpdate(query));
        } else {
            resultList = getResultList(query);
        }
        return resultList;
    }

    private static boolean StringStartsWithIgnoreCase(String string,
            String prefix) {
        return string.substring(0, prefix.length()).equalsIgnoreCase(prefix);
    }

}
