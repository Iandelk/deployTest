<%@page import="hr.ivor.model.RequestParameterNames"%>
<%@page import="hr.ivor.model.Osoba"%>
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
   <%   Osoba osoba = new Osoba("","","","","","");
  if(session.getAttribute(RequestParameterNames.OSOBA_REGISTRACIJA_TEMP) != null){
       osoba = (Osoba) session.getAttribute(RequestParameterNames.OSOBA_REGISTRACIJA_TEMP);
       
   }%>
    <body style="background-color: lightblue;">
        <div class="container bootstrap snippet " style="background-color: skyblue; margin-top: 50px; margin-bottom: 50px; font-family: Jokerman;">
            <div style="text-align: center">
                <h1 style="padding-top: 30px; padding-bottom: 30px;">Registracija</h1>
            </div>
            <form style="padding-bottom: 20px;" action="registracijaServlet" method="post">
            <div class="form-row">
    <div class="form-group col-md-6">
      <label for="tx_ime" class="login_txt_size">Ime</label>
      <input type="text" class="form-control txt_login_reg_font" value="<%=osoba.getIme()%>" name="tx_imeRegistracija" id="tx_ime" placeholder="Ime">
    </div>
    <div class="form-group col-md-6">
      <label for="tx_prezime" class="login_txt_size">Prezime</label>
      <input type="text" class="form-control txt_login_reg_font" value="<%=osoba.getPrezime()%>" name="tx_prezimeRegistracija" id="tx_prezime" placeholder="Prezime">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="tx_emailRegistracija" class="login_txt_size">E-mail</label>
      <input type="text" class="form-control txt_login_reg_font" value="<%=osoba.getEmail()%>" name="tx_emailRegistracija" id="tx_emailRegistracija" placeholder="primjer@mail.com">
    </div>
    <div class="form-group col-md-6">
      <label for="tx_adresaRegistracija" class="login_txt_size">Adresa</label>
      <input type="text" class="form-control txt_login_reg_font" value="<%=osoba.getAdresa()%>" name="tx_adresaRegistracija" id="tx_adresaRegistracija" placeholder="Ulica 123">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="tx_usernameRegistracija" class="login_txt_size">Korisničko ime</label>
      <input type="text" class="form-control txt_login_reg_font" value="<%=osoba.getUsername()%>" name="tx_usernameRegistracija" id="tx_usernameRegistracija" placeholder="Korisničko ime">
      <%if(session.getAttribute("korisnickoDuplikat") != null){
      out.println("<label style=\"color: red;\" >Korisničko ime je zauzeto.</label>"); 
      session.removeAttribute("korisnickoDuplikat");
      session.removeAttribute(RequestParameterNames.OSOBA_REGISTRACIJA_TEMP);
      }
      %>
    </div>
    <div class="form-group col-md-6">
      <label for="tx_passwordRegistracija" class="login_txt_size">Lozinka</label>
      <input type="password" class="form-control txt_login_reg_font" name="tx_passwordRegistracija" id="tx_passwordRegistracija" placeholder="Lozinka">
    </div>
  </div>
  <button type="submit" class="btn btn-primary" style="margin-top: 20px;">Registriraj se</button>
  <%if(session.getAttribute("praznoPolje") != null){
      out.println("<label style=\"margin-left:10px;margin-top:5px;color: red;\" >Niti jedno polje ne smije biti prazno.</label>"); 
      session.removeAttribute("praznoPolje");
      session.removeAttribute(RequestParameterNames.OSOBA_REGISTRACIJA_TEMP);
      }
      %>
</form>
        </div>

    </body>
    <div style="position: fixed; bottom:0; width: 100% ">
    <customFooter:footer />
 </div>
</html>