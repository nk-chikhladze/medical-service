package com.project.demo.controllers;

import com.project.demo.domains.MedicalCenter;
import com.project.demo.services.MedicalCenterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

public class MedicalCenterController {
	private final MedicalCenterService medicalCenterService;

	public MedicalCenterController(MedicalCenterService medicalCenterService) {
		this.medicalCenterService = medicalCenterService;
	}

	@GetMapping("api/centers")
	public String getCenters(Model model) {
		model.addAttribute("centers", medicalCenterService.findAllCenters());
		return "index";
	}

	@GetMapping("api/centers/{id}")
	public String getCenterById(Model model, @PathVariable String id) {
		model.addAttribute("center", medicalCenterService.findCenterById(id));
		return "index";
	}

	@PutMapping("api/centers")
	public void saveCenter(@RequestBody MedicalCenter medicalCenter) {
		medicalCenterService.saveCenter(medicalCenter);
	}

	@DeleteMapping("api/centers")
	public void deleteCenter(@RequestBody MedicalCenter medicalCenter) {
		medicalCenterService.deleteCenter(medicalCenter);
	}




}
