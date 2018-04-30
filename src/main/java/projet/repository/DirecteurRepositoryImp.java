package projet.repository;

import org.springframework.data.repository.CrudRepository;

import projet.entity.Etudiant;

public interface DirecteurRepositoryImp extends CrudRepository<Etudiant, Integer> {

}
