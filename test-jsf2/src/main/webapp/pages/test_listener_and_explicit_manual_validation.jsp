<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head> <title>test action listener</title> </head>
<body>
<f:view> 
    Eventuelle(s) Erreur(s): ${colorBean.errorsAsString}
    <hr/>
	<h:form> 
	    <h:commandButton value="Activer / désactiver choix des couleurs"
	                    actionListener="#{colorBean.toggleColorSupport}"
	                    immediate="true"/><br/>
	    <h:selectBooleanCheckbox value="#{colorBean.colorDetails}" immediate="true" onclick="submit()"
	                             valueChangeListener="#{colorBean.onIsDetailsChange}" /> choix des couleurs. <br/>
	    *** Couleur fond : <h:inputText value="#{colorBean.background}" 
	                                disabled="#{!colorBean.colorDetails}" /><br/>	
	    *** Couleur texte : <h:inputText value="#{colorBean.foreground}"
	                                disabled="#{!colorBean.colorDetails}" /><br/>
	    Age (integer) :  <h:inputText value="#{colorBean.age}"  /> <br/> 
	    RequiredField (String) :  <h:inputText value="#{colorBean.requiredField}"  /> <br/>                        
	    
	   <h:commandButton value="Submit" action="#{colorBean.suite}"/>
	</h:form> 
</f:view>
</body>
</html>