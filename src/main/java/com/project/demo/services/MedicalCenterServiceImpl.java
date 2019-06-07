package com.project.demo.services;

import com.project.demo.domains.Doctor;
import com.project.demo.domains.MedicalCenter;
import com.project.demo.repositories.MedicalCenterRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MedicalCenterServiceImpl implements MedicalCenterService {

	private final MedicalCenterRepository medicalCenterRepository;

	public MedicalCenterServiceImpl(MedicalCenterRepository medicalCenterRepository) {
		this.medicalCenterRepository = medicalCenterRepository;
	}


	@Override
	public Set<MedicalCenter> findAllCenters() {
		Set<MedicalCenter> centers = new HashSet<>();
		medicalCenterRepository.findAll().forEach(centers::add);
		return centers;
	}

	@Override
	public MedicalCenter findCenterById(String id) {
		return medicalCenterRepository.findById(id).get();
	}

	@Override
	public MedicalCenter saveCenter(MedicalCenter center) {
		return medicalCenterRepository.save(center);
	}

	@Override
	public void deleteCenter(MedicalCenter center) {
		medicalCenterRepository.delete(center);
	}

	@Override
	public Set<Doctor> getDoctors(MedicalCenter center) {
		return center.getDoctorSet();
	}

	@Override
	public void saveDoctor(MedicalCenter center) {
		medicalCenterRepository.findById(center.getId()).get().getDoctorSet().clear();
		medicalCenterRepository.findById(center.getId()).get().getDoctorSet().addAll(center.getDoctorSet());
	}

	@Override
	public void deleteDoctor(MedicalCenter medicalCenter, String id) {
		Set<Doctor> set = medicalCenterRepository.findById(medicalCenter.getId()).get().getDoctorSet();
		set.forEach(doctor -> {
			if(doctor.getId() == id){
				set.remove(doctor);
			}
		});
	}
}
