package com.gana.patient.patientDao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gana.patient.Exeption.NoDataFound;
import com.gana.patient.patientdto.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addPatient(Patient patient) {

		String sql = "insert into patients values(?,?,?,?,?,?,?)";

		Object[] args = { patient.getId(), patient.getName(), patient.getGender(), patient.getAge(), patient.getCity(),
				patient.getContact(), patient.getSymptoms() };
		int row = jdbcTemplate.update(sql, args);
        
		System.out.println(row+" 's inserted successfully");

	}

	@Override
	public List<Patient> fetchAll() {

		String sql = "SELECT * FROM PATIENTS";

		List<Patient> list = jdbcTemplate.query(sql, new PatientRowMapper());
		
		if(list.isEmpty()) 
		{
			throw new NoDataFound("NO DATA FOUND PLEASE INSERT DATA FIRST.....");
		}
		return list;
	}

	@Override
	public String updatePatient(Patient patient, int id) {
		
		     List<Patient> list = fetchAll();
			
			 Iterator<Patient> iterator =list.iterator();
			
			 while(iterator.hasNext())
			  {
				Patient patient2 = iterator.next();
				
				if(patient2.getId()==id) 
				{
		
		           String sql = "UPDATE PATIENTS SET NAME=?,GENDER=?,AGE=?,CITY=?,"
		           		           + "CONTACT=?,SYMPTOMS=? WHERE ID=?";

		        Object[] args = { patient.getName(), patient.getGender(), 
		        		            patient.getAge(), patient.getCity(),
		                              patient.getContact(), patient.getSymptoms(), id };

		                 int row = jdbcTemplate.update(sql, args);

		             return row + "'s effected";
	           }
			}
		throw new NoDataFound("NO DATA FOUND TO UPDATE WITH Id " + id + " PLEASE INSERT DATA FIRST.....");
	}

	@Override
	public String deletePatient(int id) {
		
            List<Patient> list = fetchAll();
		
		Iterator<Patient> iterator =list.iterator();
		
		while(iterator.hasNext())
		{
			Patient patient2 = iterator.next();
			
			if(patient2.getId()==id) {
				
				String sql ="DELETE FROM PATIENTS WHERE ID=?";
				
				int row = jdbcTemplate.update(sql,id);
				return row+"'s effected successfully deleted record";
			}
		}
		
		throw new NoDataFound("NO DATA FOUND WITH Id " + id + " PLEASE INSERT DATA FIRST.....");
	}

	@Override
	public Patient findById(int id) {

		List<Patient> list = fetchAll();

		Iterator<Patient> iterator = list.iterator();

		while (iterator.hasNext()) {
			Patient patient2 = iterator.next();

			if (patient2.getId() == id) {

				return patient2;
			}
		}

		throw new NoDataFound("NO DATA FOUND WITH Id " + id + " PLEASE INSERT DATA FIRST.....");
	}

}
