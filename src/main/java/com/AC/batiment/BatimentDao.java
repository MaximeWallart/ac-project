package com.AC.batiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.AC.archipel.Archipel;
import com.AC.ile.Ile;
import com.AC.nature.Nature;
import com.AC.nature.NatureMapper;

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
	
	public List<Batiment> allBatiment(int idIle){
		List<Batiment> res;
		String sql = BatimentMapper.BASE_SQL + " WHERE idile = ?";
		BatimentMapper mapper = new BatimentMapper();
		Object[] param = {idIle};
		try {
			res = this.getJdbcTemplate().query(sql, param, mapper);
			return res;
		}
		catch (Exception e) {
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

	public void createRandomBatiment(int id) {
		Batiment b = new Batiment(id, null);
		if(Math.random()<0.3) {
			b.setBatiment(BatimentType.Cinema);
		}
		else if(Math.random()<0.5) {
			b.setBatiment(BatimentType.Ecole);
		}
		else {
			b.setBatiment(BatimentType.Magasin);
		}
		insertBatiment(b);
	}
}
