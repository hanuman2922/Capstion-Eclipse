package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.AppointmentDTO;
import com.model.Appointment;
import com.repository.AppointmentRepository;





@Service
public class AppointmentService {
	
	@Autowired
    private AppointmentRepository AppRepos;



	
	//5
	public void bookAppointment(AppointmentDTO appointmentDTO) {
		System.out.println(appointmentDTO.getDoctorId()+" "+" "+appointmentDTO.getPatientId());
		 Appointment appointment = new Appointment();
	        appointment.setDoctorID(appointmentDTO.getDoctorId());
	        appointment.setPatientId(appointmentDTO.getPatientId());
	        appointment.setAppointmentDate((LocalDate) appointmentDTO.getAppointmentDate1());
	        
	        // Save the appointment entity
	        AppRepos.save(appointment);   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
