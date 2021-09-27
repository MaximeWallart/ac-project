package com.AC.archipel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArchipelMapper implements RowMapper<Archipel>{
	
	public static final String BASE_SQL = "SELECT * FROM archipel";

	@Override
	public Archipel mapRow(ResultSet rs, int rowNum) throws SQLException {

		int id = rs.getInt("id");
		int idJoueur = rs.getInt("idJoueur");
		String nom = rs.getString("nom");
		String localisation = rs.getString("localisation");
		
		return new Archipel(id, idJoueur, nom, localisation);
	}
	
}
