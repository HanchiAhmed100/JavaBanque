package com.banque.models;
import java.util.Date;


public class Compte {
	private int id;
	private int numcompte;
	private Client titulaire;
	private float solde;
	private String devise;
	private Date date_creation;
	
	

	public Compte(int id, int numcompte, Client titulaire, float solde,String devise, Date date_creation) {
		super();
		this.id = id;
		this.numcompte = numcompte;
		this.titulaire = titulaire;
		this.solde = solde;
		this.devise = devise;
		this.date_creation = date_creation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumcompte() {
		return numcompte;
	}
	public void setNumcompte(int numcompte) {
		this.numcompte = numcompte;
	}
	public Client getTitulaire() {
		return titulaire;
	}
	public void setTitulaire(Client titulaire) {
		this.titulaire = titulaire;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public String toString() {
		return "compte [id=" + id + ", numcompte=" + numcompte + ", titulaire="
				+ titulaire + ", solde=" + solde + ", devise=" + devise
				+ ", date_creation=" + date_creation + "]";
	}

	
}
