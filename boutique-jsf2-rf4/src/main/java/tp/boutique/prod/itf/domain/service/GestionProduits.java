package tp.boutique.prod.itf.domain.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import tp.boutique.prod.itf.domain.entity.Categorie;
import tp.boutique.prod.itf.domain.entity.Produit;

@WebService(targetNamespace="http://tp.boutique.prod/")
public interface GestionProduits {
	
	public Categorie getCategorieByNum(@WebParam(name="numCat")long numCat) throws MyServiceException;
	
	//retourne les categories principales (de premier niveau / sans parent)
	public List<Categorie> getMainCategories() throws MyServiceException;
	
	public List<Categorie> getSubCategories(@WebParam(name="numCat")long numCat) throws MyServiceException;
	
	public Produit getProduitByNum(@WebParam(name="numProd")long numProd) throws MyServiceException;
	
	public List<Produit> getProductsOfCategory(@WebParam(name="numCat")long numCat) 
            throws MyServiceException;
	
}
