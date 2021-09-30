package com.AC.nature;

public class Plage implements NatureType{
	
	private String nom;
	
	public Plage(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return "[" + this.nom + "]";
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String whatType() {
		return "Plage";
	}
	
	public static Plage toPlage(String s) {
		s = s.substring(1,s.length()-1);
		return new Plage(s);
	}

}
