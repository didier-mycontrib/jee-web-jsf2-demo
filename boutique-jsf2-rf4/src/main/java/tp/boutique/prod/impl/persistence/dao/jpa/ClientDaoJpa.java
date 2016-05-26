package tp.boutique.prod.impl.persistence.dao.jpa;

import javax.inject.Named;

import org.mycontrib.generic.persistence.GenericDaoJpaImpl;

import tp.boutique.prod.impl.persistence.dao.ClientDao;
import tp.boutique.prod.itf.domain.entity.Client;

@Named
//@Named (de JEE6 , Spring3) ou bien @Component (de Spring 2.5)
//demande à Spring de créer un composant de la classe courante
//avec comme id par défaut le nom de la classe commencant par 
//une minuscule
// equivalent
// <bean id="clientDaoJpa class="....ClientDaoJpa" />

//@Transactional inherited
public class ClientDaoJpa  extends GenericDaoJpaImpl<Client,Long> implements ClientDao {

}
