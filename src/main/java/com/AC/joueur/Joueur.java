package com.AC.joueur;

public class Joueur {
	
	private int id;
	private String prenom;
	private String nom;
	private String mail;
	
	public Joueur(int id, String prenom, String nom, String mail) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
	}

	public Joueur(String prenom, String nom, String mail) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
