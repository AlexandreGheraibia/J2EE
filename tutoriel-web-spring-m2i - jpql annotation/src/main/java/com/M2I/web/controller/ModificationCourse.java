package com.M2I.web.controller;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
public class ModificationCourse {
	private Integer id;
	private String libelle;
	@NotEmpty(message="{modification.course.quantite.notempty}")//non vide
	@Pattern(regexp="\\d*",message="{modification.course.quantite.numerique}")//vérifie que c'est juste des entiers
	private String quantite;//parametre post donc c'est un string on peut typer
	
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
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(final String pQuantite) {
		quantite = pQuantite;
	}
}