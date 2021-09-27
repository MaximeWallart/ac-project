package com.AC.archipel;

public class Archipel {
	
	private int id;
	private int idJoueur;
	private String nom;
	private String localisation;
	
	public Archipel(int idJoueur, String nom, String localisation) {
		super();
		this.idJoueur = idJoueur;
		this.nom = nom;
		this.localisation = localisation;
	}

	public Archipel(int id, int idJoueur, String nom, String localisation) {
		super();
		this.id = id;
		this.idJoueur = idJoueur;
		this.nom = nom;
		this.localisation = localisation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
}
