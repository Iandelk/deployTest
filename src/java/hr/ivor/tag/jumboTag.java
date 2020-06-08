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
public class jumboTag extends SimpleTagSupport{


    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String message;
    private String title;
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write(" <div class=\"jumbotron jumbotron-fluid\" style=\"margin:10px 10px;background-color:skyblue;border-width:0px;border:none;border-color:green;border-radius:20px;\">");
  out.write("<div class=\"container\">") ;
   out.write("<h1 class=\"display-8\">"+title+"</h1>")  ;
    out.write(" <p class=\"lead\">"+message+"</p>");
  out.write("</div>") ;
 out.write("</div>");
    }
    
    
    
}
