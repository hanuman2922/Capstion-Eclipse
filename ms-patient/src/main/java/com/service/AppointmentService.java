package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.AppointmentDTO;
import com.exceptions.CustomException;
import com.model.Appointment;
import com.repository.AppointmentRepository;





@Service
public class AppointmentService {
	
	@Autowired
    private AppointmentRepository AppRepos;

	 private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

	
/*	//5  wihtout logger and exception
	public void bookAppointment(AppointmentDTO appointmentDTO) {
		System.out.println(appointmentDTO.getDoctorId()+" "+" "+appointmentDTO.getPatientId());
		 Appointment appointment = new Appointment();
	        appointment.setDoctorID(appointmentDTO.getDoctorId());
	        appointment.setPatientId(appointmentDTO.getPatientId());
	        appointment.setAppointmentDate((LocalDate) appointmentDTO.getAppointmentDate1());
	        
	        // Save the appointment entity
	        AppRepos.save(appointment);   
		
	}
*/
 
	

	 

// 5.book an appointment
	 
	 public void bookAppointment(AppointmentDTO appointmentDTO) throws CustomException {
	        logger.info("Attempting to book an appointment with details: {}", appointmentDTO);

	        if (appointmentDTO.getDoctorId() <= 0 || appointmentDTO.getPatientId() <= 0) {
	            logger.error("Invalid Doctor ID or Patient ID. Doctor ID: {}, Patient ID: {}", 
	                         appointmentDTO.getDoctorId(), appointmentDTO.getPatientId());
	            throw new CustomException("Invalid Doctor ID or Patient ID");
	        }

	        // Checking appointments
	        boolean alreadyBooked = AppRepos.existsByDoctorIDAndPatientIdAndAppointmentDate(
	                appointmentDTO.getDoctorId(), 
	                appointmentDTO.getPatientId(), 
	                appointmentDTO.getAppointmentDate()
	        );

	        if (alreadyBooked) {
	            logger.error("Appointment already booked for Doctor ID: {}, Patient ID: {}, Date: {}", 
	                         appointmentDTO.getDoctorId(), appointmentDTO.getPatientId(), appointmentDTO.getAppointmentDate());
	            throw new CustomException("Appointment already booked for this doctor and patient at the same time");
	        }

	        Appointment appointment = new Appointment();
	        appointment.setDoctorID(appointmentDTO.getDoctorId());
	        appointment.setPatientId(appointmentDTO.getPatientId());
	        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());

	        try {
	            // Save the appointment entity
	            AppRepos.save(appointment);
	            logger.info("Appointment successfully booked for Doctor ID: {}, Patient ID: {}, Date: {}", 
	                        appointmentDTO.getDoctorId(), appointmentDTO.getPatientId(), appointmentDTO.getAppointmentDate());
	        } catch (Exception e) {
	            logger.error("Error saving appointment: {}", e.getMessage());
	            throw new CustomException("Error saving appointment: " + e.getMessage());
	        }
	    }


	
	
	
	
	
	
	
	
	
	
	
	
	

}
