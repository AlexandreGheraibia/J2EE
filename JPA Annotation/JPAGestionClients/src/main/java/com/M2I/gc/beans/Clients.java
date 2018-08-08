package com.M2I.gc.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Tclient",schema="dbo")
public class Clients {
	@Id //Not null primary key
	@Column(name="IdClient")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="client")
	private List<Facture> Factures; 
	
	@Column(name="NomClient",nullable=true)
	private String nom;

	@Column(name="AdresseClient")
	private String adresse;

	@Column(name="VilleClient")
	private String ville;

	@Column(name="CdpClient")
	private String cdp;

	@Column(name="DateCreationClient")
	@Temporal(TemporalType.DATE)
	private Date datecreation;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCdp() {
		return cdp;
	}

	public void setCdp(String cdp) {
		this.cdp = cdp;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Facture> getFactures() {
		return Factures; 
	}


}
