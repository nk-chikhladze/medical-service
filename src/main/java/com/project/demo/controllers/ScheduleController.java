package com.project.demo.controllers;

import com.project.demo.domains.Schedule;
import com.project.demo.services.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ScheduleController {

	private final ScheduleService scheduleService;

	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@GetMapping("api/schedules")
	public String getSchedules(Model model) {
		model.addAttribute("schedules", scheduleService.getAllSchedules());
		return "index";
	}

	@GetMapping("api/schedules/{id}")
	public String getScheduleById(Model model, @PathVariable String id) {
		model.addAttribute("schedule", scheduleService.getScheduleById(id));
		return "index";
	}

	@PutMapping("api/schedules")
	public void saveSchedule(@RequestBody Schedule schedule) {
		scheduleService.saveSchedule(schedule);
	}

	@DeleteMapping("api/schedules")
	public void deleteSchedule(@RequestBody Schedule schedule) {
		scheduleService.deleteSchedule(schedule);
	}
}
