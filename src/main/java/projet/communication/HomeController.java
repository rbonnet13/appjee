package projet.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Value("${home.message:test}")
	private String message;

	public List<String> getUseCases() {
		List<String> uc = new ArrayList<String>();
		uc.add("List Etudiant (GET '/Etudiant')");
		uc.add("Find Etudiant by registration number (GET '/Etudiant/find?number=xxx')");
		uc.add("Create Etudiant (GET '/students/create?new' && POST '/Etudiant/create')");
		return uc;
	}

	@RequestMapping("/index")
	public String etudiants(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}
}
