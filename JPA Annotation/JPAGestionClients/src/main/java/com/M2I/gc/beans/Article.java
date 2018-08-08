package com.M2I.gc.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "TArticle",schema="dbo")
public class Article {
	@Id //Not null primary key
	@Column(name="IdArticle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	@Column(name="DescriptionArticle",nullable=true)
	private String description;
	
	@Column(name="TarifUnitaire",nullable=true)
	private double tarifUnitaire;
	
	@OneToMany(mappedBy="article")
	private List<FactureDet> factDetails;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTarifUnitaire() {
		return tarifUnitaire;
	}
	public void setTarifUnitaire(double tarifUnitaire) {
		this.tarifUnitaire = tarifUnitaire;
	}
	
}
