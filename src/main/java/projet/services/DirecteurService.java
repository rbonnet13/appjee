package projet.services;

import projet.entity.Etudiant;

public interface DirecteurService {
	Iterable<Etudiant> listAllEtudiant();

	Etudiant getEtudiantById(Integer id);

	void deleteEtudiant(Integer id);

}
