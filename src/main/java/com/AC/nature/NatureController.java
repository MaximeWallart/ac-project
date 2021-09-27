package com.AC.nature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NatureController {
	
	@Autowired
	NatureDao natureDao;
	
	@RequestMapping(value = "/joueur/archipel/ile/nature", method = RequestMethod.PUT)
	public @ResponseBody void addNature(
											@RequestParam(value = "id")int id,
											@RequestParam(value = "idIle")int idIle,
											@RequestParam(value = "batiment")NatureType nature
											){
	    natureDao.insertNature(new Nature(id, idIle, nature));
	}

}
