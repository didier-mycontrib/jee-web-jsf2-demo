<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>


<html>
<head> <title>Mensualites emprunt (resultat calcul)</title> </head>
<body>
<f:view>
<h3> Mensualites </h3>
   <f:loadBundle basename="tp.props.myapp.myJsfProp" var="myJsfProperties"/>
   <h:outputText value="#{myJsfProperties.hello}"/>   
   <hr/>
   Pour rembourser un capital de <b><h:outputText value="#{empruntBean.montant}"/></b><br/>
   sur <b><h:outputText value="#{empruntBean.nbAnnees}"/></b>  ans <br/>
   avec un taux d'interêt de  <b><h:outputText value="#{empruntBean.taux}"/></b><br/>
   il faut des mensualités de <b><h:outputText value="#{empruntBean.mensualite}"/></b> 
   <hr/>
   <h:outputFormat value="#{myJsfProperties.display_mens}">
           <f:param value="#{empruntBean.mensualite}"/>
           <f:param value="Euros"/>
   </h:outputFormat>
   <hr/>
   Affichage via JSP 2 (et non plus h:outputText) : <br/>
   mensualite = <b> ${empruntBean.mensualite} </b>
</f:view>
</body>
</html>