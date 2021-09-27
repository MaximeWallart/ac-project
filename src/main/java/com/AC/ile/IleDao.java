package com.AC.ile;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.AC.archipel.Archipel;
import com.AC.batiment.Batiment;
import com.AC.batiment.BatimentDao;
import com.AC.batiment.BatimentType;
import com.AC.joueur.Joueur;
import com.AC.nature.Bois;
import com.AC.nature.Foret;
import com.AC.nature.Nature;
import com.AC.nature.NatureDao;
import com.AC.nature.NatureType;

@Repository
@Transactional
public class IleDao extends JdbcDaoSupport {
	
	@Autowired
	public IleDao(DataSource datasource) {
		this.setDataSource(datasource);
	}
	
	public void generateRandomIle(Archipel a) {
		Ile res = new Ile(a.getId(),"jsp","là");
		insertIle(res);
		res = findIle(a);
		BatimentDao bDao = new BatimentDao(this.getDataSource());
		NatureDao nDao = new NatureDao(this.getDataSource());
		for(int i=0; i<30; i++) {
			if(Math.random()>0.5) {
				System.out.println(res.getId());
				System.out.println(BatimentType.Cinema);
				Batiment b = new Batiment(res.getId(),BatimentType.Cinema);
				bDao.insertBatiment(b);
			}
			else {
				Nature n = new Nature(res.getId(),new Foret(2500, "jsp", Bois.Chêne));
				nDao.insertNature(n);
			}
		}
	}
	
	public Ile findIle(int id) {
		String sql = IleMapper.BASE_SQL + " WHERE id=?";
		IleMapper mapper = new IleMapper();
		Object[] param = {id};
		try {
			@SuppressWarnings("deprecation")
			List<Ile> res = this.getJdbcTemplate().query(sql, param, mapper);
			return res.get(0);
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Ile findIle(Archipel a) {
		String sql = IleMapper.BASE_SQL + " WHERE idArchipel=?";
		IleMapper mapper = new IleMapper();
		Object[] param = {a.getId()};
		System.out.println("id archipel : " + a.getId());
		try {
			@SuppressWarnings("deprecation")
			List<Ile> res = this.getJdbcTemplate().query(sql, param, mapper);
			Ile oui = res.get(0);
			System.out.println(oui);
			return res.get(0);
		}
		catch (Exception e) {
			System.out.println("exception sur findIle");
			return null;
		}
	}
	
	public Ile findIle(Ile i) {
		String sql = IleMapper.BASE_SQL + " WHERE idArchipel=? AND nom=? AND localisation=?";
		IleMapper mapper = new IleMapper();
		Object[] param = {i.getIdArchipel(), i.getNom(), i.getLocalisation()};
		try {
			@SuppressWarnings("deprecation")
			List<Ile> res = this.getJdbcTemplate().query(sql, param, mapper);
			return res.get(0);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public void insertIle(Ile i) {
		if(findIle(i)==null) {
			System.out.println("ça insère ici");
			String sql = "INSERT INTO ile(idArchipel, nom, localisation) VALUES (?, ?, ?)";
			getJdbcTemplate().update(sql, new Object[] {
					i.getIdArchipel(), i.getNom(), i.getLocalisation()
			});
			System.out.println(sql + " | " + i.getIdArchipel() + "," + i.getNom() + "," + i.getLocalisation() );
		}
		else {
			System.out.println("j'ai chié");
		}
	}
	
	public void modifyIle(Ile i) {
		if(findIle(i.getId())!=null) {
			String sql = "UPDATE ile SET"
					+ "idArchipel = ?,"
					+ "nom = ?,"
					+ "localisation = ? "
					+ "WHERE id = ? ;";
			
			getJdbcTemplate().update(sql, new Object[] {
					i.getIdArchipel(), i.getNom(), i.getLocalisation(), i.getId()
			});
		}
		else {
			System.out.println("Ile inexistante");
		}
	}

}
