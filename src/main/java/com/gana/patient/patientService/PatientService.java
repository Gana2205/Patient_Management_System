package com.gana.patient.patientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gana.patient.patientDao.PatientDao;
import com.gana.patientdto.Patient;

@Service
public class PatientService {
	
	@Autowired
	private PatientDao patientDao;

	public void addPatient(Patient patient) {
		
	    patientDao.addPatient(patient);
		
	}

	public List<Patient> fetchAll() {
		
		return patientDao.fetchAll();
		
		
	}
	
	public String updatePatient(Patient patient,int id) {
		
		
		
		return patientDao.updatePatient(patient, id);
		
	}

	public String deletePatient(int id) {
		
		return patientDao.deletePatient(id);
	}

	public Patient findById(int id) {
		
		return patientDao.findById(id);
	}

	

}
