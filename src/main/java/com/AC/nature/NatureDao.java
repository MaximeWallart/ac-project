package com.AC.nature;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.AC.archipel.Archipel;
import com.AC.batiment.Batiment;

@Repository
@Transactional
public class NatureDao extends JdbcDaoSupport{
	
	@Autowired
	public NatureDao(DataSource datasource) {
		this.setDataSource(datasource);
	}
	
	public Nature findNature(int id) {
		String sql = NatureMapper.BASE_SQL + " WHERE id=?";
		NatureMapper mapper = new NatureMapper();
		Object[] param = {id};
		try {
			@SuppressWarnings("deprecation")
			Nature res = (Nature) this.getJdbcTemplate().query(sql, param, mapper);
			return res;
		}
		catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void insertNature(Nature n) {
		String sql = "INSERT INTO nature(idIle, nature) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[] {
				n.getIdIle(), n.getNature().toString()
		});
	}
	
	public void modifyNature(Nature n) {
		if(findNature(n.getId())!=null) {
			String sql = "UPDATE nature SET"
					+ "idIle = ?,"
					+ "nature = ?,"
					+ "WHERE id = ? ;";
			
			getJdbcTemplate().update(sql, new Object[] {
					n.getIdIle(), n.getNature(), n.getId()
			});
		}
		else {
			System.out.println("Nature inexistante");
		}
	}

}
