/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Toby
 */
public abstract class Utils {

    public static String formPersonne() {
        String str = ("<form name=\"formulaire\" method=\"post\">");
        str += ("Nom <input type=\"text\" name=\"nom\" /> <br/>");
        str += ("Prenom <input type=\"text\" name=\"prenom\" /> <br/>");
        str += ("Telephone <input type=\"text\" name=\"telephone\" /> <br/>");
        str += ("Email <input type=\"text\" name=\"email\" /> <br/>");
        str += ("<input type='submit'><br/>");
        str += ("</form>");
        return str;
    }
}
