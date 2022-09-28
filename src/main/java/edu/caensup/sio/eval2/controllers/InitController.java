package edu.caensup.sio.eval2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.caensup.sio.eval2.models.Dog;
import edu.caensup.sio.eval2.models.Master;
import edu.caensup.sio.eval2.repositories.IDogDAO;
import edu.caensup.sio.eval2.repositories.IMasterDAO;

@Controller
@RequestMapping("/init/")
public class InitController {

	@Autowired
	private IMasterDAO masterDAO;
	
	@Autowired
	private IDogDAO dogDAO;
	
	@RequestMapping("master")
	public @ResponseBody String initMasterAction() {
		
		masterDAO.save(new Master("J", "Doe"));
		masterDAO.save(new Master("A", "Smith"));
		return "masters ajoutées";
		
	}
	
	@GetMapping("addDog/{idMaster}/{name}")
	public @ResponseBody String addDog(@PathVariable int idMaster, @PathVariable String name) {
		
		Dog dog = new Dog(name);
		masterDAO.findById(idMaster).ifPresent((master) -> {
			
			dog.setMaster(master);
			dogDAO.save(dog);
			
		});
		
		return "dog ajouté";
		
	}
	
}
