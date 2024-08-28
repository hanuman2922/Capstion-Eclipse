package com.service;



import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.AppointmentDTO;
import com.exceptions.CustomException;
import com.model.Appointment;
import com.model.Patient;
import com.repository.AppointmentRepository;
import com.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
     PatientRepository patientRepository;
	
	 @Autowired
	    private AppointmentRepository appointmentRepos;
	 
	 @Autowired
		RestTemplate restTemplate;
		
		String baseUrl = "http://doctormicroservice/doctors";
 /*   
	// Register
		public Patient addNewPatient(Patient patient) {
			Patient patient1 = patientRepository.save(patient);
			return patient1;
			
		}
	    
		public String verify(Patient patient) {
			System.out.println("method called" + patient.getEmail());
			Patient credentials = patientRepository.findByEmail(patient.getEmail());
		    System.out.println("method called" + credentials);
		    if (credentials != null && credentials.getPassword().equals(patient.getPassword())) {
		    	System.out.println("ok called");
		        return (" Password Matched");
		    }
		    return null;  
		}

	*/	
		
		
		

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		//6
		
//		public List<AppointmentDTO> getAppointmentsForCurrentMonth() {
//	        LocalDate now = LocalDate.now();
//	        LocalDate startOfMonth = now.withDayOfMonth(1);
//	        LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());
//	        
//	        List<Appointment> appointments = appointmentRepos.findByAppointmentDateBetween(startOfMonth, endOfMonth);
//	        return appointments.stream().map(this::convertToDto).collect(Collectors.toList());
//	    }
//		private AppointmentDTO convertToDto(Appointment appointment) {
//			AppointmentDTO dto = new AppointmentDTO();
//	        dto.setAppId(appointment.getAppId());
//	        dto.setPatientId(appointment.getPatientId());
//	        dto.setDoctorId(appointment.getDoctorID());
//	       dto.setAppointmentDate(appointment.getAppointmentDate());
//	        return dto;
//	    }
		
		
		
		
		//6  type 2

//	    public List<AppointmentDTO> getAppointmentsForCurrentMonth() {
//	        try {
//	            LocalDate now = LocalDate.now();
//	            LocalDate startOfMonth = now.withDayOfMonth(1);
//	            LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());
//
//	            List<Appointment> appointments = appointmentRepos.findByAppointmentDateBetween(startOfMonth, endOfMonth);
//	            return appointments.stream().map(this::convertToDto).collect(Collectors.toList());
//	        } catch (Exception e) {
//	            throw new RuntimeException("Failed to retrieve appointments for current month", e);
//	        }
//	    }
//
//	    private AppointmentDTO convertToDto(Appointment appointment) {
//	        try {
//	            AppointmentDTO dto = new AppointmentDTO();
//	            dto.setAppId(appointment.getAppId());
//	            dto.setPatientId(appointment.getPatientId());
//	            dto.setDoctorId(appointment.getDoctorID());
//	            dto.setAppointmentDate(appointment.getAppointmentDate());
//	            return dto;
//	        } catch (Exception e) {
//	            throw new RuntimeException("Failed to convert appointment to DTO", e);
//	        }
//	    }
		
		
		// 6 type 3
		public List<AppointmentDTO> getAppointmentsForCurrentMonth() {
	        try {
	            LocalDate now = LocalDate.now();
	            LocalDate startOfMonth = now.withDayOfMonth(1);
	            LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());

	            List<Appointment> appointments = appointmentRepos.findByAppointmentDateBetween(startOfMonth, endOfMonth);
	            return appointments.stream()
	                    .map(appointment -> {
	                        AppointmentDTO dto = new AppointmentDTO();
	                        dto.setAppId(appointment.getAppId());
	                        dto.setPatientId(appointment.getPatientId());
	                        dto.setDoctorId(appointment.getDoctorID());
	                        dto.setAppointmentDate(appointment.getAppointmentDate());
	                        return dto;
	                    })
	                    .collect(Collectors.toList());
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to retrieve appointments for current month", e);
	        }
	    }


}
