/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import service.Personne;

/**
 *
 * @author Toby
 */
public abstract class Requete {

    private static ListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    private static service.AnnuaireSpring bb = (service.AnnuaireSpring) bf.getBean("annuaire");

    public static List<Personne> listerUtilisateur() {
        return bb.listerUtilisateur();
    }

    public static String ajouterUtilisateur(HttpServletRequest request) {
        return bb.ajouterUtilisateur(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("telephone"), request.getParameter("email"));
    }

    public static List<Personne> rechercherUtilisateur(HttpServletRequest request) {
        return bb.rechercherUtilisateur(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("telephone"), request.getParameter("email"));
    }

    public static String SupprimerUtilisateur(HttpServletRequest request) {
        return bb.supprimerUtilisateur(Integer.parseInt(request.getParameter("id")));
    }

    public static String ModifierUtilisateur(HttpServletRequest request) {
         return bb.modifierUtilisateur(Integer.parseInt(request.getParameter("id")),
                request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("telephone"),
                request.getParameter("email"));
    }

    public static void test() {
        bb.ajouterUtilisateur("laz", "remi", "0609747512", "toto@ho.co");
    }
}
