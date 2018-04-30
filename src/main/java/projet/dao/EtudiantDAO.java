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

import projet.entity.Etudiant;

@Transactional
@Component
@Repository("EtudiantDAOImp")
public class EtudiantDAO implements EtudiantDAOImp {

	@PersistenceContext
	private EntityManager em; // Inject EntityManager
	// Note: the em is not thread safe but is associated with the current tx

	public EntityManager getEntityManager() {
		return em;
	}

	public void addStudent(Etudiant student) {
		em.persist(student); // Use EntityManager
	}

	public Etudiant getStudentById(long id) {
		return em.find(Etudiant.class, id);
	}

	public void save(Etudiant student) {
		em.merge(student);
	}

	@Override
	public Etudiant findOne(long id) {
		return em.find(Etudiant.class, id);
	}

	@Override
	public List<Etudiant> findAll() throws DataAccessException {
		final CriteriaBuilder lCriteriaBuilder = em.getCriteriaBuilder();
		final CriteriaQuery<Etudiant> lCriteriaQuery = lCriteriaBuilder.createQuery(Etudiant.class);
		final Root<Etudiant> lRoot = lCriteriaQuery.from(Etudiant.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Etudiant> lTypedQuery = em.createQuery(lCriteriaQuery);
		return lTypedQuery.getResultList();
	}

	@Override
	public List<Etudiant> findStudent() {
		List<Etudiant> etudiant;
		etudiant = em.createQuery("SELECT * FROM etudiant ").getResultList();
		return etudiant;
	}

	public void create(Etudiant entity) {
		em.persist(entity);
	}

	public Etudiant update(Etudiant entity) {
		return em.merge(entity);
	}

	public void delete(Etudiant entity) {
		em.remove(entity);
	}

	public void deleteById(long entityId) {
		Etudiant entity = findOne(entityId);
		delete(entity);
	}
}
