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
import utils.Utils;

/**
 *
 * @author Toby
 */
public class AjouterUtilisateur extends HttpServlet {

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
            out.println("<title>Servlet AjouterUtilisateur</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjouterUtilisateur at " + request.getContextPath() + "</h1>");

            /*si la page est appelé avec des parametre
             * on declenche une requete au ws et on affiche le retour*/
            String type = null;
            type = request.getParameter("nom");

            if (type != null) {
                out.println(Requete.ajouterUtilisateur(request));
            }
           
            out.println(Utils.formPersonne());
//            out.println("<form method='POST'>");
//            out.println("Nom: <input type='text' name='nom'><br/>");
//            out.println("Prenom: <input type='text' name='prenom'><br/>");
//            out.println("telephone: <input type='text' name='telephone'><br/>");
//            out.println("email: <input type='text' name='email'><br/>");
//            out.println("<input type='submit'><br/>");
//            out.println("</form>");

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
