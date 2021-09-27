package com.AC.batiment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BatimentMapper implements RowMapper<Batiment>{
	
	public static final String BASE_SQL = "SELECT * FROM batiment";

	@Override
	public Batiment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		int idIle = rs.getInt("idIle");
		BatimentType batiment = BatimentType.valueOf(rs.getString("batiment"));
		
		return new Batiment(id, idIle, batiment);
	}

}
