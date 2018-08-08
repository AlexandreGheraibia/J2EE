package com.M2I.web.dao;
import java.util.List; 
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery; 
import javax.persistence.criteria.CriteriaBuilder; 
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; 
import com.M2I.web.bean.Course; 

@Repository //le depot gere les transactions et les rollbacks en cas d'erreur
public class ListeCoursesDAO implements IListeCoursesDAO { 
	@PersistenceContext //creer un context persistent pour l'entity
	private EntityManager entityManager;
	public void creerCourse(final Course pCourse) {
		entityManager.persist(pCourse);
		}
	
	public void supprimerCourse(final Course pCourse) {
		final Course lCourse = entityManager.getReference(Course.class,
		pCourse.getId());
		entityManager.remove(lCourse);
		}
	
	public List<Course> rechercherCourses() { 
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder(); 
		final CriteriaQuery<Course> lCriteriaQuery =  lCriteriaBuilder.createQuery(Course.class); 
		final Root<Course> lRoot = lCriteriaQuery.from(Course.class); 
		lCriteriaQuery.select(lRoot); 
		final TypedQuery<Course> lTypedQuery =  entityManager.createQuery(lCriteriaQuery); 
		return lTypedQuery.getResultList(); 
	} 
	@Autowired
	public void modifierCourse(final Course pCourse) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaUpdate<Course> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Course.class);
		final Root<Course> lRoot = lCriteriaUpdate.from(Course.class);
		final Path<Course> lPath = lRoot.get("id");
		final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath,
		pCourse.getId());
		lCriteriaUpdate.where(lExpression);
		lCriteriaUpdate.set("quantite", pCourse.getQuantite());
		final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
		final int lRowCount = lQuery.executeUpdate();
		if (lRowCount != 1) {
			final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
			final String lSql = lHQuery.getQueryString();
			throw new RuntimeException("Nombre d'occurences (" + lRowCount +
			") modifiés différent de 1 pour " + lSql);
			}
		}
} 