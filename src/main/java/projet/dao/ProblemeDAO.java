package projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import projet.entity.Probleme;

@Transactional
@Component
@Repository("ProblemeDAOImp")
public class ProblemeDAO implements ProblemeDAOImp {
	@PersistenceContext
	private EntityManager em; // Inject EntityManager
	// Note: the em is not thread safe but is associated with the current tx

	public EntityManager getEntityManager() {
		return em;
	}

	public void addProbleme(Probleme probleme) {
		em.persist(probleme); // Use EntityManager
	}

	public Probleme getProblemeById(long id) {
		return em.find(Probleme.class, id);
	}

	public void save(Probleme probleme) {
		em.merge(probleme);
	}

	@Override
	public Probleme findOne(long id) {
		return em.find(Probleme.class, id);
	}

	@Override
	public List<Probleme> findAll() throws DataAccessException {
		final CriteriaBuilder lCriteriaBuilder = em.getCriteriaBuilder();
		final CriteriaQuery<Probleme> lCriteriaQuery = lCriteriaBuilder.createQuery(Probleme.class);
		final Root<Probleme> lRoot = lCriteriaQuery.from(Probleme.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Probleme> lTypedQuery = em.createQuery(lCriteriaQuery);
		return lTypedQuery.getResultList();
	}

	@Override
	public List<Probleme> findProbleme() {
		List<Probleme> probleme;
		probleme = em.createQuery("SELECT * FROM probleme ").getResultList();
		return probleme;
	}

	public void create(Probleme entity) {
		em.persist(entity);
	}

	public Probleme update(Probleme entity) {
		return em.merge(entity);
	}

	public void delete(Probleme entity) {
		em.remove(entity);
	}

	public void deleteById(long entityId) {
		Probleme entity = findOne(entityId);
		delete(entity);
	}

}
