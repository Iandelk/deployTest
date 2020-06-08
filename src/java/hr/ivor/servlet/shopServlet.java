/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.servlet;

import hr.ivor.model.HibernateHandler;
import hr.ivor.model.Kategorija;
import hr.ivor.model.Proizvod;
import hr.ivor.model.RequestParameterNames;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Phyrexian
 */
public class shopServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void fetchCategories(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HibernateHandler handler = new HibernateHandler();
        HttpSession session = request.getSession();
        
        
        String kategorija = request.getParameter("kategorija");
         List<Proizvod> listaProizvoda = handler.dohvatiProizvode();
         if(kategorija != null){
     if (kategorija.equals("1")){
      
           listaProizvoda = listaProizvoda.stream().filter(x->x.getKategorijaID().getIDKategorija().toString().equals(kategorija)).collect(Collectors.toList());
        }else if (kategorija.equals("2"))
        {
            listaProizvoda =   listaProizvoda.stream().filter(x->x.getKategorijaID().getIDKategorija().toString().equals(kategorija)).collect(Collectors.toList());
        }else if(kategorija.equals("3")){
            listaProizvoda = listaProizvoda.stream().filter(x->x.getKategorijaID().getIDKategorija().toString().equals(kategorija)).collect(Collectors.toList());
        }
         }         
        session.setAttribute(RequestParameterNames.DOHVATI_PROIZVODE_PO_KATEGORIJI, listaProizvoda);
        session.setAttribute(RequestParameterNames.DOHVATI_KATEGORIJE_REQUEST_PARAM,handler.dohvatiKategorije());       
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
        fetchCategories(request, response);
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
        fetchCategories(request, response);
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
