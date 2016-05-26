
package tp.mbean;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import tp.data.Product;



public class ProdBean {
	
   private String text; // for trivial ajax4jsf test	
	
   private String  categorie;
   private String  produit;
   private Product selectedProd;
   
   private SelectItem[] listeCategories = { new SelectItem("book","livre") ,
   		new SelectItem("CD","CD") ,new SelectItem("info","informatique")  };
   
   private SelectItem[] listeProduitsOfCategorieBook = { new SelectItem("livre1","livre1") ,
	   		new SelectItem("livre2","livre2") ,new SelectItem("livre3","livre3")  };
   
   private SelectItem[] listeProduitsOfCategorieCD = { new SelectItem("CD1","CD1") ,
	   		new SelectItem("CD2","CD2") ,new SelectItem("CD3","CD3")  };
	
   
   private SelectItem[] listeProduitsOfCategorieInfo = { new SelectItem("souris","souris") ,
	   		new SelectItem("PC","PC") ,new SelectItem("clef_usb","clef_usb")  };
	
   private SelectItem[] listeProduitsOfEmptyCategorie = {};
	      
   
   
   public ProdBean() {
	categorie="book";
	produit="livre1";
	selectedProd=new Product("???",0.0);
	
}

   
   public String refresh()
	{
		String res="ok";
		try{
						
		}catch(Exception ex)
		{
			ex.printStackTrace(); res="ko";
		}
		
		return res;
	}
   
   public void onCategorieChange(ValueChangeEvent event)
   {
   	String selectedCategorie = ( (String) event.getNewValue()).toString();
   	System.out.println("selectedCategorie:"+selectedCategorie);
   	
   }
   
   public void onProductChange(ValueChangeEvent event)
   {
	 if(event!=null && event.getNewValue()!=null)
	 {
   	  String selectedProduct = ( (String) event.getNewValue()).toString();
   	  System.out.println("selectedProduct:"+selectedProduct);
   	  double p = Math.random() * 100;
   	  this.selectedProd=new Product(selectedProduct,p);
	 }
	 else this.selectedProd=new Product("???",0.0);
   }
   
   public void changeSelectedProd()
   {
	  String selectedProduct = this.produit;
   	  System.out.println("selectedProduct:"+selectedProduct);
   	  double p = Math.random() * 100;
   	  this.selectedProd=new Product(selectedProduct,p);
   }


public String getCategorie() {
	return categorie;
}


public void setCategorie(String categorie) {
	this.categorie = categorie;
}


public SelectItem[] getListeCategories() {
	return listeCategories;
}



public SelectItem[] getListeProduits() {
	if(this.categorie.equals("book"))
	   return this.listeProduitsOfCategorieBook;
	  else if(this.categorie.equals("CD"))
		   return this.listeProduitsOfCategorieCD;
	   else if(this.categorie.equals("info"))
		   return this.listeProduitsOfCategorieInfo;
	     else return this.listeProduitsOfEmptyCategorie;
}



public String getProduit() {
	return produit;
}


public void setProduit(String produit) {
	this.produit = produit;
}


public Product getSelectedProd() {
	return selectedProd;
}


public void setSelectedProd(Product selectedProd) {
	this.selectedProd = selectedProd;
}


public String getText() {
	return text;
}


public void setText(String text) {
	this.text = text;
}
   

   
   
  }
