package projet.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.entity.Etudiant;
import projet.repository.EtudiantRepositoryImp;

@Service
@Transactional

public class EtudiantServiceImp implements EtudiantService {

	private EtudiantRepositoryImp etudiantRepository;

	@Autowired
	public void setEtudiantRepository(EtudiantRepositoryImp etudiantRepository) {
		this.etudiantRepository = etudiantRepository;
	}

	@Override
	public Iterable<Etudiant> listAllEtudiant() {
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant saveEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public void deleteEtudiant(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Etudiant getEtudiantById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
