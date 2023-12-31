package com.gana.patient.patientController;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gana.patient.patientService.PatientService;
import com.gana.patientdto.Patient;

@RestController
@RequestMapping("patient")
public class PatientController {
	
	@Autowired
	 private PatientService patientService;
	
	@PostMapping("add")
	 public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
		
		patientService.addPatient(patient);
		return new ResponseEntity<>("successfully patient details added",HttpStatus.OK);
	}
	
	@GetMapping("fetchAll")
	 public ResponseEntity<List<Patient>> fetchAll(){
		
		List<Patient> li = patientService.fetchAll(); 
		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	 public ResponseEntity<String> updatePatient(@RequestBody Patient patient,@PathVariable int id) {
		
		String result = patientService.updatePatient(patient, id);
		
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{id}")
	 public ResponseEntity<String> deletePatient(@PathVariable int id) {
		
		String result = patientService.deletePatient(id);
		
		return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Patient> findById(@PathVariable int id) {
		
		Patient patient = patientService.findById(id);
		
		   return new ResponseEntity<>(patient,HttpStatus.OK);
	
	}

}
