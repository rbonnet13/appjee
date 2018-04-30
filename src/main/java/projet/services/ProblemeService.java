package projet.services;

import projet.entity.Probleme;

public interface ProblemeService {

	Iterable<Probleme> listAllProbleme();

	Probleme getProblemeById(Integer id);

	void deleteProbleme(Integer id);

	Probleme saveProbleme(Probleme probleme);

}
