package projet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import projet.entity.Probleme;

public interface ProblemeDAOImp {

	Probleme findOne(long id);

	List<Probleme> findAll() throws DataAccessException;

	List<Probleme> findProbleme();

}
