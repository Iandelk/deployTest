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
        
        <div class="container bootstrap snippet" style="text-align: center;background-color: skyblue; margin-top: 30px; margin-bottom: 30px">
            <h1 style="padding-top:4rem;">Narudžba zaprimljena!</h1>
            <h2 style="padding-top:7rem;">Hvala vam što ste kupovali u našoj Web trgovini <Strong>Grah i Zelje - Veselje!</Strong></h2>
            
                 <h2 style="padding-top:7rem;padding-bottom:5rem;">Vaša pošiljka će biti isporučena u najkraćem roku.</h2>
            
        </div>

    </body>
    
    <customFooter:footer />
 
</html>