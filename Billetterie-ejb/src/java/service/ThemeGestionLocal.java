/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.SousTheme;
import entities.Theme;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi515
 */
@Local
public interface ThemeGestionLocal {

    List<Theme> selectAll();

    public List<SousTheme> selectSousThemeByTheme(Theme theme);

}
