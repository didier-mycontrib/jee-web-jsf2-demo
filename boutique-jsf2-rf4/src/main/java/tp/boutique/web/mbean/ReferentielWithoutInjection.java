package tp.boutique.web.mbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tp.boutique.prod.itf.domain.service.GestionClients;
import tp.boutique.prod.itf.domain.service.GestionProduits;


public class ReferentielWithoutInjection {
		
	private GestionClients serviceGestionClients;
	private GestionProduits serviceGestionProduits;
	
	public ReferentielWithoutInjection(){
		//default constructor
		//init via SpringContext and without web.xml config :
		ApplicationContext springContext = 
				new ClassPathXmlApplicationContext(new String[] {"springContextOfModule.xml"});
        this.serviceGestionClients = springContext.getBean(GestionClients.class);
        this.serviceGestionProduits  = springContext.getBean(GestionProduits.class);
	}
	
	public GestionClients getServiceGestionClients() {
		return serviceGestionClients;
	}
	/*public void setServiceGestionClients(GestionClients serviceGestionClients) {
		this.serviceGestionClients = serviceGestionClients;
	}*/
	public GestionProduits getServiceGestionProduits() {
		return serviceGestionProduits;
	}
	/*public void setServiceGestionProduits(GestionProduits serviceGestionProduits) {
		this.serviceGestionProduits = serviceGestionProduits;
	}*/
	
	
	
	
	
}
