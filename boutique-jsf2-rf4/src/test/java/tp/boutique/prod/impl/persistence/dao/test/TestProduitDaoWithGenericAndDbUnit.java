package tp.boutique.prod.impl.persistence.dao.test;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.mycontrib.generic.test.GenericDaoTestWithDbUnit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import tp.boutique.prod.impl.persistence.dao.ProduitDao;
import tp.boutique.prod.itf.domain.entity.Produit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/serviceSpringConf.xml","/dataSourceForTestSpringConf.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class TestProduitDaoWithGenericAndDbUnit extends GenericDaoTestWithDbUnit<Produit,Long>{
	
	private ProduitDao dao ;

	public ProduitDao getDao() {
		return dao;
	}
	
	@Inject
	 public void setDataSource(DataSource dataSource){
		 super.setDataSource(dataSource);
	 }

	@Inject
	public void setDao(ProduitDao dao) {
		this.dao = dao;
		this.setGenericDao(dao);
	}
	
	@Override
	public Long getPkOfEntity(Produit p){
		return p.getNumero();
	}
			
	
}
