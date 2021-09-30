package com.AC.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.AC.archipel.Archipel;
import com.AC.archipel.ArchipelDao;
import com.AC.ile.Ile;
import com.AC.ile.IleDao;
import com.AC.joueur.Joueur;
import com.AC.joueur.JoueurDao;

@Controller
public class MainController {
	
	@Autowired
	private JoueurDao joueurDao;
	
	@Autowired
	private ArchipelDao archipelDao;
	
	@Autowired
	private IleDao ileDao;
	
	@GetMapping("/")
	public String inscription(Model model) {
		return "inscription";
	}
	
	@PostMapping("/creaArchipel")
	public String creaArchipel(@RequestParam("nom") String nom,
							   @RequestParam("prenom") String prenom,
							   @RequestParam("mail") String mail,
							   HttpServletRequest requete,
							   Model model) {
		Joueur j = new Joueur(nom, prenom, mail);
		joueurDao.insertJoueur(j);
		j = joueurDao.findJoueur(j);
		requete.getSession().setAttribute("joueur", j);
		model.addAttribute("joueur", j);
		if(archipelDao.findArchipel(j)!=null) {
			int[] idIles = ileDao.findAllIlesId(archipelDao.findArchipel(j).getId());
			List<Object> show = new ArrayList<Object>();
			for(int i=0; i<idIles.length; i++) {
				System.out.println(ileDao.allChildren(idIles[i]));
				show.addAll(ileDao.allChildren(idIles[i]));
			}
			model.addAttribute("show", show);
			return "map";
		}
		else {
			return "creaArchipel";
		}
	}
	
	@PostMapping("/changementIle")
	public String changementArchipel(@RequestParam("nom") String nom,
									 @RequestParam("childrens") List<Object> childrens,
									 Model model) {
		System.out.println(nom);
		System.out.println(childrens);
		return "map";
	}
	
	@PostMapping(value="/affichageArchipel",
				consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String affichagev2(@ModelAttribute RequestArchipel rArchi,
									HttpServletRequest requete,
									Model model) {
		
		int idArchipel = -1;
		if(rArchi.getNom() != null && rArchi.getLoca()!=null) {
			Archipel a = new Archipel(((Joueur)requete.getSession().getAttribute("joueur")).getId(),rArchi.getNom(), rArchi.getLoca());
			archipelDao.insertArchipel(a);
			idArchipel = archipelDao.findArchipel(a).getId();
			for(int i=0; i<rArchi.getIles().length; i++) {
				ileDao.insertIle(new Ile(idArchipel,rArchi.getIles()[i], rArchi.getLoca()));
			}
		}
		else {
			idArchipel = archipelDao.findArchipel((Joueur)requete.getSession().getAttribute("joueur")).getId();
		}
		int[] idIles = ileDao.findAllIlesId(idArchipel);
		List<Object> show = new ArrayList<Object>();
		for(int i=0; i<idIles.length; i++) {
			System.out.println(ileDao.allChildren(idIles[i]));
			show.addAll(ileDao.allChildren(idIles[i]));
		}
		model.addAttribute("show", show);
		return "map";
	}
	
	//@PostMapping("/affichageArchipel")
	public String affichageArchipel(@RequestParam(required = false, value = "nom") String nom,
									@RequestParam(required = false, value = "loca") String loca,
									@RequestParam(required = false, value = "ile0_nom") String ile0,
									@RequestParam(required = false, value = "ile1_nom") String ile1,
									@RequestParam(required = false, value = "ile2_nom") String ile2,
									@RequestParam(required = false, value = "ile3_nom") String ile3,
									@RequestParam(required = false, value = "ile4_nom") String ile4,
									HttpServletRequest requete,
									Model model) {
		
		int idArchipel = -1;
		if(nom != null && loca!=null) {
			Archipel a = new Archipel(((Joueur)requete.getSession().getAttribute("joueur")).getId(),nom, loca);
			archipelDao.insertArchipel(a);
			idArchipel = archipelDao.findArchipel(a).getId();
			if(ile0!=null && !ile0.isEmpty()) {
				ileDao.insertIle(new Ile(idArchipel,ile0, loca));
			}
			if(ile1!=null && !ile1.isEmpty()) {
				ileDao.insertIle(new Ile(idArchipel,ile1, loca));
			}
			if(ile2!=null && !ile2.isEmpty()) {
				ileDao.insertIle(new Ile(idArchipel,ile2, loca));
			}
			if(ile3!=null && !ile3.isEmpty()) {
				ileDao.insertIle(new Ile(idArchipel,ile3, loca));
			}
			if(ile4!=null && !ile4.isEmpty()) {
				ileDao.insertIle(new Ile(idArchipel,ile4, loca));
			}
		}
		else {
			idArchipel = archipelDao.findArchipel((Joueur)requete.getSession().getAttribute("joueur")).getId();
		}
		int[] idIles = ileDao.findAllIlesId(idArchipel);
		List<Object> show = new ArrayList<Object>();
		for(int i=0; i<idIles.length; i++) {
			System.out.println(ileDao.allChildren(idIles[i]));
			show.addAll(ileDao.allChildren(idIles[i]));
		}
		model.addAttribute("show", show);
		return "map";
	}
	
	@PostMapping("/modificationIle")
	public String modificationIle(@RequestParam("id") int id,
								  Model model) {
		model.addAttribute("childrens", ileDao.allChildren(id));
		model.addAttribute("id", id);
		return "modificationIle";
	}
	

}
