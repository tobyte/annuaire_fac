/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Personne;
import java.util.List;

/**
 *
 * @author Toby
 */
public class AnnuaireSpringImpl implements AnnuaireSpring {

    metier.Metier objet;

    public AnnuaireSpringImpl() {
        objet = new metier.Metier();
    }

    /**
     * This is a sample web service operation
     */
    public String ajouterUtilisateur(String nom,
            String prenom,
            String telephone,
            String email) {
        return objet.ajouterUtilisateur(nom, prenom, telephone, email);

    }

    public String supprimerUtilisateur(int id) {
        return objet.supprimerUtilisateur(id);
    }

    public List<Personne> rechercherUtilisateur(String nom,
            String prenom,
            String telephone,
            String email) {
        return objet.rechercherUtilisateur(nom, prenom, telephone, email);
    }

    public List<entity.Personne> listerUtilisateur() {
        return objet.listerUtilisateur();
    }

    public String modifierUtilisateur(int id,
            String nom,
            String prenom,
            String telephone,
            String email) {
        return objet.modifierUtilisateur(id, nom, prenom, telephone, email);
    }
}
