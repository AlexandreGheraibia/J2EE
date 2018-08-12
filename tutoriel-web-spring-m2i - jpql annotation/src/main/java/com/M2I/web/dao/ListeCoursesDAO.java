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
import org.springframework.stereotype.Repository; 
import com.M2I.web.bean.Course; 
/*
 * best practice:
 * https://www.objectdb.com/java/jpa/query/api
 * 
 * */


/*
 * La DAO « ListeCoursesDAO » utilise le « EntityManager 
 * » pour lister les entités « Course » contenues dans la base de données. 
 * Pour cette méthode, le service « ServiceListeCourses » sert surtout de passeplat.
 *  Il faut noter toutefois que la transaction est indiquée en lecture seule
 * 
 * */

@Repository //le depot gere les transactions et les rollbacks en cas d'erreur
public class ListeCoursesDAO implements IListeCoursesDAO { 
	@PersistenceContext //creer un context persistent pour l'entity
	private EntityManager entityManager;
	public void creerCourse(final Course pCourse) {
		entityManager.persist(pCourse);
	}

	public void supprimerCourse(final Course pCourse) {
		//equivalent a find
		final Course lCourse = entityManager.getReference(Course.class,pCourse.getId());
		entityManager.remove(lCourse);
	} 
	
	  public List<Course> rechercherCourses() { 
			final TypedQuery<Course> lTypedQuery = entityManager.createNamedQuery("Course.findAll", Course.class); 
			return lTypedQuery.getResultList(); 
	 } 
	  public void modifierCourse(final Course pCourse) {

			final Query lQuery=entityManager.createNamedQuery("Course.setCourseQuantityById");
			lQuery.setParameter("id",pCourse.getId());
			lQuery.setParameter("quantite", pCourse.getQuantite());
			final int lRowCount =lQuery.executeUpdate();
			if (lRowCount != 1) {
				final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
				final String lSql = lHQuery.getQueryString();
				throw new RuntimeException("Nombre d'occurences (" + lRowCount +
						") modifiés différent de 1 pour " + lSql);
			}
		}
	//les mises à jour et les suppressions ne peuvent pas etre typé donc on reste en query
	/*Named parameters can provide added value to the clarity
	 *  of the query string (assuming that meaningful names are selected).
	 *   Therefore, they are preferred over ordinal parameters
	 * 
	 * 
	 * jpa 2 apporte les TypedQuery qui étendent les query 
	 * et criteria que l'on utilisera plus pour les resultats connus
	 * C'est deux interfaces sont dites dynamiques et on leur prefera points de vue performance
	 * les annotations dites static
	 *  
	private  final Query setCourseQuantityById(EntityManager em,int id,int quantite) {
		final Query lQuery = em.createQuery("UPDATE Course as c SET c.quantite = :quantite where c.id = :id");
		lQuery.setParameter("id",id);
		lQuery.setParameter("quantite", quantite);
		return lQuery;
	} 
	
	private  Course getCourseById(EntityManager em,int id) {
		TypedQuery<Course> query = em.createQuery("select c from Course c where c.id =:id", Course.class);
		return query.setParameter("id",id).getSingleResult();
	}
	private  TypedQuery<Course> getAll(EntityManager em) {
		TypedQuery<Course> query = em.createQuery("select c from Course c", Course.class);
		return query;
	}
	
	
	
	
	  public List<Course> rechercherCourses() { 
	 
		final TypedQuery<Course> lTypedQuery =  getAll(entityManager);
		return lTypedQuery.getResultList(); 
	} 
	public void modifierCourse(final Course pCourse) {

		final Query lQuery=setCourseQuantityById(entityManager,pCourse.getId(),pCourse.getQuantite());
		final int lRowCount =lQuery.executeUpdate();
		if (lRowCount != 1) {
			final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
			final String lSql = lHQuery.getQueryString();
			throw new RuntimeException("Nombre d'occurences (" + lRowCount +
					") modifiés différent de 1 pour " + lSql);
		}
	}
	/*equivalent in  criteria
	 * public List<Course> rechercherCourses() { 
		final CriteriaBuilder lCriteriaBuilder =
				entityManager.getCriteriaBuilder();
				final CriteriaQuery<Course> lCriteriaQuery =
				lCriteriaBuilder.createQuery(Course.class);
				final Root<Course> lRoot = lCriteriaQuery.from(Course.class);
				lCriteriaQuery.select(lRoot);
				final TypedQuery<Course> lTypedQuery =
				entityManager.createQuery(lCriteriaQuery);
				return lTypedQuery.getResultList();
	} 

	
	public void modifierCourse(final Course pCourse) {
		final CriteriaBuilder lCriteriaBuilder =
				entityManager.getCriteriaBuilder();
				final CriteriaUpdate<Course> lCriteriaUpdate =
				lCriteriaBuilder.createCriteriaUpdate(Course.class);
				final Root<Course> lRoot = lCriteriaUpdate.from(Course.class);
				final Path<Course> lPath = lRoot.get("id");
				final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath,
				pCourse.getId());
				lCriteriaUpdate.where(lExpression);
				lCriteriaUpdate.set("quantite", pCourse.getQuantite());
				final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
				final int lRowCount = lQuery.executeUpdate();
				if (lRowCount != 1) {
				final org.hibernate.Query lHQuery =
				lQuery.unwrap(org.hibernate.Query.class);
				final String lSql = lHQuery.getQueryString();
				throw new RuntimeException("Nombre d'occurences (" + lRowCount +
				") modifiés différent de 1 pour " + lSql);
				}
	}*/
} 
