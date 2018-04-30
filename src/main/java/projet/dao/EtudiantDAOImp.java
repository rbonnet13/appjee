package projet.dao;

import java.util.List;

import projet.entity.Etudiant;

public interface EtudiantDAOImp {
	List<Etudiant> findAll();

	List<Etudiant> findStudent();

	Etudiant findOne(long id);

	void save(Etudiant student);
}
