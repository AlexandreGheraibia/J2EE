package com.M2I.web.bean;

import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table; 
@Entity 
@NamedQueries({
    @NamedQuery(name="Course.findAll",
                query="SELECT c FROM Course c"),
    @NamedQuery(name="Course.setCourseQuantityById",
                query="UPDATE Course as c SET c.quantite=:quantite WHERE c.id = :id"),
}) 
@Table(name="LISTECOURSES") 
public class Course { 
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="IDOBJET") 
	private Integer id; 
	private String libelle; 
	private Integer quantite; 
	
	public Integer getId() { 
		return id; 
	} 
	public void setId(final Integer pId) { 
		id = pId; 
	} 
	public String getLibelle() { 
		return libelle; 
	} 
	public void setLibelle(final String pLibelle) { 
		libelle = pLibelle;
	}
	public Integer getQuantite() { 
		return quantite; 
	} 
	public void setQuantite(final Integer pQuantite) { 
		quantite = pQuantite; 
	} 
} 
