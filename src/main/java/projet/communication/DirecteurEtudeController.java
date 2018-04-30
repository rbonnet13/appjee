package projet.communication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projet.services.DirecteurServiceImp;

@Controller
public class DirecteurEtudeController {
	@Autowired
	DirecteurServiceImp directeurService;
	@Value("${home.message:test}")
	private String message;

	@RequestMapping(value = "/directeuretudiant", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("directeuretudiant", directeurService.listAllEtudiant());
		return "directeuretudiant";
	}

}
