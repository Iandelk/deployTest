<%@page import="hr.ivor.model.RequestParameterNames"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="customHeader" uri="WEB-INF/tlds/header.tld" %>
<%@taglib prefix="customFooter" uri="WEB-INF/tlds/footer.tld" %>
<%@taglib prefix="customJumbo" uri="WEB-INF/tlds/jumbo.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <customHeader:header />

    </head>
    <body style="background-color: lightblue;">

        <div class="container bootstrap snippet " style="background-color: skyblue; margin-top: 50px; margin-bottom: 50px; font-family: Jokerman;">
            <div style="text-align: center">
                <h1 style="padding-top: 30px;">Prijava</h1>
            </div>
            <form class="login_f" action="prijavaServlet" method="post">
                <div class="form-group ">
                    <label class="login_txt_size" for="tx_username">Username</label>
                    <input type="text" class="form-control txt_login_reg_font" id="tx_username" name="usernameLogin"  placeholder="Enter username">   
                </div>
                <div class="form-group">
                    <label class="login_txt_size" for="tx_password">Password</label>
                    <input type="password" class="form-control txt_login_reg_font" id="tx_password" name="passwordLogin" placeholder="Enter Password" >
                     <%if(session.getAttribute(RequestParameterNames.NESUPJESNA_PRIJAVA) != null){
                 out.println("<label style=\"color: red;\" >Pogrešno korisničko ime i/ili lozinka</label>"); 
                session.removeAttribute(RequestParameterNames.NESUPJESNA_PRIJAVA);
      }
      %>
                </div>
                
                <button type="submit" class="btn btn-primary" style="margin-top: 20px;">Prijavi se</button>

                <a href="registracija.jsp" class="btn btn-primary" style="margin-top: 20px; margin-left: 10px;">Registracija</a>

            </form>
        </div>

    </body>

    <div style="position: fixed; bottom:0; width: 100% ">
        <customFooter:footer />
    </div>
</html>