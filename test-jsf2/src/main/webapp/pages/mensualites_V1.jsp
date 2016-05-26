<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>


<html>
<head> <title>Mensualites emprunt (resultat calcul)</title> </head>
<body>
<h3> Mensualites </h3>
   Pour rembourser un capital de <b><%=request.getParameter("formPE:montant")%></b><br/>
   sur <b><%=request.getParameter("formPE:nbAnnees")%></b>  ans <br/>
   avec un taux d'interêt de  <b><%=request.getParameter("formPE:taux")%></b><br/>
   il faut des mensualités de <b><%=request.getAttribute("mensualite")%></b> 

</body>
</html>