<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head> <title>Param_emprunt</title> </head>
<body>
<f:view> 
	<h:form  id="formPE"> 
		Montant: <h:inputText id="montant" value="60000" /><BR>
		Nb années: <h:inputText id="nbAnnees" value="8"/><BR>
		Taux: <h:inputText id="taux" value="0.05"/><BR>
		<h:commandButton value="Retour arriere!" action="retour"/>
	   <h:commandButton value="Calcul Mensualite!" action="#{myCalculController.calculer}"/>
	</h:form> 
</f:view>
</body>
</html>