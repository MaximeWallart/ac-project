package com.AC.nature;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.AC.archipel.Archipel;
import com.AC.batiment.Batiment;
import com.AC.ile.Ile;

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
	
	public List<Nature> allNature(int idIle){
		List<Nature> res;
		String sql = NatureMapper.BASE_SQL + " WHERE idIle = ?";
		NatureMapper mapper = new NatureMapper();
		Object[] param = {idIle};
		try {
			res = this.getJdbcTemplate().query(sql, param, mapper);
			return res;
		}
		catch (Exception e) {
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

	public void createRandomNature(int id) {
		Nature n = new Nature(id, null);
		if(Math.random()>0.5) {
			n.setNature(new Foret(((int)Math.random()*1000),"dsfgfdb",Bois.Hêtre));
		}
		else {
			n.setNature(new Plage("fdnvjsfdv"));
		}
		insertNature(n);
	}

}
