package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;
import fr.adaming.services.IEtudiantService;

@Controller
@RequestMapping("/ecole")
public class EtudiantCtrl {

	@Autowired
	private IEtudiantService etudiantService;
	public void setFormService(IEtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}
	
	
	private Formateur f;
	
	
	@PostConstruct
	public void init() {
		this.f = new Formateur(1, "a", "a");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		df.setLenient(false);
		
		// la methode registerCustomEditor configure la conversion du param recu au type de l'attribu
		// l'objet CustomDateEditor sert a lier la date recue comme param de la requete a l'attr de l'objet Etudiant
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}
	
	
	
	
	
//	@RequestMapping(value="login", method=RequestMethod.GET)
//	public String getIndex(Model m) {
//		m.addAttribute("log", new Formateur());
//		return "../login";
//	}
//	
//	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String postIndex(Model m, @ModelAttribute Formateur log) {
//		System.out.println("log in requested : " + log);
//		return "dashboard";
//	}
	
	
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView afficheList() {
		List<Etudiant> liste = etudiantService.getAll(this.f);
		
		return new ModelAndView("dashboard", "etudiants", liste);
	}
	
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public ModelAndView getAdd() {
		Etudiant e = new Etudiant();
		return new ModelAndView("add", "etudiant", e);
	}
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView postAdd(ModelMap model, @ModelAttribute Etudiant etudiant) {
		
		System.out.println("add etudiant e : " + etudiant);
		
		int res = etudiantService.add(etudiant, this.f);
		
		if(res == 0) {
			System.out.println("cannot add etudiant...");
			return new ModelAndView("redirect:add");
		}
		
		Etudiant e = new Etudiant();
		return new ModelAndView("add", "etudiant", e);
	}
	
	
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView getDel() {
		return new ModelAndView("delete", "etudiant", new Etudiant());
	}
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public ModelAndView postDel(ModelMap model, @ModelAttribute Etudiant etudiant) {
		
		System.out.println("del etudiant id : " + etudiant);
		
		int res = etudiantService.delete(etudiant, this.f);
		
		if(res == 0) {
			System.out.println("cannot delete etudiant with id : " + etudiant.getId());
			return new ModelAndView("delete", "etudiant", etudiant);
		}
		return new ModelAndView("delete", "etudiant", new Etudiant());
	}
}
