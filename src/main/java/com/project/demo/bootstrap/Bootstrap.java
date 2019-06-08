package com.project.demo.bootstrap;

import com.project.demo.domains.Doctor;
import com.project.demo.domains.MedicalCenter;
import com.project.demo.domains.Schedule;
import com.project.demo.domains.Specialty;
import com.project.demo.domains.User;
import com.project.demo.repositories.MedicalCenterRepository;
import com.project.demo.repositories.ScheduleRepository;
import com.project.demo.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final MedicalCenterRepository medicalCenterRepository;
	private final ScheduleRepository scheduleRepository;
	private final UserRepository userRepository;

	public Bootstrap(MedicalCenterRepository medicalCenterRepository, ScheduleRepository scheduleRepository, UserRepository userRepository) {
		this.medicalCenterRepository = medicalCenterRepository;
		this.scheduleRepository = scheduleRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//		loadMedicalCenters();
//		loadUsers();
//		loadSchedules();
	}

	private void loadMedicalCenters() {
		Set<Doctor> doctors_center_1 = new HashSet<>();

		doctors_center_1.add(Doctor.builder()
				.firstName("George")
				.lastName("Washington")
				.number("555-55-55")
				.specialty(Specialty.SPEC_1)
				.workExperience("8 years")
				.build());

		doctors_center_1.add(Doctor.builder()
				.firstName("Martin")
				.lastName("Lutter")
				.number("333-33-33")
				.specialty(Specialty.SPEC_2)
				.workExperience("6 years")
				.build());

		Set<Doctor> doctors_center_2 = new HashSet<>();

		MedicalCenter center_1 = MedicalCenter.builder()
				.title("Big Center")
				.description("Some text in here describing the big center history.")
				.doctorSet(doctors_center_1)
				.build();

		doctors_center_2.add(Doctor.builder()
				.firstName("Arthur")
				.lastName("Werewolf")
				.number("553-25-56")
				.specialty(Specialty.SPEC_1)
				.workExperience("7 years")
				.build());

		doctors_center_2.add(Doctor.builder()
				.firstName("Boris")
				.lastName("Boy")
				.number("323-22-33")
				.specialty(Specialty.SPEC_2)
				.workExperience("9 years")
				.build());

		MedicalCenter center_2 = MedicalCenter.builder()
				.title("Medium Center")
				.description("Some text in here describing the big center history.")
				.doctorSet(doctors_center_2)
				.build();

		medicalCenterRepository.save(center_1);
		medicalCenterRepository.save(center_2);
	}

	private void loadUsers() {
		User user_1 = User.builder()
				.username("t1")
				.password("p1")
				.build();

		User user_2 = User.builder()
				.username("t2")
				.password("p2")
				.build();

		userRepository.save(user_1);
		userRepository.save(user_2);
	}

	private void loadSchedules() {
		Schedule schedule_1 = Schedule.builder()
				.date(new Date(System.currentTimeMillis()))
				.doctor_id(medicalCenterRepository.findById("5cfa2fdccc08172fc8199f05").get()
						.getDoctorSet()
						.stream()
						.filter(doctor -> doctor.equals("George"))
						.findFirst()
						.orElse(null)
						.getFirstName())
				.user_id(userRepository.findById("5cfa304ecc081727901a55cf").get().getId())
				.build();

		Schedule schedule_2 = Schedule.builder()
				.date(new Date(System.currentTimeMillis()))
				.doctor_id(medicalCenterRepository.findById("5cfa2fdccc08172fc8199f05").get()
						.getDoctorSet()
						.stream()
						.filter(doctor -> doctor.getFirstName().equals("Martin"))
						.findFirst()
						.orElse(null)
						.getFirstName())
				.user_id(userRepository.findById("5cfa304ecc081727901a55cf").get().getId())
				.build();

		scheduleRepository.save(schedule_1);
		scheduleRepository.save(schedule_2);
	}
}
