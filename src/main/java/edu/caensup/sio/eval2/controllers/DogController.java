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
import edu.caensup.sio.eval2.repositories.IMasterDAO;

@Controller
@RequestMapping("/dog")
public class DogController {

	@Autowired
	private IDogDAO DogDAO;
	
	@Autowired
	private IMasterDAO MasterDAO;
	
	@GetMapping("/{idMaster}/add")
	public String addDogMaster(ModelMap model, ModelMap masterID, @PathVariable int idMaster) {
		
		MasterDAO.findById(idMaster).ifPresent((master) -> {
			masterID.put("master", master);
		});
		
		model.put("dog", new Dog());
		return "/dogs/form";
		
	}
	
	@PostMapping("/{idMaster}/add")
	public RedirectView addDogMaster(@ModelAttribute Dog dog, @PathVariable int idMaster) {
		
		DogDAO.save(dog);
		return new RedirectView("/master/{idMaster}");
		
	}
	
	@GetMapping("/{idMaster}/delete/{idDog}")
	public RedirectView deleteDogMaster(@PathVariable int idMaster, @PathVariable int idDog) {
		
		DogDAO.findById(idDog).ifPresent(dog -> {
			DogDAO.delete(dog);
		});
		return new RedirectView("/master/{idMaster}");
		
	}
	
}
