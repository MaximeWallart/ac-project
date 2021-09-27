package com.AC.nature;

public class Nature {
	
	private int id;
	private int idIle;
	private NatureType nature;
	
	public Nature(int id, int idIle, NatureType nature) {
		super();
		this.id = id;
		this.idIle = idIle;
		this.nature = nature;
	}
	
	public Nature(int idIle, NatureType nature) {
		super();
		this.idIle = idIle;
		this.nature = nature;
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
	public NatureType getNature() {
		return nature;
	}
	public void setNature(NatureType nature) {
		this.nature = nature;
	}
	
}
