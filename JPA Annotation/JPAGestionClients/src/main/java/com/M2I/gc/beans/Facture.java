package com.M2I.gc.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "TFacture",schema="dbo")
@NamedQueries({
@NamedQuery( name = "Facture.findPayeAll",
query = "SELECT FACT FROM Facture AS FACT where PayerFacture=1" ),
@NamedQuery( name = "Facture.findNonPayeAll",
query = "SELECT FACT FROM Facture AS FACT where PayerFacture=0" )

})

public class Facture {
	
	@Id //Not null primary key
 	@Column(name="IdFacture")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="IdClient")
	private Clients client; 
	@OneToMany(mappedBy="facture")
	private List<FactureDet> factDetails;
	
	public List<FactureDet> getFactDetails() {
		return factDetails;
	}
	public void setFactDetails(List<FactureDet> factDetails) {
		this.factDetails = factDetails;
	}
	@Column(name="AdresseFacture",nullable=false)
	private String adresse;
	@Column(name="MontantFacture",nullable=false)
	private double montant;
	@Column(name="DescriptionFacture",nullable=true)
	private String description;
	@Column(name="PayerFacture",nullable=false)
	
	private boolean payer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPayer() {
		return payer;
	}
	public void setPayer(boolean payer) {
		this.payer = payer;
	}
	
}
