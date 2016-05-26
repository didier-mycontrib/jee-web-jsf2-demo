package tp.boutique.web.mbean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import tp.boutique.prod.itf.domain.service.GestionClients;
import tp.boutique.prod.itf.domain.service.GestionProduits;

@ManagedBean
@ApplicationScoped
public class Referentiel {
	
	@ManagedProperty("#{gestionClientsImpl}")
	private GestionClients serviceGestionClients;
	
	@ManagedProperty("#{gestionProduitsImpl}")
	private GestionProduits serviceGestionProduits;
	
	
	public GestionClients getServiceGestionClients() {
		return serviceGestionClients;
	}
	public void setServiceGestionClients(GestionClients serviceGestionClients) {
		this.serviceGestionClients = serviceGestionClients;
	}
	public GestionProduits getServiceGestionProduits() {
		return serviceGestionProduits;
	}
	public void setServiceGestionProduits(GestionProduits serviceGestionProduits) {
		this.serviceGestionProduits = serviceGestionProduits;
	}
	
	
	
	
	
}
