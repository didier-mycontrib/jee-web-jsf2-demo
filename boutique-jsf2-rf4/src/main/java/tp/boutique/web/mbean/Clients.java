package tp.boutique.web.mbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tp.boutique.prod.itf.domain.entity.Client;
import tp.boutique.prod.itf.domain.service.GestionClients;

@ManagedBean
@SessionScoped
public class Clients {
	
	private Long numClient;
	private String password;
	
	private boolean identifie;
	private Client client;
	private String message;
	
	public String identifierClient(){
		String suite=null;message=null;
		System.out.println("identifierClient / numClient=" + numClient +  " , password=" + password);
		try {
			identifie = getServiceGestionClients().isGoodPasswordOfClient(numClient, password);
			if(identifie){
				client=getServiceGestionClients().getClientByNum(numClient);
			suite="compteClient";//pour aller vers compteClient.jsp (ou .xhtml) (depuis jsf2)				
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null /* id = null pour message global */,
				       new FacesMessage("echec identification" , "numClient ou password incorrect"));

			}
		} catch (Exception e) {
			message="echec identification - " + e.getMessage();
			System.err.println(message);
		}
		System.out.println("suite="+suite);
		return suite;
	}
	
	public String deconnexion(){
		message=null;
		identifie = false;
		client = null;		
		numClient=null;
		password=null;
	    return "welcome"; //.jsp		
	}
	
	
	@ManagedProperty(value="#{referentiel}")
	private Referentiel referentiel;

	public Referentiel getReferentiel() {
		return referentiel;
	}

	public void setReferentiel(Referentiel referentiel) {
		this.referentiel = referentiel;
	}
	
	/*
	private ReferentielWithoutInjection referentiel;

	public ReferentielWithoutInjection getReferentiel() {
		return referentiel;
	}

	public void setReferentiel(ReferentielWithoutInjection referentiel) {
		this.referentiel = referentiel;
	}*/
	
	private GestionClients getServiceGestionClients(){
		return referentiel.getServiceGestionClients();
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIdentifie() {
		return identifie;
	}

	public void setIdentifie(boolean identifie) {
		this.identifie = identifie;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	

}
