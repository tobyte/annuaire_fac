/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entity.Personne;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Toby
 */
public class Metier {

    dao.DerbyDao dao;

    public Metier() {
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        dao = (dao.DerbyDao) bf.getBean("dao");
        //System.out.println(dao.findAll().toString());

    }

    public List<entity.Personne> listerUtilisateur() {
        return dao.findAll();
    }

    /**
     * ajout d'utilisateur verification le mail doit etre correct le numero de
     * telephone doit etre correct ex : 0135 55 55 55 - 09 33 33 33 33 33 les
     * numero en 08 sont accepté non prise en charge des numero +33 ....
     *
     * @param pers
     * @return
     */
    public String ajouterUtilisateur(entity.Personne pers) {
        try {
            InternetAddress tmp = new InternetAddress(pers.getEmail(), true);
        } catch (AddressException ex) {
            return "L'email est invalide";
        }
        if (!pers.getTelephone().matches("0[1-9]+[0-9]{8}+")) {
            return "Le numéro de téléphone n'est pas valide";
        }
        boolean reponse = dao.insert(pers);

        if (reponse) {
            return "Ajout effectué";
        } else {
            return "l'ajout de l'utilisateur a échoué : erreur BD";
        }

    }

    /**
     * surcharge de la methode precedente utilisé pour les test sur WS
     *
     * @param nom
     * @param prenom
     * @param telephone
     * @param email
     * @return
     */
    public String ajouterUtilisateur(String nom, String prenom, String telephone, String email) {
        try {
            InternetAddress tmp = new InternetAddress(email, true);
        } catch (AddressException ex) {
            return "L'email est invalide";
        }
        if (!telephone.matches("0[1-9]+[0-9]{8}+")) {
            return "Le numéro de téléphone n'est pas valide";
        }
        boolean reponse = dao.insert(nom, prenom, telephone, email);

        if (reponse) {
            return "Ajout effectué";
        } else {
            return "l'ajout de l'utilisateur a échoué : erreur BD";
        }

    }

    /**
     * supression d'un utilisateur on verifie que l'utilisateur existe bien
     *
     * @param id
     * @return
     */
    public String supprimerUtilisateur(int id) {
        if (dao.exist(id)) {
            boolean reponse = dao.delete(id);

            if (reponse) {
                return "Supression effectué";
            } else {
                return "La supression de l'utilisateur a échoué : erreur BD";
            }
        } else {
            return "L'utilisateur à supprimer n'existe pas";
        }
    }

    /**
     * recherche d'utilisateur on verifi si au moin un des champs est rempli la
     * commande en bd renvoi un erreur qui est transformé en null donc autant
     * renvoyé null des le debut
     *
     * @param nom
     * @param prenom
     * @param telephone
     * @param email
     * @return
     */
    public List<Personne> rechercherUtilisateur(String nom,
            String prenom,
            String telephone,
            String email) {
        if (nom.equals("")) {
            nom = null;
        }
        if (prenom.equals("")) {
            prenom = null;
        }
        if (telephone.equals("")) {
            telephone = null;
        }
        if (email.equals("")) {
            email = null;
        }
        if ((nom == null) && (prenom == null)
                && (telephone == null)
                && (email == null)) {
            return null;

        } else {
            //  "Un des champs doit au moin etre rempli";

            return dao.select(nom, prenom, telephone, email);

        }

    }

    /**
     * modification d'un utilisateur on verifie que l'utilisateur existe bien on
     * verifi qu'au moin un des champs est rempli
     *
     * @param id
     * @param nom
     * @param prenom
     * @param telephone
     * @param email
     * @return
     */
    public String modifierUtilisateur(int id, String nom,
            String prenom,
            String telephone,
            String email) {

        if (nom.equals("")) {
            nom = null;
        }
        if (prenom.equals("")) {
            prenom = null;
        }
        if (telephone.equals("")) {
            telephone = null;
        }
        if (email.equals("")) {
            email = null;
        }
        if (dao.exist(id)) {
            if ((nom == null) && (prenom == null)
                    && (telephone == null)
                    && (email == null)) {
                return "Un des champs doit au moin etre rempli";
            } else {
                boolean reponse = dao.update(id, nom, prenom, telephone, email);

                if (reponse) {
                    return "Modification effectué";
                } else {
                    return "la modification de l'utilisateur a échoué : erreur BD";
                }
            }
        } else {
            return "L'utilisateur à modifier n'existe pas";
        }
    }
}
