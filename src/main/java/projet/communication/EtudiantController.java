package projet.communication;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projet.entity.Etudiant;
import projet.entity.Probleme;
import projet.services.EtudiantServiceImp;
import projet.services.ProblemeServiceImp;

@Controller
public class EtudiantController {
	@Autowired
	EtudiantServiceImp etudiantService;
	ProblemeServiceImp problemeService;
	@Value("${home.message:test}")
	private String message;

	@RequestMapping("/home")
	public String newEtudiant(Model model) {
		model.addAttribute("etudiant", new Etudiant());
		return "home";
	}

	@RequestMapping("/etudiant")
	public String newProbleme(Model model1) {
		model1.addAttribute("probleme", new Probleme());
		return "etudiant";
	}

	@RequestMapping(value = "probleme", method = RequestMethod.POST)
	public String saveProbleme(Probleme probleme) {
		problemeService.saveProbleme(probleme);
		return "probleme";
	}

	@RequestMapping(value = "etudiant", method = RequestMethod.POST)
	public String saveEtudiant(Etudiant etudiant) {
		etudiantService.saveEtudiant(etudiant);
		return "etudiant";
	}

	@RequestMapping("/information")
	public String information(Map<String, Object> model) {
		return "information";
	}

	@RequestMapping(value = "probleme", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("probleme", problemeService.listAllProbleme());
		return "probleme";
	}
}