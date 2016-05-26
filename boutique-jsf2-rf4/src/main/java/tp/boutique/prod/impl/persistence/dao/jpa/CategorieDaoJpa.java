package tp.boutique.prod.impl.persistence.dao.jpa;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;

import org.mycontrib.generic.persistence.GenericDaoJpaImpl;

import tp.boutique.prod.impl.persistence.dao.CategorieDao;
import tp.boutique.prod.itf.domain.entity.Categorie;

@Named
//@Transactional inherited
public class CategorieDaoJpa extends GenericDaoJpaImpl<Categorie,Long> implements CategorieDao {

	
	@Override
	public List<Categorie> getCategoriesWithoutParent() {
		Query q = this.entityManager.createQuery("select c from Categorie c where c.parentCategorie is null");
		return q.getResultList();
	}

	
	

}
