package com.alex311.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/accueil")
public class welcomeController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String respondToUser(final ModelMap pModel, @RequestParam(value="prenom") final String pPrenom,
		@RequestParam(value="metier") final String pMetier) {
		pModel.addAttribute("prenom",pPrenom);
		pModel.addAttribute("metier",pMetier);
		return "welcome";
	}
}




