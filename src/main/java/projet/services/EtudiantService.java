package projet.services;

import projet.entity.Etudiant;

public interface EtudiantService {
	Iterable<Etudiant> listAllEtudiant();

	Etudiant getEtudiantById(Integer id);

	void deleteEtudiant(Integer id);

	Etudiant saveEtudiant(Etudiant etudiant);

}