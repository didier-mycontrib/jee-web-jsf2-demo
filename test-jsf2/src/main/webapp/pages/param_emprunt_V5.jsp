<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head> 
   <title>Param_emprunt</title> 
   <LINK rel="stylesheet" href="../css/styles.css" type="text/css" />
</head>
<body>
<f:view> 
    
    <hr/>  
	<h:form> 
		Montant (entre 100 et 999999): <h:inputText  id="montant" value="#{empruntBean.montant}" >
                    <f:validateDoubleRange minimum="100" maximum="999999"/>
                  </h:inputText>
		         <h:message for="montant" styleClass="RedCssClass"/> <br/>
		Nb années (entre 1 et 30): <h:inputText id="nbAnnees" value="#{empruntBean.nbAnnees}">
 					<f:validateLongRange minimum="1" maximum="30"/>
                  </h:inputText>
                  <h:message for="nbAnnees" styleClass="RedCssClass"/> <br/>
		Taux (entre 0.01 et 0.25) : <h:inputText  id="taux" value="#{empruntBean.taux}">
                     <f:validateDoubleRange minimum="0.01" maximum="0.25"/>
                  </h:inputText>
               <h:message for="taux" styleClass="RedCssClass"/> <br/>
        Commentaire (required , length >= 2): <h:inputText  id="commentaire" required='true' 
                                              value="#{empruntBean.commentaire}">
                        <f:validateLength  minimum="2"/>
                      </h:inputText> <br/><br/>
        <h:selectBooleanCheckbox value="#{empruntBean.details}" /> details <br/>
        
        Couleur du texte: <h:selectOneMenu value="#{colorBean.foreground}">
                             <f:selectItems  value="#{colorBean.listeDeCouleur}"/>
                         </h:selectOneMenu> <br/>
        Couleur du fond: <h:selectOneMenu value="#{colorBean.background}">
                             <f:selectItem   itemValue="#FFFFFF" itemLabel="blanc"/>
 							 <f:selectItem   itemValue="#AAAAAA" itemLabel="gris"/>
                         </h:selectOneMenu> <br/>
         Sports pratiqués:
                        <h:selectManyCheckbox value="#{sportBean.listeSel}" >
                              <f:selectItems  value="#{sportBean.listeDeSport}"/>
                         </h:selectManyCheckbox> <br/>
        
               <h:message for="commentaire" styleClass="RedCssClass"/> <br/>
		<h:commandButton value="Retour arriere!" action="retour"/>
	   <h:commandButton value="Calcul Mensualite!" action="#{empruntBean.calculer}"/>
	</h:form> 
</f:view>
</body>
</html>