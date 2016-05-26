package tp.boutique.prod.itf.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Categorie")
public class Categorie {
	
	@Id
	@Column(name="numero")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numero;
	private String label;
	
	@ManyToOne
	@JoinColumn(name="ref_parent",nullable=true)
	private Categorie parentCategorie;
	
	@OneToMany(mappedBy="categorie")
	private List<Produit> produits;
	
	@OneToMany(mappedBy="parentCategorie")
	private List<Categorie> sousCategories;
	
	
		
	public void addProduit(Produit p){
		if(produits==null)
			produits=new ArrayList<Produit>();
		p.setCategorie(this);
		produits.add(p);
	}

	public void addSousCategorie(Categorie sousCat){
		if(sousCategories==null)
			sousCategories=new ArrayList<Categorie>();
		sousCat.setParentCategorie(this);
		sousCategories.add(sousCat);
	}

	
		
	public Categorie() {
		super();
	}
	
		
	public Categorie(Long numero, String label) {
		super();
		this.numero = numero;
		this.label = label;		
	}


	@Override
	public String toString() {
		return "Categorie [numero=" + numero + ", label=" + label + "]";
	}
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@XmlTransient  //IMPORTANT EN MODE DRY pour ne pas remonter trop de choses via les WEB-SERVICES
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@XmlTransient  //IMPORTANT EN MODE DRY pour ne pas remonter trop de choses via les WEB-SERVICES
	public Categorie getParentCategorie() {
		return parentCategorie;
	}

	public void setParentCategorie(Categorie parentCategorie) {
		this.parentCategorie = parentCategorie;
	}

	@XmlTransient  //IMPORTANT EN MODE DRY pour ne pas remonter trop de choses via les WEB-SERVICES
	public List<Categorie> getSousCategories() {
		return sousCategories;
	}

	public void setSousCategories(List<Categorie> sousCategories) {
		this.sousCategories = sousCategories;
	}
	
	
	
    
}
