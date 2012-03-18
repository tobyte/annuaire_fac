/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Personne;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * WS standard sans bean non utilisé...
 * @author Toby
 */
@WebService(serviceName = "Annuaire")
public class Annuaire {

    metier.Metier objet;

    public Annuaire() {
        objet = new metier.Metier();
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ajouterUtilisateur")
    public String ajouterUtilisateur(@WebParam(name = "nom") String nom,
            @WebParam(name = "prenom") String prenom,
            @WebParam(name = "telephone") String telephone,
            @WebParam(name = "email") String email) {
        return objet.ajouterUtilisateur(nom, prenom, telephone, email);
    }

    @WebMethod(operationName = "supprimerUtilisateur")
    public String supprimerUtilisateur(@WebParam(name = "name") int id) {
        return objet.supprimerUtilisateur(id);
    }

    @WebMethod(operationName = "rechercherUtilisateur")
    public List<Personne> rechercherUtilisateur(@WebParam(name = "nom") String nom,
            @WebParam(name = "prenom") String prenom,
            @WebParam(name = "telephone") String telephone,
            @WebParam(name = "email") String email) {
        return objet.rechercherUtilisateur(nom, prenom, telephone, email);
    }

    @WebMethod(operationName = "listerUtilisateur")
    public List<entity.Personne> listerUtilisateur() {
        return objet.listerUtilisateur();
    }

    @WebMethod(operationName = "modifierUtilisateur")
    public String modifierUtilisateur(@WebParam(name = "id") int id,
            @WebParam(name = "nom") String nom,
            @WebParam(name = "prenom") String prenom,
            @WebParam(name = "telephone") String telephone,
            @WebParam(name = "email") String email) {
        return objet.modifierUtilisateur(id, nom, prenom, telephone, email);
    }
}
