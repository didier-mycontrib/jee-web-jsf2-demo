package org.mycontrib.generic.test;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Before;
import org.mycontrib.generic.test.dbunit.util.DBUnitHelper;
import org.mycontrib.generic.test.dbunit.util.EntityLoaderFromXmlDataSet;

/**
 * @author Didier Defrance
 * 
 * Classe de Test générique pour tester un dao dans le cadre suivant:
 *     - via JUnit4 et SpringTest
 *     - utilisation de dbUnit pour gérer le contenu la base de données lors des tests
 *     - test d'un dao dont le code est basé sur héritage de GenericDao(JpaImpl)
 *     
 * Utilisation:
 * 
 *     créer une sous classe héritant de GenericDaoTestWithDbUnit
 */

public abstract class GenericDaoTestWithDbUnit<T,ID extends Serializable> extends GenericDaoSimpleTest<T,ID> {
	
	 private DBUnitHelper dbUnitHelper = null;
	 private EntityLoaderFromXmlDataSet entityLoaderFromXmlDataSet=null;
	 private String className;
	 private String tableName; //in Xml DataSet
	 
	 private Class<T> persistentClass;
	 
	 //par convention (dans src/test/resources) :
	 // dataset/initialDataSet.xml  [chargé comme état initial de la base de données]
	 // dataset/newTableXY.xml [pour récupérer valeurs pour insert into et pour vérifier l'ajout ]
	 // dataset/updatedTableXY.xml [pour récupérer valeurs pour l'update  et pour vérifier la mise à jour ]
	 
	 //@Autowired (ici et/ou dans sous classe)
	 public void setDataSource(DataSource dataSource){
		 dbUnitHelper.setDataSource(dataSource);
	 }
	 
	 private void initPersistentClass(){
			try {
				   String className=getClass().getSimpleName();
				   if(className.indexOf('$')!= -1)
					   return; // cas d'une classe améliorée par cglib
		    	   //System.out.println(getClass().getSimpleName());
		    	   ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();  
		    	   //System.out.println("parameterizedType="+parameterizedType.toString());
		    	   Type typeT = parameterizedType.getActualTypeArguments()[0];
		    	   //System.out.println(typeT.toString());
		    	   if(!typeT.toString().equals("T")){
		    		   this.persistentClass = (Class<T>) typeT;
		    		   //System.out.println("persistentClass="+persistentClass.getSimpleName());		    		   
		    	   }
			} catch (Exception e) {
				//e.printStackTrace();
				System.err.println("initPersistentClass:"+e.getMessage());
			}
		}
	 
	   private void initClassAndTableNames(){
		   this.className=this.persistentClass.getSimpleName();
			this.tableName=className;
			if(tableName.startsWith("_"))
				tableName=tableName.substring(1);
	   }
		
		public GenericDaoTestWithDbUnit() {
			super();
			initPersistentClass();
			if(this.persistentClass!=null)
				initClassAndTableNames();
			dbUnitHelper = new DBUnitHelper();
			entityLoaderFromXmlDataSet=new EntityLoaderFromXmlDataSet();
	     }
		

		public Class<T> getPersistentClass() {
			return persistentClass;
		}

	 
	 @Before
     public void setUp()
    {
        try {
			dbUnitHelper.reInitDataBaseFromInitialDataSet();
		} catch (Exception e) {
			e.printStackTrace();
			TestCase.fail(e.getMessage());
			
		}
    }

	 /*
	@Override
	public ID getPkOfEntity(T entity) {
		// eventuel autoDétection si parcours et découverte de @Id
		return null;
	}*/
	 
	 
	 /**
	  * mode="new" or "updated"
	  */
	private void loadEntityValuesFromXmlDataSet(T entity,String mode){
		try {
			String dataSetDirectory = this.dbUnitHelper.getDataSetDirectory();
			String dataSetPathName = dataSetDirectory+"/"+mode+tableName+".xml";
			IDataSet dataSet=new FlatXmlDataSet(new File(dataSetPathName));
			this.entityLoaderFromXmlDataSet.setDataSet(dataSet);
			this.entityLoaderFromXmlDataSet.loadEntityValues(entity, this.persistentClass);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private List<String> loadEntityValuesDifferencesFromXmlDataSet(T entity,String mode){
		List<String> res=null;
		try {
			String dataSetDirectory = this.dbUnitHelper.getDataSetDirectory();
			String dataSetPathName = dataSetDirectory+"/"+mode+tableName+".xml";
			IDataSet dataSet=new FlatXmlDataSet(new File(dataSetPathName));
			this.entityLoaderFromXmlDataSet.setDataSet(dataSet);
			res= this.entityLoaderFromXmlDataSet.loadEntityValuesDifferences(entity, this.persistentClass);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return res;
	}

	@Override
	public T newEntity() {
		// instanciation via newInstance()
		// et tentative de chargement de valeurs depuis "newTableXY.xml"
		T e = null;
		try {
			e = (T) this.persistentClass.newInstance();			
			//System.out.println("new entity:"+e);
			this.loadEntityValuesFromXmlDataSet(e,"new");
			//System.out.println("new entity with loaded values:"+e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return e;
	}

	@Override
	public void assertValuesOfNewEntity(T entity) {
		// tentative de chargement de valeurs depuis "newTableXY.xml"
		// comparaison
		// + verif via dbUnit		
		try {
			List<String> listeDiff = this.loadEntityValuesDifferencesFromXmlDataSet(entity,"new");
			if(!listeDiff.isEmpty()){
				TestCase.fail(listeDiff.toString());
			}else{
				//System.out.println("assertValuesOfNewEntity ok");
			}
			//this.dbUnitHelper.assertExpectedTableFromAdditionDataSet(this.tableName, "new"+tableName+".xml");
			//problème : ok si plusieurs petites transactions , pb sinon (commit/flush différé)
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}

	@Override
	public void changeValuesOfEntity(T entity) {
		// tentative de chargement de valeurs depuis "updatedTableXY.xml"
		try {
			//System.out.println("unchanged entity:"+entity);
			this.loadEntityValuesFromXmlDataSet(entity,"updated");
			//System.out.println("updated entity with loaded values:"+entity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void assertChangedValuesOfNewEntity(T entity) {
		// tentative de chargement de valeurs depuis "updatedTableXY.xml"
		// comparaison
		// + verif via dbUnit
		try {
			List<String> listeDiff = this.loadEntityValuesDifferencesFromXmlDataSet(entity,"updated");
			if(!listeDiff.isEmpty()){
				TestCase.fail(listeDiff.toString());
			}else{
				//System.out.println("assertChangedValuesOfNewEntity ok");
			}
			//this.dbUnitHelper.assertExpectedTableFromAdditionDataSet(this.tableName, "updated"+tableName+".xml");
			//problème : ok si plusieurs petites transactions , pb sinon (commit/flush différé)
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	 
	 

}
