<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head> 
   <title>Param_emprunt</title> 
   <LINK rel="stylesheet" href="../css/styles.css" type="text/css" />
</head>
<body>
<f:view> 
    <h:messages  showDetail="true"  styleClass="RedCssClass"/>
    <hr/>  
	<h:form> 
		Montant: <h:inputText label="montant" value="#{empruntBean.montant}" /><BR>
		Nb années: <h:inputText value="#{empruntBean.nbAnnees}"/><BR>
		Taux: <h:inputText  value="#{empruntBean.taux}"/><BR>
		<h:commandButton value="Retour arriere!" action="retour"/>
	   <h:commandButton value="Calcul Mensualite!" action="#{empruntBean.calculer}"/>
	</h:form> 
</f:view>
</body>
</html>