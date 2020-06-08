<%@tag description="header" pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="css/mycss.css">
 <script
  src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/dbed3cad62.js"></script>

    <a name="top"></a>
   
    <div class="text-center">
   <img src="Slike/GrahiZeljeLogoCropped.png" class="img-fluid float-left" width="200" style="margin:10px 10px" height="200">
   <img src="Slike/moto.png" class="img-fluid"  style="margin:10px 0px" >
</div>
    
<nav class="navbar navbar-expand-md navbar-light navbar-custom" >
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav mr-auto">
      <a class="nav-item px-3 nav-link" href="home.jsp">Početna <span class="sr-only">(current)</span></a>
      <a class="nav-item px-3 nav-link" href="shopServlet">Dućan</a>
      <a class="nav-item px-3 nav-link" href="#">O Nama</a>
     
      
    </div>
      <div class="navbar-nav ml-auto">
          <%
             
   if(session.getAttribute("prijavljeniKorisnik") == null){
     out.println("<a class=\"nav-item px-2 nav-link\" style=\"font-size: 20px\" href=\"prijava.jsp\">Prijava</a>");   
   }else{
       out.print("<form action=\"odjavaServlet\" method=\"post\">");
       out.println("<button type=\"submit\" style=\"font-size: 20px\" class=\"nav-item px-2 btn-link\" style=\"font-size: 20px\" href=\"home.jsp\">Odjava</a>");
       out.print("</form>");
   }

 %>
 
     
 <%! int brojStavkiUKosarici = 0; %>

     <% 
         if(session.getAttribute("brojStavkiUKosarici") != null){
     brojStavkiUKosarici = (int)session.getAttribute("brojStavkiUKosarici"); 
         }
      
     
     %>
      
     <form class="form-inline mx-1 px-3" action="kosaricaServlet" method="post">
            <button class="btn btn-outline-success my-2 my-sm-0 ml-auto" data-trigger="manual" data-toggle="tooltip" data-placement="bottom" title="Proizvoda u košarici: <%=brojStavkiUKosarici%>" type="submit">Košarica</button>
  </form>
      </div>
  </div>
</nav>
