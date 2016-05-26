package tp.boutique.prod.itf.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {
	
	@Id
	@Column(name="numClient")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numero;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String password;

	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ref_adressePrincipale")
	private Adresse adresse;
	

	
	
	
	public Long getNumero() {
		return numero;
	}
	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + ", prenom="
				+ prenom + ", telephone=" + telephone + ", email=" + email
				+ "]";
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
