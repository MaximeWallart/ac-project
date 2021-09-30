package com.AC.nature;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NatureMapper implements RowMapper<Nature> {
	
	public static final String BASE_SQL = "SELECT * FROM nature";

	@Override
	public Nature mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		int idIle = rs.getInt("idIle");
		NatureType nature = null;
		try {
			nature = Foret.toForet(rs.getString("nature"));
		}
		catch(Exception e){
			try {
				nature = Plage.toPlage(rs.getString("nature"));
			}catch(Exception e2) {
				System.out.println("e : " + e2.getMessage());
			}
		}
		return new Nature(id, idIle, nature);
	}

}
