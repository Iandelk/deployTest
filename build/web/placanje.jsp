<%@page import="hr.ivor.model.Osoba"%>
<%@page import="hr.ivor.model.HibernateHandler"%>
<%@page import="hr.ivor.model.Placanje"%>
<%@page import="hr.ivor.model.RequestParameterNames"%>
<%@page import="java.util.List"%>
<%@page import="hr.ivor.model.Stavka"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="customHeader" uri="WEB-INF/tlds/header.tld" %>
<%@taglib prefix="customFooter" uri="WEB-INF/tlds/footer.tld" %>


<!DOCTYPE html>
<html>
    <head>

        <script  src="https://www.paypal.com/sdk/js?client-id=AWf0S3U0IewH8t6ET9OjTSK8_HLKWSPoySXbXj5TsAlOywVDmfUQ8GH7viQc5qGghTacx0Cf9WNH9XIy&locale=en_HR&currency=USD&disable-funding=credit,card"></script>
        


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <customHeader:header />
    <body style="background-color: lightblue;">
        <div class="container bootstrap snippet" style="background-color: skyblue; margin-top: 30px; margin-bottom: 30px">
            <div style="text-align: center">
                <h1 style="padding-top: 30px; padding-bottom:30px">Plaćanje</h1>
            </div>

            <%
                long ukupnaCijena = (long) session.getAttribute(RequestParameterNames.UKUPNA_CIJENA_KOSARICE);
                List<Stavka> listaStavki = (List<Stavka>) session.getAttribute(RequestParameterNames.STAVKE_U_KOSARICI);
                out.println("<div class=\"row\">");
                out.println("<div class=\"table-responsive\">");
                out.println("<table class=\"table-placanje\">");
                out.println("<tbody>");
                for (Stavka stavka : listaStavki) {
                    out.println("<tr>");
                    out.println("<td><strong>" + stavka.getProizvodID().getNaziv() + "</strong></td>");
                    out.println("<td style=\"padding-left:5rem\">" + stavka.getBrojPrimjeraka() + " komad(a)</td>");
                    out.println("<td style=\"padding-left:5rem\">" + stavka.getBrojPrimjeraka() * stavka.getProizvodID().getCijena() + " Kn</td>");
                    out.println("</tr>");
                }
                out.println(" <tr style=\"border-top:solid;\">");
                out.println("<td colspan=\"2\" style=\"padding-top:2rem; border-top:solid\" class=\"text-right\"><strong>Ukupno</strong></td>");
                out.println("<td style=\"padding-left:5rem; padding-top:2rem\"><strong>" + ukupnaCijena + " Kn</strong></td>");
                out.println("</tr>");
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
                out.println("</div>");
            %>

            <div style="text-align: center; padding-top: 2rem; padding-bottom: 1rem;">
                <%
                    Osoba osoba = (Osoba) session.getAttribute(RequestParameterNames.PRIJAVLJENI_KORISNIK);

                    out.println("<h4><u>Puno Ime naručitelja</u></h4>");
                    out.println("<h5 style=\"padding-bottom:1rem\">" + osoba.getIme() + " " + osoba.getPrezime() + "</h5>");
                    out.println("<h4><u>Adresa naručitelja</u></h4>");
                    out.println("<h5 style=\"padding-bottom:1rem\">" + osoba.getAdresa() + "</h5>");
                %>
                <label for="nacinPlacanja" ><strong>Način plaćanja:</strong></label>
                <form method="POST" action="placanjeServlet">
                    <select id="nacinPlacanja" name="nacinPlacanja" onchange="this.form.submit()">
                        <%
                            List<Placanje> vrstePlacanja = (List<Placanje>) session.getAttribute(RequestParameterNames.VRSTE_PLACANJA);
                            for (Placanje placanje : vrstePlacanja) {
                                out.println(" <option value=\"" + placanje.getIDPlacanje() + "\">" + placanje.getVrsta() + "</option>");
                            }
                        %>

                    </select>
                </form>
            </div>
            <%
                int nacinPlacanja = (int) session.getAttribute(RequestParameterNames.NACIN_PLACANJA);
                if (nacinPlacanja == Placanje.nacinPlacanja.PAYPAL.getValue()) {
                    out.println("<div class=\"paypal_button\" id=\"payment-button-container\" style=\"text-align: center\"></div>");
                } else {
                    out.println("<form action=\"narudzbaIzvrsenaServlet\" method=\"post\">");
                    out.println("<div style=\"text-align: center\">");
                    out.println("<button type=\"submit\" style=\"background-color:#ffdf00; color: green; border: none;font-family: Jokerman; margin-bottom: 1rem\" class=\"btn btn-lg btn-primary\">Plati</button>");
                    out.println("</div>");
                    out.println("</form> ");
                   
                }
            %>

        </div>
        <script>
        

                
            paypal.Buttons({
                style: {
                    color: 'gold'
                },
                // Set up the transaction
                createOrder: function (data, actions) {
                    return actions.order.create({
                        purchase_units: [{
                                amount: {
                                    value: <%=ukupnaCijena*0.15%>
                                }
                            }]
                    });
                },

                // Finalize the transaction
                onApprove: function (data, actions) {
                    return actions.order.capture().then(function (details) {
                                  window.location.replace("narudzbaIzvrsenaServlet");            
                    });
                }



            }).render('#payment-button-container');

            $("#nacinPlacanja").val("<%=nacinPlacanja%>");

        </script>
    </body>

    <customFooter:footer />

</html>