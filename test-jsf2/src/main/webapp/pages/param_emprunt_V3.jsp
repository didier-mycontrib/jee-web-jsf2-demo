<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head> 
   <title>Param_emprunt</title> 
   <LINK rel="stylesheet" href="../css/styles.css" type="text/css" />
</head>
<body>
<f:view> 
    <h:messages  showDetail="true" globalOnly="true" styleClass="RedCssClass"/>
    <hr/>  
	<h:form id="formEmprunt"> 
		Montant: <h:inputText  id="montant" label="montant" value="#{empruntBean.montant}" /> 
		         <h:message for="montant" styleClass="RedCssClass"/> <br/>
		Nb années: <h:inputText id="nbAnnees" value="#{empruntBean.nbAnnees}"/>
                  <h:message for="nbAnnees" styleClass="RedCssClass"/> <br/>
		Taux: <h:inputText  id="taux" value="#{empruntBean.taux}"/>
               <h:message for="taux" styleClass="RedCssClass"/> <br/>
        Commentaire (required): <h:inputText  id="commentaire" required='true' 
                                              value="#{empruntBean.commentaire}"/>
               <h:message for="commentaire" styleClass="RedCssClass"/> <br/>
		<h:commandButton value="Retour arriere!" action="retour"/>
	   <h:commandButton value="Calcul Mensualite!" action="#{empruntBean.calculer}"/>
	</h:form> 
</f:view>
</body>
</html>