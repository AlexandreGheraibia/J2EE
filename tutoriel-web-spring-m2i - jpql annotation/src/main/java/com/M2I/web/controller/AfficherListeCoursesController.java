package com.M2I.web.controller;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;//controlleur spring 
import org.springframework.ui.ModelMap; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import com.M2I.web.bean.Course; 
import com.M2I.web.services.IServiceListeCourses; 

@Controller 
@RequestMapping(value="/afficherListeCourses") 
public class AfficherListeCoursesController { //les controleur de servlet spring
	@Autowired 
	private IServiceListeCourses service; 
	@RequestMapping(method = RequestMethod.GET) //on verouille l'acces, on le limte a get evite les injectin par post
	public String afficher(ModelMap pModel) { 
	final List<Course> lListeCourses = service.rechercherCourses(); 
		pModel.addAttribute("listeCourses", lListeCourses);//model REST, request, response et c.. 
	return "listeCourses"; //lance les servlet de spring car controleur de spring
	} 
} 
