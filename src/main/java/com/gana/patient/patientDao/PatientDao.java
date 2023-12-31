package com.gana.patient.patientDao;

import java.util.List;

import com.gana.patientdto.Patient;

public interface PatientDao {

	void addPatient(Patient patient);

	List<Patient> fetchAll();

	String updatePatient(Patient patient, int id);

	String deletePatient(int id);

	Patient findById(int id);
		
	

}
