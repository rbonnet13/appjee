package projet.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.entity.Etudiant;
import projet.repository.DirecteurRepositoryImp;

@Service
@Transactional

public class DirecteurServiceImp implements DirecteurService {
	private DirecteurRepositoryImp directeurRepository;

	@Autowired
	public void setEtudiantRepository(DirecteurRepositoryImp directeurRepository) {
		this.directeurRepository = directeurRepository;
	}

	@Override
	public Iterable<Etudiant> listAllEtudiant() {
		return directeurRepository.findAll();
	}

	@Override
	public Etudiant getEtudiantById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEtudiant(Integer id) {
		// TODO Auto-generated method stub

	}

}
