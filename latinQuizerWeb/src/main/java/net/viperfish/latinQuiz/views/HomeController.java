package net.viperfish.latinQuiz.views;

import java.util.Map;
import net.viperfish.latinQuiz.core.LatinVerbDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private LatinVerbDatabase db;

	public HomeController() {
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Map<String, Object> model) {
		model.put("size", db.count());
		return "home";
	}

}
