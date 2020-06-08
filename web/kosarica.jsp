<%@page import="hr.ivor.model.RequestParameterNames"%>
<%@page import="java.util.List"%>
<%@page import="hr.ivor.model.Stavka"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="customHeader" uri="WEB-INF/tlds/header.tld" %>
<%@taglib prefix="customFooter" uri="WEB-INF/tlds/footer.tld" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <customHeader:header />

    </head>
    <body style="background-color: lightblue;">

        <div class="container bootstrap snippet" style="background-color: skyblue; margin-top: 30px; margin-bottom: 30px">

            <%

                if (session.getAttribute(RequestParameterNames.STAVKE_U_KOSARICI) == null || session.getAttribute(RequestParameterNames.UKUPNA_CIJENA_KOSARICE) == null ) {
                    out.println("<h1 style=\"text-align:center;padding-top:24vh;padding-bottom:24vh;+\">Košarica je prazna!</h1>");
                } else {                   
                    long ukupnaCijena = (long)session.getAttribute(RequestParameterNames.UKUPNA_CIJENA_KOSARICE);
                     if(ukupnaCijena != 0){
                    List<Stavka> listaStavki = (List<Stavka>) session.getAttribute(RequestParameterNames.STAVKE_U_KOSARICI);
                    out.println("<div class=\"row\">");
                    out.println("<div class=\"table-responsive\">");
                    out.println(" <table class=\"table\">");
                    out.println("  <thead>");
                    out.println(" <tr style=\"color:green; font-family: Jokerman\">");
                    out.println("<th>Proizvod</th>");
                    out.println(" <th>Opis</th>");
                    out.println(" <th>Broj primjeraka</th>");
                    out.println("<th>Cijena</th>");
                    out.println("<th>Ukupno</th>");
                    out.println(" </tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    for (Stavka stavka : listaStavki) {
                        out.println("<tr>");
                        out.println("<td><img src=\"" + stavka.getProizvodID().getSlikaURL() + "\" class=\"img-cart\"></td>");
                        out.println("<td><strong>" + stavka.getProizvodID().getNaziv() + "</strong></td>");
                        out.println("<td>");
                        out.println("<div class=\"form-inline\">"); 
                        out.println("<form action=\"kosaricaServlet\" method=\"post\">");
                        out.println(" <input type=\"hidden\" name=\"proizvodKosarica\" value=\""+stavka.getProizvodID().getIDProizvod()+"\">");
                        out.println("<input name=\"kolicinaKosarica\" class=\"form-control\" type=\"number\" min=\"1\" max=\"100\" step=\"1\" value=\""+stavka.getBrojPrimjeraka()+"\">");
                        out.println("<button type=\"submit\" rel=\"tooltip\" style=\"background-color: #ffdf00\" data-toggle=\"tooltip\" title=\"Promjeni količinu\" class=\"btn btn-default\"><i class=\"fa fa-pencil\"></i></button>");
                        out.println("</form>");
                        out.println("<form action=\"kosaricaServlet\" method=\"post\">");
                        out.println("<input type=\"hidden\" name=\"proizvodZaBrisanje\" value=\""+stavka.getProizvodID().getIDProizvod()+"\">");
                        out.println("<button type=\"submit\" name=\"brisanjeProizvodaKosarica\" value=\"1\" data-toggle=\"tooltip\" title=\"Ukloni proizvod\" style=\"background-color: red\" class=\"btn btn-primary\"><i class=\"fa fa-trash-o\"></i></button>");
                        out.println("</form>");
                        out.println("</div>");
                        out.println(" </td>");
                        out.println(" <td>" + stavka.getProizvodID().getCijena() + " Kn</td>");
                        out.println("<td>" + stavka.getBrojPrimjeraka() * stavka.getProizvodID().getCijena() + " Kn</td>");
                        out.println("</tr>");
                    }
                    out.println(" <tr>");
                    out.println("<td colspan=\"4\" class=\"text-right\"><strong>Ukupno</strong></td>");
                    out.println("<td><strong>"+ukupnaCijena+" Kn</strong></td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                    out.println("</table>");

                    out.println("<a href=\"placanjeServlet\" style=\"background-color:#ffdf00; color: green; border: none;font-family: Jokerman; margin: 8px\" class=\"btn btn-lg btn-primary float-right\">Nastavi s plaćanjem</a>");
                    out.println("</div>");
                    out.println("</div>");

                }else{
                        out.println("<h1 style=\"text-align:center;padding-top:24vh;padding-bottom:24vh;+\">Košarica je prazna!</h1>");
                    }
                    }
            %>


        </div>            


    </body>

    <customFooter:footer />

</html>