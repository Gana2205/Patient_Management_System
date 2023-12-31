package com.gana.patientdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

	private int id;
	private String name;
	private String gender;
	private int age;
	private String city;
	private long contact;
	private String symptoms;
	
}
