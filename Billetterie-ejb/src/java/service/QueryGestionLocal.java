/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi505
 */
@Local
public interface QueryGestionLocal {

    List<Object> execute(final String query);

}
