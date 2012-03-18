/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Personne;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author 10702274
 */
public class DerbyDao implements IDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDatasource(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Personne> findAll() {
        String requete = "select * from annuaire.personne";
        return this.jdbcTemplate.query(requete,
                new BeanPropertyRowMapper(Personne.class));
    }

    @Override
    public boolean insert(String nom, String prenom, String telephone, String email) {
        String requete = "INSERT INTO annuaire.personne(nom, prenom, telephone, email)"
                + "VALUES('"
                + nom
                + "','"
                + prenom
                + "','"
                + telephone
                + "','"
                + email
                + "')";
        try {
            this.jdbcTemplate.execute(requete);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * fonction d'insertion d'une personne en bd
     *
     * @param pers
     * @return
     */
    @Override
    public boolean insert(entity.Personne pers) {
        String requete = "INSERT INTO annuaire.personne(nom, prenom, telephone, email)"
                + "VALUES('"
                + pers.getNom()
                + "','"
                + pers.getPrenom()
                + "','"
                + pers.getTelephone()
                + "','"
                + pers.getEmail()
                + "')";
        try {
            this.jdbcTemplate.execute(requete);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * fonction de deletion d'une personne en bd
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        String requete = "DELETE FROM annuaire.personne WHERE id = " + id;
        try {
            this.jdbcTemplate.execute(requete);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

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
    @Override
    public List<Personne> select(String nom, String prenom, String telephone, String email) {
        String requete = "select * from annuaire.personne WHERE ";
        if (nom != null) {
            requete += "nom = '" + nom + "'";
            if (prenom != null) {
                requete += "and prenom = '" + prenom + "'";
                if (telephone != null) {
                    requete += "and telephone = '" + telephone + "'";
                    if (email != null) {
                        requete += "and email = '" + email + "'";
                    }
                }
            }
        } else if (prenom != null) {
            requete += "prenom = '" + prenom + "'";
            if (telephone != null) {
                requete += "and telephone = '" + telephone + "'";
                if (email != null) {
                    requete += "and email = '" + email + "'";
                }
            }
        } else if (telephone != null) {
            requete += " telephone = '" + telephone + "'";
            if (email != null) {
                requete += "and email = '" + email + "'";
            }
        } else if (email != null) {
            requete += "email = '" + email + "'";
        }
        try {
            return this.jdbcTemplate.query(requete,
                    new BeanPropertyRowMapper(Personne.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * fonction de modification d'une personne en bd se base sur l'id
     *
     * @param nom
     * @param prenom
     * @param telephone
     * @param email
     * @return
     */
    @Override
    public boolean update(int id, String nom, String prenom, String telephone, String email) {
        String requete = "UPDATE annuaire.personne SET ";

        if (nom != null) {
            requete += "nom = '" + nom + "'";
            if (prenom != null) {
                requete += ", prenom = '" + prenom + "'";
                if (telephone != null) {
                    requete += ", telephone = '" + telephone + "'";
                    if (email != null) {
                        requete += ", email = '" + email + "'";
                    }
                }
            }
        } else if (prenom != null) {
            requete += "prenom = '" + prenom + "'";
            if (telephone != null) {
                requete += ", telephone = '" + telephone + "'";
                if (email != null) {
                    requete += ", email = '" + email + "'";
                }
            }
        } else if (telephone != null) {
            requete += " telephone = '" + telephone + "'";
            if (email != null) {
                requete += ", email = '" + email + "'";
            }
        } else if (email != null) {
            requete += "email = '" + email + "'";
        }
        requete += " WHERE id = " + id;
        try {
            this.jdbcTemplate.execute(requete);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean exist(int id) {
        String requete = "SELECT 1 FROM annuaire.personne WHERE id = " + id;
        try {
            List list = this.jdbcTemplate.query(requete, new BeanPropertyRowMapper(Personne.class));
            if(list.isEmpty()){
                return false;
            }
            else
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
