package com.M2I.web.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.M2I.web.bean.Course;
import com.M2I.web.services.IServiceListeCourses;


@Controller
public class CreerListeCoursesController {
	@Autowired	//liaison avec la base de donnée
	private IServiceListeCourses service; // le service 
	@RequestMapping(value="/afficherCreationListeCourses", method =RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		//recupere la liste de course grace au service
		final List<Course> lListeCourses = service.rechercherCourses();
		//envoi la liste de course a la page jsp
		pModel.addAttribute("listeCourses", lListeCourses);
		if (pModel.get("creation") == null) {//verifie que creation existe avant 
			System.out.println("\n\n\n get('creation') is "+pModel.get("creation")); 
			pModel.addAttribute("creation", new CreationForm());
		}
		return "creation";
	}
	@RequestMapping(value="/creerCreationListeCourses", method =RequestMethod.POST)
	/*
	 *  L'annotation « @ModelAttribute » (existant depuis Spring 2.5) de la méthode « creer » indique que
	 *   le paramètre « pCreation » est constitué à partir de l'attribut « creation ». 
	 *   
	 *   *************************************************************************************************
	 *   
	 *   L'annotation « @Valid » indique que le formulaire doit être validé grâce aux annotations contenues
	 *    dans la classe de formulaire « CreationForm ». 
	 * */
	public String creer(@Valid @ModelAttribute(value="creation") final CreationForm pCreation,final BindingResult pBindingResult, final ModelMap pModel) {
			if (!pBindingResult.hasErrors()) {
				final Integer lIntQuantite =Integer.valueOf(pCreation.getQuantite());
				service.creerCourse(pCreation.getLibelle(), lIntQuantite);
			}
		return afficher(pModel);
	}
}