package com.AC.batiment;

public class Batiment {
	
	private int id;
	private int idIle;
	private BatimentType batiment;
	
	public Batiment(int idIle, BatimentType batiment) {
		super();
		this.idIle = idIle;
		this.batiment = batiment;
	}

	public Batiment(int id, int idIle, BatimentType batiment) {
		super();
		this.id = id;
		this.idIle = idIle;
		this.batiment = batiment;
	}
	
	public String toString() {
		return this.idIle + ":Batiment[" + this.id + "; " + this.batiment.name() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdIle() {
		return idIle;
	}

	public void setIdIle(int idIle) {
		this.idIle = idIle;
	}

	public BatimentType getBatiment() {
		return batiment;
	}

	public void setBatiment(BatimentType batiment) {
		this.batiment = batiment;
	}
	
	
}
