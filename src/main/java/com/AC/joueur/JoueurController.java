package com.AC.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoueurController {
	
	@Autowired
	JoueurDao joueurDao;
	
	@RequestMapping(value = "/joueur", method = RequestMethod.PUT)
	public @ResponseBody void addJoueur(
											@RequestParam(value = "id")int id,
											@RequestParam(value = "nom")String nom,
											@RequestParam(value = "prenom")String prenom,
											@RequestParam(value = "mail")String mail
											){
	    joueurDao.insertJoueur(new Joueur(id, nom, prenom, mail));
	}

}
