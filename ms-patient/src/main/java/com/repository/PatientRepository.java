package com.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Appointment;
import com.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer> {

	
	
 Patient  findByEmail(String email);
 
 
 // List<Appointment> findByAppointmentDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);
 
 
 
 

}
