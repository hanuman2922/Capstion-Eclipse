package com.repository;





import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.model.Appointment;




@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {

	
	List<Appointment> findByAppointmentDateBetween(LocalDate startDate, LocalDate endDate);

	
   //5
	//Appointment save(@Valid AppointmentDTO appointment);  its a default method thats y we dont write  

	
	

  

}