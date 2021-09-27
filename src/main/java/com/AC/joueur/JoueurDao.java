package com.AC.joueur;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.AC.archipel.Archipel;

@Repository
@Transactional
public class JoueurDao extends JdbcDaoSupport {

	@Autowired
	public JoueurDao(DataSource datasource) {
		this.setDataSource(datasource);
	}

	public Joueur findJoueur(int id) {
		String sql = JoueurMapper.BASE_SQL + " WHERE id=?";
		JoueurMapper mapper = new JoueurMapper();
		Object[] param = { id };
		try {
			@SuppressWarnings("deprecation")
			List<Joueur> res = this.getJdbcTemplate().query(sql, param, mapper);
			return res.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	public Joueur findJoueur(Joueur j) {
		String sql = JoueurMapper.BASE_SQL + " WHERE nom =? AND prenom=? AND mail=? ";
		JoueurMapper mapper = new JoueurMapper();
		Object[] param = { j.getNom(), j.getPrenom(), j.getMail() };
		try {
			@SuppressWarnings("deprecation")
			List<Joueur> res = this.getJdbcTemplate().query(sql, param, mapper);
			return res.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	public void insertJoueur(Joueur j) {
		if (findJoueur(j) == null) {
			String sql = "INSERT INTO joueur(nom, prenom, mail) VALUES (?, ?, ?)";
			getJdbcTemplate().update(sql, new Object[] { j.getNom(), j.getPrenom(), j.getMail() });
		}
		else {
		}
	}

	public void modifyJoueur(Joueur j) {
		if (findJoueur(j.getId()) != null) {
			String sql = "UPDATE joueur SET" + "nom = ?," + "prenom = ?," + "mail = ? " + "WHERE id = ? ;";

			getJdbcTemplate().update(sql, new Object[] { j.getNom(), j.getPrenom(), j.getMail(), j.getId() });
		} else {
			System.out.println("Joueur inexistant");
		}
	}

}
