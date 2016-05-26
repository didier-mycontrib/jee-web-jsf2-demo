package tp.boutique.prod.impl.domain.service.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import tp.boutique.prod.itf.domain.entity.Adresse;
import tp.boutique.prod.itf.domain.entity.Client;
import tp.boutique.prod.itf.domain.service.GestionClients;
	

public class TestGestionClients extends BoutiqueAbstractServiceSpringTest{
	
	@Inject
	private GestionClients serviceGestionClients;
	
	
	@Test
	public void testGetClientByNum(){
		try {
			Client cli = serviceGestionClients.getClientByNum(1L);
			System.out.println("client 1 = " + cli.toString());
			Assert.assertTrue(cli.getNumero()==1L);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsertNewClient(){
		try {
			Client cli = new Client();
			cli.setNom("nomNouveauClient");
			cli.setPrenom("prenomNouveauClient");
			cli.setEmail("cli@ici.fr");
			cli.setPassword("pwd");
			cli.setTelephone("0102030405");
			Adresse adr = new Adresse(null,"rue xx" , "75000" , "Paris");
			cli.setAdresse(adr);
			Long pk= serviceGestionClients.insertNewClient(cli);
			System.out.println("pk of inserted new client = " + pk);
			Assert.assertTrue(pk != null);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testPasswordOfClient(){
		try {
		
			System.out.println("affectation  et verification du mot de passe new-pwd1 au client 1  :");
			serviceGestionClients.changePasswordOfClient(1L, "new-pwd1");
			Assert.assertTrue(serviceGestionClients.isGoodPasswordOfClient(1L, "new-pwd1"));
			System.out.println("affectation et verification du mot de passe pwd1 au client 1  :");
			serviceGestionClients.changePasswordOfClient(1L, "pwd1");
			Assert.assertTrue(serviceGestionClients.isGoodPasswordOfClient(1L, "pwd1"));			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	
	
}
