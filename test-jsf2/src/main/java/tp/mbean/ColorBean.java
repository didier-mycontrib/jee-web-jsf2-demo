
package tp.mbean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


public class ColorBean {
    private String background;
    private String foreground;
    private boolean colorDetails;
    
    private SelectItem[] listeDeCouleur = { new SelectItem("#FF0000","rouge") ,
    		new SelectItem("#00FF00","vert") ,new SelectItem("#0000FF","bleu") ,
            new SelectItem("#000000","noir") };
    		
    		
    private String age;
    private int ageValue;
    
    private String requiredField;
    
    private ArrayList errMsgList;
    
    
    public ColorBean()
    {
    	background="white";
    	foreground="black";
    	colorDetails=true;
    	requiredField="?";
    	age="0";
    	ageValue=0;
    	errMsgList=new ArrayList();
    }
    
    public void toggleColorSupport(ActionEvent event)
    {
    	colorDetails = !colorDetails;
    	System.out.println("New state (after toggle / action Listener):" + colorDetails);
    }
    
    public void onIsDetailsChange(ValueChangeEvent event)
    {
    	colorDetails = ( (Boolean) event.getNewValue()).booleanValue();
    	System.out.println("New state (after Value Change Listener on checkbox):" + colorDetails);
    }
    
    
    
    
	/**
	 * @return Returns the listeDeCouleur.
	 */
	public SelectItem[] getListeDeCouleur() {
		return listeDeCouleur;
	}
	
	/**
	 * @return Returns the age.
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age The age to set.
	 */
	public void setAge(String age) {
		this.age = age;
		try{
			ageValue=Integer.parseInt(age);
		}
		catch(NumberFormatException nfe) { ageValue=-1;}
	}

	public Collection getErrMsgList() {
		errMsgList.clear();
		if(ageValue<0) errMsgList.add("L'age doit �tre un entier positif");
		if(requiredField==null || requiredField.length()==0) 
			        errMsgList.add("Le champ requiredField doit �tre renseign�");
		return errMsgList;
	}
	
	public String getErrorsAsString()
	{
		StringBuffer errMsg=new StringBuffer();
		getErrMsgList();
		if(errMsgList.size()>0)
		{
			errMsg.append("<font color='red'> <ul>");
			Iterator it = errMsgList.iterator();
			while(it.hasNext())
			{
			String msg = (String) it.next();
			errMsg.append("<li>" + msg + "</li>");
			}
			errMsg.append("</ul></font>");
		}
		return errMsg.toString();
	}
	
	/**
	 * @return Returns the requiredField.
	 */
	public String getRequiredField() {
		return requiredField;
	}
	/**
	 * @param requiredField The requiredField to set.
	 */
	public void setRequiredField(String requiredField) {
		this.requiredField = requiredField.trim();
	}
	/**
	 * @return Returns the ageValue.
	 */
	public int getAgeValue() {
		return ageValue;
	}
	/**
	 * @return Returns the background.
	 */
	public String getBackground() {
		return background;
	}
	/**
	 * @param background The background to set.
	 */
	public void setBackground(String background) {
		this.background = background;
	}
	/**
	 * @return Returns the colorDetails.
	 */
	public boolean isColorDetails() {
		return colorDetails;
	}
	/**
	 * @param colorDetails The colorDetails to set.
	 */
	public void setColorDetails(boolean colorDetails) {
		this.colorDetails = colorDetails;
	}
	/**
	 * @return Returns the foreground.
	 */
	public String getForeground() {
		return foreground;
	}
	/**
	 * @param foreground The foreground to set.
	 */
	public void setForeground(String foreground) {
		this.foreground = foreground;
	}
	
	public String suite()
	{   getErrMsgList();
		if(errMsgList.size()==0)
			return "suite";
		else return null;
	}
}
