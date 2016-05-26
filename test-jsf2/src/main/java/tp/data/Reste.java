
package tp.data;


public class Reste {
    private int num_mois;
    private double somme;
    
    public Reste(int num_mois,double somme )
    {
    	this.num_mois=num_mois;
    	this.somme=somme;
    }
    
    public Reste() { this(0,0); }
	/**
	 * @return Returns the num_mois.
	 */
	public int getNum_mois() {
		return num_mois;
	}
	/**
	 * @param num_mois The num_mois to set.
	 */
	public void setNum_mois(int num_mois) {
		this.num_mois = num_mois;
	}
	/**
	 * @return Returns the somme.
	 */
	public double getSomme() {
		return somme;
	}
	/**
	 * @param somme The somme to set.
	 */
	public void setSomme(double somme) {
		this.somme = somme;
	}
}
