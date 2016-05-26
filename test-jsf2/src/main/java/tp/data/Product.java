package tp.data;

public class Product {
	
	private String label;
	private double prix;
	

	public Product() {
		label="?";
		prix=0;
	}
	
	
	
	public Product(String label, double prix) {
		this.label = label;
		this.prix = prix;
	}


	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	

}
