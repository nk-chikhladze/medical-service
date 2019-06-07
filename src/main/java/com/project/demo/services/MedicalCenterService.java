package com.project.demo.services;

import com.project.demo.domains.Doctor;
import com.project.demo.domains.MedicalCenter;

import java.util.Set;

public interface MedicalCenterService {
	Set<MedicalCenter> findAllCenters();
	MedicalCenter findCenterById(String id);
	MedicalCenter saveCenter(MedicalCenter center);
	void deleteCenter(MedicalCenter center);

	Set<Doctor> getDoctors(MedicalCenter center);
	void saveDoctor(MedicalCenter center);
	void deleteDoctor(MedicalCenter center, String id);
}
