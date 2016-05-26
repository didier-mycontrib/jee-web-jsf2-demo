package tp.boutique.prod.itf.domain.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import tp.boutique.prod.itf.domain.entity.Client;

@WebService(targetNamespace="http://tp.boutique.prod/")
public interface GestionClients {
	
	public Client getClientByNum(@WebParam(name="numCli")long numCli)
			throws MyServiceException;
	
	public boolean isGoodPasswordOfClient(@WebParam(name="numClient")long numClient,
										@WebParam(name="password")String password)
												throws MyServiceException;
	
	public void changePasswordOfClient(@WebParam(name="numClient")long numClient,
									@WebParam(name="password")String password)
											throws MyServiceException;
	
	public Long insertNewClient(@WebParam(name="client")Client client)
			throws MyServiceException; //return pk 
	

}
