package com.M2I.web.services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import com.M2I.web.bean.Course; 
import com.M2I.web.dao.IListeCoursesDAO; 
/*
 * les service utilise les injection dao
 * autowired j'utilise l'injection mémoire pour faire ca 
 * serveur manage, et c'est un singleton
 * 
 * 
 * */
@Service 
public class ServiceListeCourses implements IServiceListeCourses { 
	@Autowired 
	private IListeCoursesDAO dao; //c'est pour la diversité des implementation
	
	@Transactional(readOnly=true)  //dans les services en spring qu'on géres les transactions 
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