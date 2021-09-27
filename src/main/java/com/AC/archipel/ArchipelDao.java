package com.AC.archipel;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.AC.ile.IleDao;
import com.AC.joueur.Joueur;

@Repository
@Transactional
public class ArchipelDao extends JdbcDaoSupport {

	@Autowired
	public ArchipelDao(DataSource datasource) {
		this.setDataSource(datasource);
	}

	public void generateRandomArchipel(Joueur j) {
		System.out.println("nom joueur" + j.getNom());
		Archipel res = new Archipel(j.getId(), "Maldives", "ici");
		insertArchipel(res);
		res = findArchipel(j);
		System.out.println(res.getNom());
		IleDao iDao = new IleDao(this.getDataSource());
		for (int i = 0; i < 30; i++) {
			if (Math.random() > 0.2) {
				iDao.generateRandomIle(res);
			}
		}
	}

	public Archipel findArchipel(int id) {
		String sql = ArchipelMapper.BASE_SQL + " WHERE id=?";
		ArchipelMapper mapper = new ArchipelMapper();
		Object[] param = { id };
		try {
			@SuppressWarnings("deprecation")
			Archipel res = (Archipel) this.getJdbcTemplate().query(sql, param, mapper);
			return res;
		} catch (Exception e) {
			return null;
		}
	}

	public Archipel findArchipel(Joueur j) {
		String sql = ArchipelMapper.BASE_SQL + " WHERE idJoueur=?";
		ArchipelMapper mapper = new ArchipelMapper();
		Object[] param = { j.getId() };
		try {
			@SuppressWarnings("deprecation")
			List<Archipel> res = this.getJdbcTemplate().query(sql, param, mapper);
			return res.get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Archipel findArchipel(Archipel a) {
		String sql = ArchipelMapper.BASE_SQL + " WHERE idJoueur=? AND nom=? AND localisation=?";
		ArchipelMapper mapper = new ArchipelMapper();
		Object[] param = { a.getIdJoueur(), a.getNom(), a.getLocalisation() };
		try {
			@SuppressWarnings("deprecation")
			List<Archipel> res = this.getJdbcTemplate().query(sql, param, mapper);
			return res.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	public void insertArchipel(Archipel a) {
		if(findArchipel(a)==null) {
			System.out.println("insertion de l'archipel");
			String sql = "INSERT INTO archipel(idJoueur, nom, localisation) VALUES(?, ?, ?)";
			getJdbcTemplate().update(sql, new Object[] {a.getIdJoueur(), a.getNom(), a.getLocalisation()});
		}
	}

	public void modifyArchipel(Archipel a) {
		if (findArchipel(a.getId()) != null) {
			String sql = "UPDATE archipel SET" + "idJoueur = ?," + "nom = ?," + "localisation = ? " + "WHERE id = ? ;";

			getJdbcTemplate().update(sql, new Object[] { a.getIdJoueur(), a.getNom(), a.getLocalisation(), a.getId() });
		} else {
			System.out.println("Archipel inexistant");
		}
	}
}
