<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>


<html>
<head> <title>Mensualites emprunt (resultat calcul)</title> 
  <LINK rel="stylesheet" href="../css/styles.css" type="text/css" />
</head>
<body  bgColor='${colorBean.background}' >
<f:view>
<h3> <font color='<h:outputText value="#{colorBean.foreground}"/>'> Mensualites </font></h3>
   <f:loadBundle basename="tp.props.myapp.myJsfProp" var="myJsfProperties"/>
   <h:outputText value="#{myJsfProperties.hello}"/>   
   <hr/>
   Pour rembourser un capital de <b><h:outputText value="#{empruntBean.montant}"/></b><br/>
   sur <b><h:outputText value="#{empruntBean.nbAnnees}"/></b>  ans <br/>
   avec un taux d'interêt de  <b><h:outputText value="#{empruntBean.taux}"/></b><br/>
   il faut des mensualités de <b><h:outputText value="#{empruntBean.mensualite}"/></b> 
   <hr/>
   <c:if test="${requestScope.empruntBean.details != null}"> 
      <h:dataTable value="#{empruntBean.listeSommes}" var="rowVar"  border="1"
                    headerClass="HEADING" rowClasses="ROW1,ROW2" >
		<h:column>
            <f:facet name="header">
				<f:verbatim>numero</f:verbatim>
			</f:facet>
   			<f:verbatim> n° </f:verbatim> <h:outputText value="#{rowVar.num_mois}"/>
		</h:column>	
		<h:column>
            <f:facet name="header">
				<f:verbatim>reste à rembourser</f:verbatim>
			</f:facet>
   			<h:outputText value="#{rowVar.somme}">
                 <f:convertNumber maxFractionDigits="2"/>
             </h:outputText> 
		</h:column>	
      </h:dataTable> 
   </c:if>

   <hr/>

   <u>Sports pratiqués (sélectionnés)</u>:<br/>
   
    <h:dataTable value="#{sportBean.listeSel}" var="rowVar"  border="1">
		<h:column>
          <h:outputText value="#{rowVar}"/>
		</h:column>	
      </h:dataTable> 
</f:view>
</body>
</html>