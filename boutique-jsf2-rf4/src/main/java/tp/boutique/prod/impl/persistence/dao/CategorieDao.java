package tp.boutique.prod.impl.persistence.dao;

import java.util.List;

import org.mycontrib.generic.persistence.GenericDao;

import tp.boutique.prod.itf.domain.entity.Categorie;

public interface CategorieDao extends GenericDao<Categorie,Long> {
    public List<Categorie> getCategoriesWithoutParent();
}
