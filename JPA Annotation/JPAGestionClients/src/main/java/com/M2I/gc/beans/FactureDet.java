package com.M2I.gc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TFactureDet",schema="dbo")
public class FactureDet {
	@Id
	@Column(name="IdFactDet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="IdFact",nullable=true)
	private Facture facture;
	//list
	@ManyToOne
	@JoinColumn(name="IdArticle",nullable=true)
	private Article article;
	@Column(name="QteFact",nullable=true)
	private int quantity;
	@Column(name="TxTVA",nullable=true)
	private double txTva;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Facture getFact() {
		return facture;
	}
	public void setFact(Facture facture) {
		this.facture = facture;
	}
	public Article getArticle() {
		return this.article;
	}
	public void setArticle(Article article) {
		this.article=article;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTxTva() {
		return txTva;
	}
	public void setTxTva(double txTva) {
		this.txTva = txTva;
	}


}
