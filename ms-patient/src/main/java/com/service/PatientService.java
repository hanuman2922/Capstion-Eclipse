package com.service;



import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
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
/*		
		 // Register
	    public Patient addNewPatient(Patient patient) {
	        logger.info("Adding new patient: {}", patient);
	        Patient patient1 = patientRepository.save(patient);
	        logger.info("Patient added successfully: {}", patient1);
	        return patient1;
	    }

	    public String verify(Patient patient) {
	        logger.info("Verifying patient with email: {}", patient.getEmail());
	        Patient credentials = patientRepository.findByEmail(patient.getEmail());
	        logger.info("Patient credentials retrieved: {}", credentials);
	        
	        if (credentials != null && credentials.getPassword().equals(patient.getPassword())) {
	            logger.info("Password matched for email: {}", patient.getEmail());
	            return "Password Matched";
	        }
	        
	        logger.warn("Password did not match for email: {}", patient.getEmail());
	        return null;
	    }
*/		
		
		// Register
	    public Patient addNewPatient(Patient patient) throws CustomException {
	        logger.info("Attempting to add a new patient with email: {}", patient.getEmail());

	        if (patientRepository.findByEmail(patient.getEmail()) != null) {
	            logger.error("Patient with email {} already exists.", patient.getEmail());
	            throw new CustomException("Patient with this email already exists");
	        }
	        if (patient.getPatientDob() != null) {
	            LocalDate dob = patient.getPatientDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	            if (dob.isAfter(LocalDate.now())) {
	                logger.error("Date of birth {} is in the future.", dob);
	                throw new CustomException("Date of birth cannot be in the future");
	            }
	        }
	        Patient savedPatient = patientRepository.save(patient);
	        logger.info("Successfully added new patient with email: {}", patient.getEmail());
	        return savedPatient;
	    }
		

		
	    //login 	    
	    public String verify(Patient patient) throws CustomException {
	        logger.info("Verifying patient with email: {}", patient.getEmail());

	        Patient credentials = patientRepository.findByEmail(patient.getEmail());
	        if (credentials == null) {
	            logger.error("No patient found with email: {}", patient.getEmail());
	            throw new CustomException("No patient found with this email");
	        }

	        if (credentials.getPassword().equals(patient.getPassword())) {
	            logger.info("Password matched for email: {}", patient.getEmail());
	            return "Password Matched";
	        } else {
	            logger.error("Invalid password attempt for email: {}", patient.getEmail());
	            throw new CustomException("Invalid password");
	        }
	    }
	    

	    
		// 6 
	    public List<AppointmentDTO> getAppointmentsForCurrentMonth() {
	        logger.info("Fetching appointments for the current month.");

	        try {
	            LocalDate now = LocalDate.now();
	            LocalDate startOfMonth = now.withDayOfMonth(1);
	            LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());

	            logger.debug("Start of the month: {}", startOfMonth);
	            logger.debug("End of the month: {}", endOfMonth);

	            List<Appointment> appointments = appointmentRepos.findByAppointmentDateBetween(startOfMonth, endOfMonth);
	            logger.info("Retrieved {} appointments for the current month.", appointments.size());

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
	            logger.error("Failed to retrieve appointments for the current month", e);
	            throw new RuntimeException("Failed to retrieve appointments for current month", e);
	        }
	    }
	   
	    
		
}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		




