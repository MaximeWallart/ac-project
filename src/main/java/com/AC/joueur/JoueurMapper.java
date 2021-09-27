package com.AC.joueur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class JoueurMapper implements RowMapper<Joueur>{
	
	public static final String BASE_SQL = "SELECT * FROM joueur";

	@Override
	public Joueur mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String mail = rs.getString("mail");
		
		return new Joueur(id, nom, prenom, mail);
	}
	
	

}
