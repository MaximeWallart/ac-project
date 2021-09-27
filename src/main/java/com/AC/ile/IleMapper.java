package com.AC.ile;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IleMapper implements RowMapper<Ile> {
	
	public static final String BASE_SQL = "SELECT * FROM ile";

	@Override
	public Ile mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		int idArchipel = rs.getInt("idArchipel");
		String nom = rs.getString("nom");
		String localisation = rs.getString("localisation");
		
		return new Ile(id, idArchipel, nom, localisation);
	}
	
	

}
