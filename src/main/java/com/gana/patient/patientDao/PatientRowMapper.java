package com.gana.patient.patientDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gana.patient.patientdto.Patient;

public class PatientRowMapper implements RowMapper<Patient> {

	@Override
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {

		Patient patient = new Patient();
		
		patient.setId(rs.getInt("id"));
		patient.setName(rs.getString("name"));
		patient.setGender(rs.getString("gender"));
		patient.setAge(rs.getInt("age"));
		patient.setCity(rs.getString("city"));
		patient.setContact(rs.getLong("contact"));
		patient.setSymptoms(rs.getString("symptoms"));

		return patient;
	}

}
