package edu.caensup.sio.eval2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.caensup.sio.eval2.models.Master;
import edu.caensup.sio.eval2.repositories.IMasterDAO;

@Controller
@RequestMapping("/master")
public class MasterController {

	@Autowired
	private IMasterDAO MasterDAO;
	
	@GetMapping({"/index", ""})
	public String index(ModelMap model) {
		
		Iterable<Master> masters = MasterDAO.findAll(Sort.by(Direction.DESC, "lastname"));
		model.put("masters", masters);
		return "/masters/index";
		
	}
	
	@GetMapping("/add")
	public String addMaster(ModelMap model) {
		
		model.put("master", new Master());
		return "/masters/form";
		
	}
	
	@PostMapping("/add")
	public RedirectView addMaster(@ModelAttribute Master master) {
		
		MasterDAO.save(master);
		return new RedirectView("/master/index");
		
	}
	
	@GetMapping("/{idMaster}")
	public String infoMaster(ModelMap model, @PathVariable int idMaster) {
		
		MasterDAO.findById(idMaster).ifPresent(master -> model.put("master", master));
		return "/masters/info";
		
	}
	
}
