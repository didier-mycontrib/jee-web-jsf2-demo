package tp.boutique.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ValueChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.richfaces.component.UITree;
import org.richfaces.event.TreeSelectionChangeEvent;

import tp.boutique.prod.itf.domain.entity.Categorie;
import tp.boutique.prod.itf.domain.entity.Produit;
import tp.boutique.prod.itf.domain.service.GestionProduits;
import tp.boutique.prod.itf.domain.service.MyServiceException;
import tp.boutique.web.mbean.data.IdLabel;

@ManagedBean
@SessionScoped
public class CatProduits {
	
	private Long chooseMainCat=0L;//num categorie choisie
	private Long currCatId=0L;//num sous categorie choisie
	
	public Long getCurrCatId() {
		return currCatId;
	}


	public void setCurrCatId(Long currCatId) {
		this.currCatId = currCatId;
	}

	private List<Categorie> listMainCat ; //liste des categories principales
	
	private List<Produit> listProdOfCurrCat; //liste des produits de la categorie courante
	
	private Produit currProd; //produit courant (selectionne / a detailler)
	
	private UIParameter paramNumProdSel; //pour recuperer id prod selectionne (backing bean)

	private Integer quantite=1; //quantite (pour ajout dans caddy)
	
	private /* List<TreeNode>*/ TreeNode nodesOfCategories = null /* = new ArrayList<TreeNode>() */;

	public void mainCatChanged(ValueChangeEvent event){
		System.out.println("new (selected) main category:" + event.getNewValue() );
		//fixer par defaut selection "cat ou sous_cat" à cet id de (main)cat:
		this.currCatId=(Long) event.getNewValue();
		this.currProd=null;
	}

	
	private void buildNodesOfCategoriesFromChooseMainCat(){
		
		try {
			DefaultMutableTreeNode mainCatNode = null;
			Categorie mainCat =null;
			if(chooseMainCat>0)
			     mainCat = this.getServiceGestionProduits().getCategorieByNum(chooseMainCat);	
			if(mainCat!=null){
				mainCatNode = new DefaultMutableTreeNode(new IdLabel(mainCat.getNumero(),mainCat.getLabel()));
				
				List<Categorie> listSubCat = this.getServiceGestionProduits().getSubCategories(chooseMainCat);
				for(Categorie cat :  listSubCat){
					DefaultMutableTreeNode scNode= new  DefaultMutableTreeNode(new IdLabel(cat.getNumero(),cat.getLabel()));
					mainCatNode.add(scNode);			
				}
			}
			nodesOfCategories=mainCatNode;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Sous methode utilitaire (pour selection simple):
	private TreeNode getSelectedTreeNodeFromselectionChangeEvent(TreeSelectionChangeEvent selectionChangeEvent){
		 List<Object> selection = new ArrayList<Object>(selectionChangeEvent.getNewSelection());
	     Object currentSelectionKey = selection.get(0);
	    UITree tree = (UITree) selectionChangeEvent.getSource();
        Object storedKey = tree.getRowKey();
        tree.setRowKey(currentSelectionKey);
        TreeNode currentSelectionNode = (TreeNode) tree.getRowData();
        tree.setRowKey(storedKey);
        return currentSelectionNode;
	}
	
	public void subCatChanged(TreeSelectionChangeEvent selectionChangeEvent) {
		TreeNode currentSelectionNode = getSelectedTreeNodeFromselectionChangeEvent(selectionChangeEvent);            
        IdLabel currIdLabel = (IdLabel) ( (DefaultMutableTreeNode) currentSelectionNode).getUserObject() ;
        this.currCatId = currIdLabel.getId();
        System.out.println("new (selected) current category: " + currCatId + " ,label=" + currIdLabel.getLabel() );
        this.currProd=null;
    }
	
	private void  buildListProdOfCurrCat(){
		try {
			if(currCatId>0)
			    listProdOfCurrCat=this.getServiceGestionProduits().getProductsOfCategory( this.currCatId);
		} catch (MyServiceException e) {
			e.printStackTrace();
		}
	}
	
	public String detaillerProduit(){
		Long numProduitSel=(Long) paramNumProdSel.getValue();
		try {
			this.currProd = this.getServiceGestionProduits().getProduitByNum(numProduitSel);
		} catch (MyServiceException e) {
			this.currProd=null;
			e.printStackTrace();
		}
		return null; //rester sur même page
	}
	
	public String addInCaddy(){
		System.out.println("ajout de " + currProd + "dans le caddy");
		this.panierBean.getMapProdQte().put(this.currProd, this.quantite);
		return null; //rester sur même page
	}
	
	
	public Integer getQuantite() {
		return quantite;
	}


	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@ManagedProperty(value="#{referentiel}")
	private Referentiel referentiel;

	public Referentiel getReferentiel() {
		return referentiel;
	}

	public void setReferentiel(Referentiel referentiel) {
		this.referentiel = referentiel;
	}
	
	@ManagedProperty(value="#{panierBean}")
	private PanierBean panierBean;
	

	public PanierBean getPanierBean() {
		return panierBean;
	}

	public void setPanierBean(PanierBean panierBean) {
		this.panierBean = panierBean;
	}


	public GestionProduits getServiceGestionProduits(){
		return referentiel.getServiceGestionProduits();
	}

	public Long getChooseMainCat() {
		return chooseMainCat;
	}

	public void setChooseMainCat(Long chooseMainCat) {
		this.chooseMainCat = chooseMainCat;
	}

	public List<Categorie> getListMainCat() {
		if(listMainCat==null){
			try {
				listMainCat=this.getServiceGestionProduits().getMainCategories();
			} catch (MyServiceException e) {
				e.printStackTrace();
			}
		}
		return listMainCat;
	}

	public void setListMainCat(List<Categorie> listMainCat) {
		this.listMainCat = listMainCat;
	}

	public /*List<TreeNode>*/ TreeNode getNodesOfCategories() {
		buildNodesOfCategoriesFromChooseMainCat();
		return nodesOfCategories;
	}
	
	public void setNodesOfCategories(/*List<TreeNode>*/ TreeNode nodesOfCategories) {
		this.nodesOfCategories = nodesOfCategories;
	}

	public List<Produit> getListProdOfCurrCat() {
		//System.out.println("getListProdOfCurrCat was called");
		buildListProdOfCurrCat();
		return listProdOfCurrCat;
	}

	public void setListProdOfCurrCat(List<Produit> listProdOfCurrCat) {
		this.listProdOfCurrCat = listProdOfCurrCat;
	}


	public Produit getCurrProd() {
		return currProd;
	}


	public void setCurrProd(Produit currProd) {
		this.currProd = currProd;
	}


	public UIParameter getParamNumProdSel() {
		return paramNumProdSel;
	}


	public void setParamNumProdSel(UIParameter paramNumProdSel) {
		this.paramNumProdSel = paramNumProdSel;
	}

	
	
	

}
