/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.servlet;

import hr.ivor.model.HibernateHandler;
import hr.ivor.model.Osoba;
import hr.ivor.model.RequestParameterNames;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Phyrexian
 */
public class prijavaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        HibernateHandler handler = new HibernateHandler();
        String username = request.getParameter("usernameLogin");
        String password = request.getParameter("passwordLogin");

        Osoba osoba = handler.provjeriLogin(username, password);

        if (osoba != null) {
            session.setAttribute(RequestParameterNames.PRIJAVLJENI_KORISNIK, osoba);
            if (session.getAttribute(RequestParameterNames.STAVKE_U_KOSARICI) == null) {
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("kosarica.jsp");
            }
        } else {

            response.sendRedirect("prijava.jsp");
            session.setAttribute(RequestParameterNames.NESUPJESNA_PRIJAVA, 1);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
