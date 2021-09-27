package com.AC.batiment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BatimentController {

	@Autowired
	BatimentDao batimentDao;
	
	@RequestMapping(value = "/joueur/archipel/ile/batiment", method = RequestMethod.PUT)
	public @ResponseBody void addBatiment(
											@RequestParam(value = "id")int id,
											@RequestParam(value = "idIle")int idIle,
											@RequestParam(value = "batiment")BatimentType batiment
											){
	    batimentDao.insertBatiment(new Batiment(id, idIle, batiment));
	}
}
