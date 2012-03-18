/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Personne;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Toby
 */
@WebService
public interface AnnuaireSpring {

    String ajouterUtilisateur(String nom, String prenom, String telephone, String email);

    List<Personne> listerUtilisateur();

    String modifierUtilisateur(int id, String nom, String prenom, String telephone, String email);

    List<Personne> rechercherUtilisateur(String nom, String prenom, String telephone, String email);

    String supprimerUtilisateur(int id);
}

