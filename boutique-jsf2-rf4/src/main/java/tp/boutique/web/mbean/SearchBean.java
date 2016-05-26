package tp.boutique.web.mbean;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tp.boutique.web.mbean.data.TextAndLink;

@ManagedBean
@RequestScoped
public class SearchBean {
	
	private String motClef;
	
	private Collection<TextAndLink> elementsTrouves;
	
	

	public String doRecherche(){
		String res=null;//"not_found";
		// coder ici la recherche selon mot clef
		try{
			// code par defaut (a retoucher):
			elementsTrouves=new ArrayList<TextAndLink>();
			elementsTrouves.add(new TextAndLink("recherche pas encore programmee",""));
			elementsTrouves.add(new TextAndLink("eventuelle recherche externe","http://www.google.fr/search?q="+this.motClef));
			//----
			res="resultatsRecherche";//"found";
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}
	
	public String getMotClef() {
		return motClef;
	}



	public void setMotClef(String motClef) {
		this.motClef = motClef;
	}



	public Collection<TextAndLink> getElementsTrouves() {
		return elementsTrouves;
	}



	public void setElementsTrouves(Collection<TextAndLink> elementsTrouves) {
		this.elementsTrouves = elementsTrouves;
	}




}
