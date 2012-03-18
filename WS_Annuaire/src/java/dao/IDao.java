/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Personne;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author 10702274
 */
public interface IDao {

    /**
     * fonction de deletion d'une personne en bd
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    boolean exist(int id);

    List<Personne> findAll();

    boolean insert(String nom, String prenom, String telephone, String email);

    /**
     * fonction d'insertion d'une personne en bd
     *
     * @param pers
     * @return
     */
    boolean insert(Personne pers);

    /**
     * fonction de recherche d'une personne en bd au moin une des champs doit
     * etre rempli sinon utilisé la fonction findall on se base sur l'id
     *
     * @param nom
     * @param prenom
     * @param telephone
     * @param email
     * @return
     */
    List<Personne> select(String nom, String prenom, String telephone, String email);

    void setDatasource(DataSource datasource);

    /**
     * fonction de modification d'une personne en bd se base sur l'id
     *
     * @param nom
     * @param prenom
     * @param telephone
     * @param email
     * @return
     */
    boolean update(int id, String nom, String prenom, String telephone, String email);
}
