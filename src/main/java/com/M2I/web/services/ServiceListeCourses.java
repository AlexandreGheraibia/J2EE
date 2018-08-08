package com.M2I.web.services;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import com.M2I.web.bean.Course; 
import com.M2I.web.dao.IListeCoursesDAO; 
@Service 
public class ServiceListeCourses implements IServiceListeCourses { 
	@Autowired //fait le lien automatiquement entre la base de donnée et les entitées
	private IListeCoursesDAO dao; 
	//consultation de la base en mode lecture pas de modification
	//de la base donnée
	@Transactional(readOnly=true) 
	public List<Course> rechercherCourses() { 
		return dao.rechercherCourses();
	} 
	@Transactional
	public void creerCourse(final String pLibelle, final Integer pQuantite) {
		final Course lCourse = new Course();
		lCourse.setLibelle(pLibelle);
		lCourse.setQuantite(pQuantite);
		dao.creerCourse(lCourse);
	}
	@Transactional
	public void supprimerCourse(final Integer pIdCourse) {
		final Course lCourse = new Course();
		lCourse.setId(pIdCourse);
		dao.supprimerCourse(lCourse);
	}
	@Transactional
	public void modifierCourses(final List<Course> pListeCourses) {
		for (final Course lCourse : pListeCourses) {
		dao.modifierCourse(lCourse);
		}
	}
	
} 