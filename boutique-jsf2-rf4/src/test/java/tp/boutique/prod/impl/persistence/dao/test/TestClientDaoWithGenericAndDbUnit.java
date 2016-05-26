package tp.boutique.prod.impl.persistence.dao.test;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.mycontrib.generic.test.GenericDaoTestWithDbUnit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import tp.boutique.prod.impl.persistence.dao.ClientDao;
import tp.boutique.prod.itf.domain.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/serviceSpringConf.xml","/dataSourceForTestSpringConf.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class TestClientDaoWithGenericAndDbUnit extends GenericDaoTestWithDbUnit<Client,Long>{
	
	private ClientDao dao ;

	public ClientDao getDao() {
		return dao;
	}
	
	@Inject
	 public void setDataSource(DataSource dataSource){
		 super.setDataSource(dataSource);
	 }

	@Inject
	public void setDao(ClientDao dao) {
		this.dao = dao;
		this.setGenericDao(dao);
	}
	
	@Override
	public Long getPkOfEntity(Client cli){
		return cli.getNumero();
	}
			
	
}
