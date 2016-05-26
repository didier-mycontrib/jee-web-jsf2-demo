
package tp.mbean;

import java.util.Collection;
import java.util.Vector;



public class EmpruntBean {
   private int nbAnnees;
   private double montant;
   private double taux;
   
   private boolean details;
   private Collection listeSommes; // Collection<data.Reste>
   
   private double mensualite;
   private String commentaire; // pour test "required='true'"
   
   
   public EmpruntBean() {
	nbAnnees=8;
	montant=60000;
	taux=0.05;
	mensualite=0;
	commentaire="required";
	details=false;
	listeSommes=null;
}

   
   public String calculer()
	{
		String res="ok";
		try{
			double	tauxMensuel = taux / 12;
			int	nbMensualites = nbAnnees *12;
			double capitalEmprunte = montant;
			mensualite = capitalEmprunte * tauxMensuel / (1 - Math.pow(1.0+tauxMensuel,-nbMensualites)) ;
			if(details)
   	 		{
   	 		Vector liste=new Vector();
   	 		double reste = capitalEmprunte;
   	 		for(int i=0;i<nbMensualites;i++)
   	 			{
   	 			reste = reste * (1+ tauxMensuel) - mensualite;
   	 			liste.add(new tp.data.Reste(i+1,reste));
   	 			}
   	 		this.setListeSommes(liste);
   	 		}


			
		}catch(Exception ex)
		{
			ex.printStackTrace(); res="ko";
		}
		
		return res;
	}
   
   
   
/**
 * @return Returns the details.
 */
public boolean isDetails() {
	return details;
}
/**
 * @param details The details to set.
 */
public void setDetails(boolean details) {
	this.details = details;
}
/**
 * @return Returns the listeSommes.
 */
public Collection getListeSommes() {
	return listeSommes;
}
/**
 * @param listeSommes The listeSommes to set.
 */
public void setListeSommes(Collection listeSommes) {
	this.listeSommes = listeSommes;
}
/**
 * @return Returns the mensualite.
 */
public double getMensualite() {
	return mensualite;
}

	
/**
 * @return Returns the montant.
 */
public double getMontant() {
	return montant;
}
/**
 * @param montant The montant to set.
 */
public void setMontant(double montant) {
	this.montant = montant;
}
/**
 * @return Returns the nbAnnees.
 */
public int getNbAnnees() {
	return nbAnnees;
}
/**
 * @param nbAnnees The nbAnnees to set.
 */
public void setNbAnnees(int nbAnnees) {
	this.nbAnnees = nbAnnees;
}
/**
 * @return Returns the taux.
 */
public double getTaux() {
	return taux;
}
/**
 * @param taux The taux to set.
 */
public void setTaux(double taux) {
	this.taux = taux;
}


/**
 * @return Returns the commentaire.
 */
public String getCommentaire() {
	return commentaire;
}
/**
 * @param commentaire The commentaire to set.
 */
public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}
}
