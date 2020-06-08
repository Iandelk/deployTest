/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Phyrexian
 */
public class itemCardTag extends SimpleTagSupport{

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public void setUrlSlika(String urlSlika) {
        this.urlSlika = urlSlika;
    }

  

private String naziv;
private String opis;
private double cijena;
private String urlSlika;
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
 out.write("<div class=\"card\" style=\"width: 18rem;\">"); 
  out.write("<img class=\"card-img-top\" src=\""+urlSlika+"\" alt=\"Card image cap\">"); 
  out.write("<div class=\"card-body\">"); 
  out.write("<h5 class=\"card-title\">"+naziv+"</h5>");   
  out.write(" <p class=\"card-text\">"+opis+"</p>");  
 out.write("</div>");  
 out.write(" <ul class=\"list-group list-group-flush\">"); 
  out.write("<li class=\"list-group-item\">"+cijena+"</li>");   
 out.write(" </ul>"); 
 out.write("<div class=\"card-body\">");  
  out.write(" <INPUT TYPE=\"NUMBER\" MIN=\"0\" MAX=\"10\" STEP=\"2\" VALUE=\"6\" SIZE=\"6\">");  
  out.write("<a href=\"#\" class=\"btn btn-primary\">Another link</a>");   
 out.write(" </div>"); 
out.write(" </div>");
    }
}
