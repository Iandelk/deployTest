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
        <customJumbo:jumbo message="Sada možete naručiti vaše proizvode po želji i preko naše nove internet trgovine!" title="Dobrodošli na našu novu Web-stranicu!" />
        <customJumbo:jumbo message="U našem dućanu sada možete naći novi još kiseliji kupus!" title="Novost!" />
        <customJumbo:jumbo message="Otvorili smo trgovinu u Zadru! Adresa je Zadarska Ulica 12." title="Obavijest!" />

    </body>
    
    <customFooter:footer />
 
</html>

