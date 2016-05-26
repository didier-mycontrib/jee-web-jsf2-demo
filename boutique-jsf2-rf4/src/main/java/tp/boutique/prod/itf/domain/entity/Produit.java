package tp.boutique.prod.itf.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name="Produit")
public class Produit {
	
	@Id
	@Column(name="numProd")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numero;
	private String label;
	private String caracteristiques;
	private Double prix; 
	
	
	@ManyToOne
	@JoinColumn(name="ref_categorie")
	@XmlTransient  //IMPORTANT EN MODE DRY pour ne pas remonter trop de choses via les WEB-SERVICES
	private Categorie categorie;
		

	public Produit(String label, Double prix) {
		super();
		this.label = label;
		this.prix = prix;		
	}

	@Override
	public String toString() {
		return "Produit [numero=" + numero + ", label=" + label
				+ ", caracteristiques=" + caracteristiques + ", prix=" + prix +  "]";
	}

	public Produit() {
		super();
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

		
	public String getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
		
	
	
}
