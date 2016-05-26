package tp.boutique.web.mbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tp.boutique.prod.itf.domain.entity.Produit;

@ManagedBean
@SessionScoped
public class PanierBean {
	
	private Map<Produit,Integer>  mapProdQte = new HashMap<Produit,Integer>();
	
	
	public List<Produit> getMapProdQteKeys() {
		   List<Produit> keys = new ArrayList<Produit>();
		   keys.addAll(mapProdQte.keySet());
		   return keys;
		}
	
	public int getSizeOfCaddy(){
		if(mapProdQte==null) return 0;
		else return mapProdQte.size();
	}
		
	public Map<Produit, Integer> getMapProdQte() {
		return mapProdQte;
	}

	public void setMapProdQte(Map<Produit, Integer> mapProdQte) {
		this.mapProdQte = mapProdQte;
	}



	public String display(){
		String res=null;
		
		try{
			
			res="displayCaddy";
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}

}
