/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.servlet;

import hr.ivor.model.RequestParameterNames;
import hr.ivor.model.Stavka;
import java.io.IOException;
import java.io.PrintWriter;
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
public class kosaricaServlet extends HttpServlet {

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

        if (session.getAttribute(RequestParameterNames.STAVKE_U_KOSARICI) != null) {
            List<Stavka> listaStavki = (List<Stavka>) session.getAttribute(RequestParameterNames.STAVKE_U_KOSARICI);
            if (request.getParameter("kolicinaKosarica") != null && request.getParameter("proizvodKosarica") != null) {
                int novaKolicina =  Integer.parseInt(request.getParameter("kolicinaKosarica"));
                int proizvodID = Integer.parseInt(request.getParameter("proizvodKosarica"));

                listaStavki.stream().filter((stavka) -> (stavka.getProizvodID().getIDProizvod() == proizvodID)).forEachOrdered((stavka) -> {
                    stavka.setBrojPrimjeraka(novaKolicina);
                });
            }
                if (request.getParameter("brisanjeProizvodaKosarica") != null && request.getParameter("proizvodZaBrisanje") != null) {
                int proizvodZaBrisanje = Integer.parseInt(request.getParameter("proizvodZaBrisanje"));
                Stavka stavkaZabrisanje = new Stavka();
                 for(Stavka stavka : listaStavki){
                     if (stavka.getProizvodID().getIDProizvod() == proizvodZaBrisanje){
                         stavkaZabrisanje = stavka;
                         break;
                     }
                 }
               listaStavki.remove(stavkaZabrisanje);    
             int  ukupnaKolicina = listaStavki.stream().mapToInt(s -> s.getBrojPrimjeraka()).sum();
               session.setAttribute(RequestParameterNames.BROJ_STAVKI_U_KOSARICI, ukupnaKolicina);
            }
            long ukupnaCijena = 0;
            for (Stavka stavka : listaStavki) {
                ukupnaCijena = ukupnaCijena + (stavka.getProizvodID().getCijena() * stavka.getBrojPrimjeraka());
            }
            
            session.setAttribute(RequestParameterNames.UKUPNA_CIJENA_KOSARICE, ukupnaCijena);
        }
        response.sendRedirect("kosarica.jsp");
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
