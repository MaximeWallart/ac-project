package com.AC.ile;

public class Ile {
	
	private int id;
	private int idArchipel;
	private String nom;
	private String localisation;
	
	public Ile(int idArchipel, String nom, String localisation) {
		super();
		this.idArchipel = idArchipel;
		this.nom = nom;
		this.localisation = localisation;
	}

	public Ile(int id, int idArchipel, String nom, String localisation) {
		super();
		this.id = id;
		this.idArchipel = idArchipel;
		this.nom = nom;
		this.localisation = localisation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdArchipel() {
		return idArchipel;
	}

	public void setIdArchipel(int idArchipel) {
		this.idArchipel = idArchipel;
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
