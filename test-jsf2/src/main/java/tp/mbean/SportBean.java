
package tp.mbean;

import java.util.List;

import javax.faces.model.SelectItem;


public class SportBean {
	
	 private List listeSel =null;
	
	 private SelectItem[] listeDeSport = { new SelectItem("Foot") ,
    		new SelectItem("VTT") ,new SelectItem("Natation") ,
            new SelectItem("Ski") };

	/**
	 * @return Returns the listeDeSport.
	 */
	public SelectItem[] getListeDeSport() {
		return listeDeSport;
	}
	
	
	
	/**
	 * @return Returns the listeSel.
	 */
	public List getListeSel() {
		return listeSel;
	}
	/**
	 * @param listeSel The listeSel to set.
	 */
	public void setListeSel(List listeSel) {
		this.listeSel = listeSel;
	}
}
