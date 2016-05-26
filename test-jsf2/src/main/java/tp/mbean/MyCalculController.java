
package tp.mbean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class MyCalculController {
	
	
	
	public String calculer()
	{
		String res="ok";
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request =(HttpServletRequest)context.getRequest();
		String pNbAnnees = request.getParameter("formPE:nbAnnees");
		String pTaux = request.getParameter("formPE:taux");
		String pMontant = request.getParameter("formPE:montant");
		System.out.println("nbAnnees=" + pNbAnnees);
		System.out.println("taux=" + pTaux);
		System.out.println("montant=" + pMontant);
		try{
			double	tauxMensuel = Double.parseDouble(pTaux) / 12;
			int	nbMensualites = Integer.parseInt(pNbAnnees) *12;
			double capitalEmprunte = Double.parseDouble(pMontant);
			double mensualite = capitalEmprunte * tauxMensuel / (1 - Math.pow(1.0+tauxMensuel,-nbMensualites)) ;
			request.setAttribute("mensualite",new Double(mensualite));
		}catch(Exception ex)
		{
			ex.printStackTrace(); res="ko";
		}
		
		return res;
	}

}
