package edu.caensup.sio.eval2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.caensup.sio.eval2.models.Dog;
import edu.caensup.sio.eval2.models.Master;
import edu.caensup.sio.eval2.repositories.IDogDAO;

@Controller
@RequestMapping("/dog")
public class DogController {

	@Autowired
	private IDogDAO DogDAO;
	
	@GetMapping("/{id}/add")
	public String addDogMaster(ModelMap model, ModelMap masterID, @PathVariable int id) {
		masterID.put("masterID", id);
		model.put("dog", new Dog());
		return "/dogs/form";
		
	}
	
	@PostMapping("/{id}/add")
	public RedirectView addDogMaster(@ModelAttribute Dog dog, @PathVariable Master id) {
		dog.setMaster(id);
		DogDAO.save(dog);
		return new RedirectView("/master/{id}");
		
	}
	
}
