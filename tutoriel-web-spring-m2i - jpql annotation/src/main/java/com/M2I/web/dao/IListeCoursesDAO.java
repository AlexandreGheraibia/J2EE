/**
 * 
 */
package com.M2I.web.dao;

/* Attention :
 *La DAO « ListeCoursesDAO » utilise le « EntityManager » pour lister les 
 *entités « Course » contenues dans la base de données.  
 * */
import java.util.List;

import com.M2I.web.bean.Course; 

public interface IListeCoursesDAO { 
	//ajout de l'entity pCourse
		void creerCourse(final Course pCourse);
	    List<Course> rechercherCourses();
	    void modifierCourse(final Course pCourse);
	    void supprimerCourse(final Course pCourse);
} 