<%@page import="hr.ivor.model.Stavka"%>
<%@page import="hr.ivor.model.Kosarica"%>
<%@page import="hr.ivor.model.Proizvod"%>
<%@page import="hr.ivor.model.RequestParameterNames"%>
<%@page import="hr.ivor.model.Kategorija"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="customHeader" uri="WEB-INF/tlds/header.tld" %>
<%@taglib prefix="customFooter" uri="WEB-INF/tlds/footer.tld" %>
<%@taglib prefix="customJumbo" uri="WEB-INF/tlds/jumbo.tld" %>
<%@taglib prefix="customItemCard" uri="WEB-INF/tlds/itemcardtag.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <customHeader:header />

    </head>
    <style>

    </style>
    <body style="background-color: lightblue;">
        <div id="wrapper">
            <div id="sidebar-wrapper">
                <div class="sidenav">
                    <h3 class="sideTitle"><u>Kategorija</u> </h3>
                    <form action="shopServlet" method="post">  
                        <button type="submit" name="kategorija" value="0" class="btn-link">Sve</button>
                    </form>
                    <%
                        List<Kategorija> listaKategorija = (List<Kategorija>) session.getAttribute(RequestParameterNames.DOHVATI_KATEGORIJE_REQUEST_PARAM);
                        for (Kategorija kategorija : listaKategorija) {
                            out.println("<form action=\"shopServlet\" method=\"post\">");
                            out.println("<button type=\"submit\" name=\"kategorija\" value=\"" + kategorija.getIDKategorija() + "\" class=\"btn-link\">" + kategorija.getNaziv() + "</button>");
                            out.println("</form>");
                        }
                    %>
                </div>   
            </div>       

            <div id="page-content-wrapper">
                <div class="page-content">
                    <div class="container">
                        <div class="row" style="padding-top: 20px">

                            <%
                                List<Proizvod> listaProizvoda = (List<Proizvod>) session.getAttribute(RequestParameterNames.DOHVATI_PROIZVODE_PO_KATEGORIJI);
                                for (Proizvod proizvod : listaProizvoda) {
                                    out.println("<form action=\"dodajUKosaricuServlet\" method=\"post\">");
                                    out.println("<div class=\"col-lg-4 col-md-6 mb-4\">");
                                    out.println("<div class=\"card\" style=\"width: 18rem;\">");
                                    out.println("<div class=\"text-center\">");
                                    out.println("<img class=\"card-img-top\" src=\"" + proizvod.getSlikaURL() + "\" alt=\"Card image cap\">");
                                    out.println(" </div>");
                                    out.println("<div class=\"card-body cardbodyheight\">");
                                    out.println("<h5 class=\"card-title\">" + proizvod.getNaziv() + "</h5>");
                                    out.println(" <p class=\"card-text\">" + proizvod.getOpis() + "</p>");
                                    out.println("</div>");
                                    out.println(" <ul class=\"list-group list-group-flush\">");
                                    out.println("<li class=\"list-group-item back-card\">Cijena: " + proizvod.getCijena() + " kn</li>");
                                    out.println("<li class=\"list-group-item back-card\">Količina: <input name=\"kolicina\" type=\"number\" min=\"1\" max=\"100\" step=\"1\" value=\"1\" size=\"6\"></li>");
                                    out.println(" </ul>");
                                    out.println("<div class=\"card-body\">");
                                    out.println("<button type=\"submit\" name=\"proizvod\" onclick=\"prikaziTooltip()\" value=\"" + proizvod.getIDProizvod() + "\" class=\"btn btn-primary\">Dodaj u košaricu</button>");
                                    out.println("</form>");
                                    out.println(" </div>");
                                    out.println(" </div>");
                                    out.println(" </div>");

                                }

                            %>


                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <customFooter:footer />

</html>
<script>
    $(function prikaziTooltip() {
        $('[data-toggle="tooltip"]').tooltip('show');
    });
</script>