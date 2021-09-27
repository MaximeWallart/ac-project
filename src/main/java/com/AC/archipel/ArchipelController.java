package com.AC.archipel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArchipelController {

	@Autowired
	ArchipelDao archipelDao;
	
	@RequestMapping(value = "/joueur/archipel", method = RequestMethod.PUT)
	public @ResponseBody void addArchipel(
											@RequestParam(value = "id")int id,
											@RequestParam(value = "idJoueur")int idJoueur,
											@RequestParam(value = "nom")String nom,
											@RequestParam(value = "localisation")String localisation
											){
	    archipelDao.insertArchipel(new Archipel(id, idJoueur, nom, localisation));
	}
}
