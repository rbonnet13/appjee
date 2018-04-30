package projet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import projet.entity.Etudiant;

public interface DirecteurDAOImp {

	Etudiant findOne(long id);

	List<Etudiant> findAll() throws DataAccessException;

}
