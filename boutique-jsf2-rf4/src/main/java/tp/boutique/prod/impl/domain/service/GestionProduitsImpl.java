package tp.boutique.prod.impl.domain.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import tp.boutique.prod.impl.persistence.dao.CategorieDao;
import tp.boutique.prod.impl.persistence.dao.ProduitDao;
import tp.boutique.prod.itf.domain.entity.Categorie;
import tp.boutique.prod.itf.domain.entity.Produit;
import tp.boutique.prod.itf.domain.service.GestionProduits;
import tp.boutique.prod.itf.domain.service.MyServiceException;

@Named
@Transactional(rollbackFor=MyServiceException.class)
@WebService(targetNamespace="http://tp.boutique.prod/",
endpointInterface="tp.boutique.prod.itf.domain.service.GestionProduits")
public class GestionProduitsImpl implements GestionProduits {
	
	private static Logger logger = LoggerFactory.getLogger(GestionProduitsImpl.class);
	
	@Inject
	private ProduitDao produitDao;
	
	@Inject
	private CategorieDao categorieDao;
	
	
	

	@Override
	public Categorie getCategorieByNum(long numCat) throws MyServiceException {
		Categorie cat=null;
		try {
			cat= categorieDao.getEntityById(numCat);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("echec GestionProduitsImpl.getCategorieByNum",e);
			throw new MyServiceException("echec GestionProduitsImpl.getCategorieByNum",e);
		}
		return cat;
	}

	@Override
	public List<Produit> getProductsOfCategory(long numCat)
			throws MyServiceException {
			List<Produit> listeProd = null;
			try {
				Categorie cat= categorieDao.getEntityById(numCat);
				
				//NB: appeler ".size()" sur une collection permet de charger en mémoire
				//ce qui ne l'est peut être pas encore en mode "lazy"
				//cette "bidouille" est quelquefois utile si pas de Open...InViewFilter .
				listeProd = cat.getProduits();
				listeProd.size();
			} catch (Exception e) {
				logger.error("echec GestionProduitsImpl.getProductsOfCategory",e);
				throw new MyServiceException("echec GestionProduitsImpl.getProductsOfCategory",e);
			}
			return listeProd;		
	}

	@Override
	public List<Categorie> getMainCategories() throws MyServiceException {
		List<Categorie> listCat=null;
		try {
			
			listCat = categorieDao.getCategoriesWithoutParent();
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("echec GestionProduitsImpl.getMainCategories",e);
			throw new MyServiceException("echec GestionProduitsImpl.getMainCategories",e);
		}
		return listCat;
	}

	@Override
	public List<Categorie> getSubCategories(long numCat)
			throws MyServiceException {
		List<Categorie> listCat=null;
		try {
			Categorie cat= categorieDao.getEntityById(numCat);
			listCat = cat.getSousCategories();
			listCat.size(); //to avoid lazy exception
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("echec GestionProduitsImpl.getSubCategories",e);
			throw new MyServiceException("echec GestionProduitsImpl.getSubCategories",e);
		}
		return listCat;
	}

	@Override
	public Produit getProduitByNum(long numProd) throws MyServiceException {
		Produit p=null;
		try {
			p= produitDao.getEntityById(numProd);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("echec GestionProduitsImpl.getProduitByNum",e);
			throw new MyServiceException("echec GestionProduitsImpl.getProduitByNum",e);
		}
		return p;
	}

}
