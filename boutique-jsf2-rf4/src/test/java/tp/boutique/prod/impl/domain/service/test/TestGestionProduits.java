package tp.boutique.prod.impl.domain.service.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import tp.boutique.prod.itf.domain.entity.Categorie;
import tp.boutique.prod.itf.domain.entity.Produit;
import tp.boutique.prod.itf.domain.service.GestionProduits;

public class TestGestionProduits extends BoutiqueAbstractServiceSpringTest{
	
	@Inject
	private GestionProduits serviceGestionProduits;
	
	
	
	@Test
	public void testGetMainCategories(){
		try {
			List<Categorie> listCat = serviceGestionProduits.getMainCategories();			
			Assert.assertTrue(listCat.size()>=1);
			for(Categorie cat : listCat){
				System.out.println("categorie principale = " + cat.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testSubCategories(){
		try {
			List<Categorie> listCat = serviceGestionProduits.getSubCategories(1L);			
			Assert.assertTrue(listCat.size()>=1);
			for(Categorie cat : listCat){
				System.out.println("sous categorie (de cat 1) = " + cat.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetCategorieByNum(){
		try {
			Categorie cat = serviceGestionProduits.getCategorieByNum(1L);
			System.out.println("categorie 1 = " + cat.toString());
			Assert.assertTrue(cat.getNumero()==1L);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testgetProduitsOfCategorie(){
		try {
			List<Produit> listProd = serviceGestionProduits.getProductsOfCategory(3L);			
			Assert.assertTrue(listProd.size()>=1);
			for(Produit p : listProd){
				System.out.println("produit (de cat 3) = " + p.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetProduitByNum(){
		try {
			Produit p = serviceGestionProduits.getProduitByNum(1L);
			System.out.println("produit 1 = " + p.toString());
			Assert.assertTrue(p.getNumero()==1L);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	

}
