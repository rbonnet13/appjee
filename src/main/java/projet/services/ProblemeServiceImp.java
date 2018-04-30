package projet.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.entity.Probleme;
import projet.repository.ProblemeRepositoryImp;

@Service
@Transactional

public class ProblemeServiceImp implements ProblemeService {
	private ProblemeRepositoryImp problemeRepository;

	@Autowired
	public void setEtudiantRepository(ProblemeRepositoryImp problemeRepository) {
		this.problemeRepository = problemeRepository;
	}

	@Override
	public Iterable<Probleme> listAllProbleme() {
		return problemeRepository.findAll();
	}

	@Override
	public Probleme saveProbleme(Probleme probleme) {
		return problemeRepository.save(probleme);
	}

	@Override
	public void deleteProbleme(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Probleme getProblemeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
