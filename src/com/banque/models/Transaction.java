package com.banque.models;

import java.util.Date;

public class Transaction {
	private int id;
	private String type;
	private Compte emetteur;
	private Compte beneficiaire;
	private Date date_transaction;
	private Employe responsable;
	
	public Transaction(int id, String type, Compte emetteur,Compte beneficiaire, Date date_transaction, Employe responsable) {
		super();
		this.id = id;
		this.type = type;
		this.emetteur = emetteur;
		this.beneficiaire = beneficiaire;
		this.date_transaction = date_transaction;
		this.responsable = responsable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Compte getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(Compte emetteur) {
		this.emetteur = emetteur;
	}
	public Compte getBeneficiaire() {
		return beneficiaire;
	}
	public void setBeneficiaire(Compte beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	public Date getDate_transaction() {
		return date_transaction;
	}
	public void setDate_transaction(Date date_transaction) {
		this.date_transaction = date_transaction;
	}
	public Employe getResponsable() {
		return responsable;
	}
	public void setResponsable(Employe responsable) {
		this.responsable = responsable;
	}
}	
