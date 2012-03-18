/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import requete.Requete;
import service.Personne;
import utils.Utils;

/**
 *
 * @author Toby
 */
public class ListerUtilisateur extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<Personne> list;
        Iterator<Personne> it;
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListerUtilisateur</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListerUtilisateur at " + request.getContextPath() + "</h1>");
            out.println("<A HREF=\"./index.jsp\"> Acceuil </A>");

            out.println("<p>Champs de recherche</p>");
            out.println(Utils.formPersonne());

            String type = null;
            type = request.getParameter("nom");

            /*si la page est appelé avec des parametre
             * on declenche une requete au ws et on affiche le retour
             *sinon on affiche tt les utilisateur
             */
            if (type != null) {

                list = new ArrayList(Requete.rechercherUtilisateur(request));
                out.println("<a href='ListerUtilisateur'>Liste complète</a><br/>");
                out.println("<p>Resultat de la recherche -------------></p>");

            } else {
                list = new ArrayList(Requete.listerUtilisateur());
                out.println("<p>Tous les utilisateurs -------------></p>");
            }
            it = list.iterator();
            if (list.isEmpty()) {
                out.println("<br/><p>la recherche n'a renvoyé aucun element</p>");
            }
            while (it.hasNext()) {
                Personne pers = it.next();
                out.println("<p>Nom : " + pers.getNom()
                        + " Prenom  : " + pers.getPrenom()
                        + " Tel : " + pers.getTelephone()
                        + " Email : " + pers.getEmail()
                        + "</p>");
                if (request.isUserInRole("ROLE_ADMIN")) {
                    String str = ("<form name=\"formulaire2\" action=\"./ModifierUtilisateur\" method=\"post\">");
                    str += ("<input type=\"hidden\" name=\"id\" value=" + pers.getId() + " /> ");
                    str += ("<input type=\"hidden\" name=\"nom\" value=" + pers.getNom() + " /> ");
                    str += ("<input type=\"hidden\" name=\"prenom\" value=" + pers.getPrenom() + " /> ");
                    str += ("<input type=\"hidden\" name=\"telephone\" value=" + pers.getTelephone() + " /> ");
                    str += ("<input type=\"hidden\" name=\"email\" value=" + pers.getEmail() + " /> ");
                    str += ("<input type=\"hidden\" name=\"autre\" value=\"premier\" /> ");                    
                    str += ("<input type='submit' value=\"modifier\">");
                    str += ("</form>");
                    out.println(str);
                    str = ("<form name=\"formulaire3\" action=\"./SupprimerUtilisateur\" method=\"post\">");
                    str += ("<input type=\"hidden\" name=\"id\" value=" + pers.getId() + " /> ");
                    str += ("<input type='submit' value=\"supprimer\">");
                    str += ("</form>");
                    out.println(str);


                }
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
