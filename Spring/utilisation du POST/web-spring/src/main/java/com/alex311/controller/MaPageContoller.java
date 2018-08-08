package com.alex311.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/accueil")
public class MaPageContoller {
	
	@RequestMapping(method = RequestMethod.GET)
	public String respondToUser(final ModelMap pModel) {
		return "maPage";
	}

}
