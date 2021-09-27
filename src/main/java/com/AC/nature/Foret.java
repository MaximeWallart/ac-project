package com.AC.nature;

public class Foret implements NatureType{
	
	private int superficie;
	private String nom;
	private Bois espece;
	
	public Foret(int superficie, String nom, Bois espece) {
		super();
		this.superficie = superficie;
		this.nom = nom;
		this.espece = espece;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Bois getEspece() {
		return espece;
	}

	public void setEspece(Bois espece) {
		this.espece = espece;
	}

	@Override
	public String whatType() {
		return "Forêt";
	}
	
	public static Foret toForet(String s) {
		String[] strings = s.substring(1,s.length()-1).split(",");
		Foret res = null;
		for(int i=0;i<strings.length;i++) {
			if(i==0) {
				res.setSuperficie(Integer.parseInt(strings[i]));
			}
			else if(i==1) {
				res.setNom(strings[i]);
			}
			else {
				res.setEspece(Bois.valueOf(strings[i]));
			}
		}
		return res;
	}
	
}
