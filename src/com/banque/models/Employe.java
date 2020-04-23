package com.banque.models;

public class Employe {
	private int id;
	private String nom;
	private String pernom;
	private String mail;
	private String motdepasse;
	
	public Employe(int id, String nom, String pernom, String mail,String motdepasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.pernom = pernom;
		this.mail = mail;
		this.motdepasse = motdepasse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPernom() {
		return pernom;
	}

	public void setPernom(String pernom) {
		this.pernom = pernom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String toString() {
		return "employe [id=" + id + ", nom=" + nom + ", pernom=" + pernom
				+ ", mail=" + mail + ", motdepasse=" + motdepasse + "]";
	}
	
	
}
