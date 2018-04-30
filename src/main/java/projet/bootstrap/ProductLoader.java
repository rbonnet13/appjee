package projet.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import projet.entity.Directeur;
import projet.entity.Etudiant;
import projet.repository.EtudiantRepositoryImp;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private EtudiantRepositoryImp etudiantRepository;

	@Autowired
	public void setProductRepository(EtudiantRepositoryImp etudiantRepository) {
		this.etudiantRepository = etudiantRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Etudiant p1 = new Etudiant();
		p1.setId(1);
		p1.setEtablissement("ESAIP");
		p1.setNom("BONNET");
		p1.setPrenom("Rudy");
		p1.setPromotion("2018");
		etudiantRepository.save(p1);

		Etudiant p2 = new Etudiant();
		p2.setId(2);
		p2.setEtablissement("ESAIP");
		p2.setNom("FOUILLADE");
		p2.setPrenom("Julian");
		p2.setPromotion("2018");
		etudiantRepository.save(p2);

		Etudiant p3 = new Etudiant();
		p3.setId(3);
		p3.setEtablissement("ESAIP");
		p3.setNom("MARTY");
		p3.setPrenom("Ben");
		p3.setPromotion("2018");
		etudiantRepository.save(p3);

		Directeur d1 = new Directeur();
		d1.setIdDirecteur(0);
		d1.setNomDirecteur("Baba");
		d1.setTypeDirecteur("Etude");
		d1.setEtudiantsRattaches("");

	}
}
