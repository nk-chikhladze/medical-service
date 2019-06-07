package com.project.demo.services;

import com.project.demo.domains.Schedule;

import java.util.Set;

public interface ScheduleService {
	Set<Schedule> getAllSchedules();
	Schedule getScheduleById(String id);
	void saveSchedule(Schedule schedule);
	void deleteSchedule(Schedule schedule);
}
