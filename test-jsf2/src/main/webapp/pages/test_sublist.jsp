<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head> 
   <title>test_sublist</title> 
   <LINK rel="stylesheet" href="../css/styles.css" type="text/css" />
</head>
<body>
<f:view>
<!--  
    ***** <br/>    ***** <br/>    ***** <br/>    ***** <br/>    ***** <br/>    ***** <br/>
        ***** <br/>    voir plus bas <br/>    ***** <br/>    ***** <br/>    ***** <br/>    ***** <br/>
            ***** <br/>    ***** <br/>    voir plus bas <br/>    ***** <br/>    ***** <br/>    ***** <br/>
                ***** <br/>    ***** <br/>    ***** <br/>    ***** <br/>    ***** <br/>
                    ***** <br/>    ***** <br/>    ***** <br/>    ***** <br/>    voir plus bas <br/>
                        ***** <br/>    ***** <br/>    ***** <br/>    ***** <br/>
-->                        
    <hr/>  
	<h:form> 
		
		<table border="1">
		<tr><th>Categorie(s)</th>
		    <th>Produit(s) <br/>(de la catégorie sélectionnée)</th>
		    <th>Details <br/>du produit sélectionné</th>
		</tr>
		<tr>
          <td> <h:selectOneListbox value="#{prodBean.categorie}"
                             onclick="submit()"
                             valueChangeListener="#{prodBean.onCategorieChange}" >
                                  <f:selectItems  value="#{prodBean.listeCategories}"/>
                         </h:selectOneListbox> </td>
          <td> <h:selectOneListbox value="#{prodBean.produit}"
                              onclick="submit()"
                             valueChangeListener="#{prodBean.onProductChange}" >
                             <f:selectItems  value="#{prodBean.listeProduits}"/>
                         </h:selectOneListbox> </td>
          <td><h:outputText value="#{prodBean.selectedProd.label}"/> <br/>
                        <h:outputText value="#{prodBean.selectedProd.prix}" /> </td>
        </tr>
       </table> 
	  <!-- <h:commandButton value="Refresh!" action="#{prodBean.refresh}"/> -->
	</h:form> 
</f:view>
</body>
</html>