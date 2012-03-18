/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import requete.Requete;

/**
 *
 * @author Toby
 */
public class ModifierUtilisateur extends HttpServlet {

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
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModifierUtilisateur</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifierUtilisateur at " + request.getContextPath() + "</h1>");
            String type = request.getParameter("autre");

               /*
                * si la requete vient de la page de recherche d'un utilisateur
                * on affiche le champs pr le modifier
                * sinon on afficher le resultat de l'appel du ws
                */
            if (type.equals("premier")) {
                out.println("<p>Nom : " + request.getParameter("nom")
                        + " Prenom  : " + request.getParameter("prenom")
                        + " Tel : " + request.getParameter("telephone")
                        + " Email : " + request.getParameter("email")
                        + "</p>");
                String str = ("<form name=\"formulaire2\" action=\"./ModifierUtilisateur\" method=\"post\">");
                str += ("<input type=\"hidden\" name=\"id\" value=" + request.getParameter("id") + " /> ");
                str += ("Nom <input type=\"text\" name=\"nom\" /><br/> ");
                str += ("Prenom <input type=\"text\" name=\"prenom\" /><br/>  ");
                str += ("Telephone<input type=\"text\" name=\"telephone\" /><br/>  ");
                str += ("Email <input type=\"text\" name=\"email\" /><br/>  ");
                str += ("<input type=\"hidden\" name=\"autre\" value=\"deuxieme\" /> ");
                str += ("<input type='submit' value=\"modifier\">");
                str += ("</form>");
                out.println(str);

            }
            else if (type.equals("deuxieme")) {
                out.println("<p>" + Requete.ModifierUtilisateur(request) + "</p>");
            }
            out.println("<A HREF=\"./index.jsp\"> Acceuil </A>");
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
