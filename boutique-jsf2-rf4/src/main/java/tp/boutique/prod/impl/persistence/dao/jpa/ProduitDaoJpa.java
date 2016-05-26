package tp.boutique.prod.impl.persistence.dao.jpa;

import javax.inject.Named;

import org.mycontrib.generic.persistence.GenericDaoJpaImpl;

import tp.boutique.prod.impl.persistence.dao.ProduitDao;
import tp.boutique.prod.itf.domain.entity.Produit;

@Named
//@Transactional inherited
public class ProduitDaoJpa extends GenericDaoJpaImpl<Produit,Long> implements ProduitDao {

	
	

}
