/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.servlet;

import hr.ivor.model.HibernateHandler;
import hr.ivor.model.Kosarica;
import hr.ivor.model.Proizvod;
import hr.ivor.model.RequestParameterNames;
import hr.ivor.model.Stavka;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Phyrexian
 */
public class dodajUKosaricuServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Kosarica kosarica = new Kosarica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HibernateHandler handler = new HibernateHandler();
        HttpSession session = request.getSession();
        boolean isDuplicate = false;
        int proizvodID = Integer.parseInt(request.getParameter("proizvod"));
        int brojPrimjeraka = Integer.parseInt(request.getParameter("kolicina"));
        int ukupnaKolicina = 0;
        Proizvod proizvod = handler.dohvatiProizvod(proizvodID);
        List<Stavka> stavkeUKosarici = new ArrayList<>();    
        
        if (session.getAttribute(RequestParameterNames.STAVKE_U_KOSARICI) != null) {
            stavkeUKosarici = (List<Stavka>) session.getAttribute(RequestParameterNames.STAVKE_U_KOSARICI);
        }

        for (Stavka stvk : stavkeUKosarici) {
            if (stvk.getProizvodID().getIDProizvod() == proizvodID) {
                stvk.setBrojPrimjeraka(stvk.getBrojPrimjeraka() + brojPrimjeraka);
                isDuplicate = true;
            }
        }

        if (!isDuplicate) {
            Stavka stavka = new Stavka();
            stavka.setBrojPrimjeraka(brojPrimjeraka);
            stavka.setProizvodID(proizvod);
            stavka.setKosaricaID(kosarica);
            stavkeUKosarici.add(stavka);
        }
        ukupnaKolicina = stavkeUKosarici.stream().mapToInt(s -> s.getBrojPrimjeraka()).sum();
        session.setAttribute(RequestParameterNames.BROJ_STAVKI_U_KOSARICI, ukupnaKolicina);
        session.setAttribute(RequestParameterNames.STAVKE_U_KOSARICI, stavkeUKosarici);
        response.sendRedirect("shop.jsp");

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
