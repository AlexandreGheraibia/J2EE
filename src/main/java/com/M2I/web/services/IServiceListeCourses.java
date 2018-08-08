package com.M2I.web.services;

import java.util.List; 
import com.M2I.web.bean.Course; 
public interface IServiceListeCourses { 
     List<Course> rechercherCourses();
     //ajout de la valeur de l'entity 
     void creerCourse(final String pLibelle, final Integer pQuantite);
     void supprimerCourse(final Integer pIdCourse);
     void modifierCourses(final List<Course> pListeCourses);
} 