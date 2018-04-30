package projet.repository;

import org.springframework.data.repository.CrudRepository;

import projet.entity.Etudiant;

public interface EtudiantRepositoryImp extends CrudRepository<Etudiant, Integer> {

}
