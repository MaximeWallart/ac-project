package com.AC.ile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IleController {

	@Autowired
	IleDao ileDao;
	
	@RequestMapping(value = "/joueur/archipel/ile", method = RequestMethod.PUT)
	public @ResponseBody void addIle(
											@RequestParam(value = "id")int id,
											@RequestParam(value = "idArchipel")int idArchipel,
											@RequestParam(value = "nom")String nom,
											@RequestParam(value = "localisation")String localisation
											){
	    ileDao.insertIle(new Ile(id, idArchipel, nom, localisation));
	}
}
