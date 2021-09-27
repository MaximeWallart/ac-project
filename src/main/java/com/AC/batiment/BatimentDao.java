package com.AC.batiment;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.AC.archipel.Archipel;

@Repository
@Transactional
public class BatimentDao extends JdbcDaoSupport {
	
	@Autowired
	public BatimentDao(DataSource datasource) {
		this.setDataSource(datasource);
	}
	
	public Batiment findBatiment(int id) {
		String sql = BatimentMapper.BASE_SQL + " WHERE id=?";
		BatimentMapper mapper = new BatimentMapper();
		Object[] param = {id};
		try {
			@SuppressWarnings("deprecation")
			Batiment res = (Batiment) this.getJdbcTemplate().query(sql, param, mapper);
			return res;
		}
		catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void insertBatiment(Batiment b) {
		String sql = "INSERT INTO batiment(idIle, batiment) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[] {
				b.getIdIle(), b.getBatiment().toString()
		});
	}
	
	public void modifyBatiment(Batiment b) {
		if(findBatiment(b.getId())!=null) {
			String sql = "UPDATE batiment SET"
					+ "idIle = ?,"
					+ "batiment = ?,"
					+ "WHERE id = ? ;";
			
			getJdbcTemplate().update(sql, new Object[] {
					b.getIdIle(), b.getBatiment(), b.getId()
			});
		}
		else {
			System.out.println("Batiment inexistant");
		}
	}
}
