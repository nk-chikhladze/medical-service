package com.project.demo.services;

import com.project.demo.domains.Schedule;
import com.project.demo.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	private final ScheduleRepository scheduleRepository;

	public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	@Override
	public Set<Schedule> getAllSchedules() {
		Set<Schedule> schedules = new HashSet<>();
		scheduleRepository.findAll().forEach(schedules::add);
		return schedules;
	}

	@Override
	public Schedule getScheduleById(String id) {
		return scheduleRepository.findById(id).get();
	}

	@Override
	public void saveSchedule(Schedule schedule) {
		scheduleRepository.save(schedule);
	}

	@Override
	public void deleteSchedule(Schedule schedule) {
		scheduleRepository.delete(schedule);
	}
}
