package com.rafat.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rafat.dojosninjas.models.Dojo;
import com.rafat.dojosninjas.models.Ninja;
import com.rafat.dojosninjas.services.DojoNinjaService;

@Controller
public class HomeController {
	// Attributes
	private final DojoNinjaService dojoNinjaServ;

	// Constructors
	public HomeController(DojoNinjaService dojoNinjaServ) {
		this.dojoNinjaServ = dojoNinjaServ;
	}

	// GET Routes
	@GetMapping("/")
	public String index(Model model) {
		List<Dojo> dojos = dojoNinjaServ.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}

	// Display new Dojo form
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojos/newDojo.jsp";
	}

	// Display new Ninja form
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoNinjaServ.getAllDojos();
		model.addAttribute("dojos", dojos);

		return "ninjas/newNinja.jsp";
	}

	// Display all Ninjas in a dojo
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") long id, Model model) {
		Dojo dojo = dojoNinjaServ.findDojoById(id);
		model.addAttribute("dojo", dojo);

		return "dojos/show.jsp";
	}

	// POST routes

	// Create new Dojo
	@PostMapping("/dojos/new")
	// Valid and BindingResult validate form data
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		// Event handler for validation
		if (result.hasErrors()) {
			return "dojos/newDojo.jsp";
		} else {
			dojoNinjaServ.createDojo(dojo);

			return "redirect:/ninjas/new";
		}
	}

	// Create new Ninja
	@PostMapping("/ninjas/new")
	// Valid and BindingResult validate form data
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		// Event handler for validation
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoNinjaServ.getAllDojos();
			model.addAttribute("dojos", dojos);
			return "ninjas/newNinja.jsp";
		} else {
			dojoNinjaServ.createNinja(ninja);
			Long dojoNum = ninja.getDojo().getId();

			return "redirect:/dojos/" + dojoNum;
		}
	}

}
