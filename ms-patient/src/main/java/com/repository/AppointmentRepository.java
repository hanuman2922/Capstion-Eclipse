package com.repository;





import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.model.Appointment;




@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {

	//6
	List<Appointment> findByAppointmentDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);
	
	//5
	boolean existsByDoctorIDAndPatientIdAndAppointmentDate(int doctorId, int patientId, LocalDate appointmentDate);

	
}
//5
	//Appointment save(@Valid AppointmentDTO appointment);  its a default method thats y we dont write  

