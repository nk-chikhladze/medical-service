package com.project.demo.repositories;

import com.project.demo.domains.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, String> {
}
