package com.M2I.web.controller;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
public class CreationForm {
	@NotEmpty
	private String libelle; //ne doit pas etre vide 
	@NotEmpty
	@Pattern(regexp="\\d*") //ne doit pas etre vide et ddoit etre un chiffre 
	
	private String quantite; 
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
