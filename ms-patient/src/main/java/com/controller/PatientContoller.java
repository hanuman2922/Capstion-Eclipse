package com.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dto.AppointmentDTO;
import com.dto.PatientDTO;
import com.exceptions.CustomException;
import com.model.Patient;
import com.service.AppointmentService;
import com.service.PatientService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/patients")
@Validated
public class PatientContoller {

	@Autowired
	PatientService patientService;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	RestTemplate restTemplate;

	String baseUrl = "http://doctormicroservice/doctors";

	
	
	 private static final Logger logger = LoggerFactory.getLogger(PatientContoller.class);


	// 1. Register
	 @PostMapping
	 public ResponseEntity<?> Register(@Valid @RequestBody Patient patient) {
	     logger.info("Registering new patient: {}", patient);
	     try {
	         Patient register = patientService.addNewPatient(patient);
	         logger.info("Patient registered successfully: {}", register);
	         return new ResponseEntity<>(register, HttpStatus.OK);
	     } catch (CustomException e) {
	         logger.error("Registration failed: {}", e.getMessage(), e);
	         // Return a conflict status for specific validation errors
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	     } catch (Exception e) {
	         logger.error("Error registering patient: {}", e.getMessage(), e);
	         // Return a generic error status for other exceptions
	         return new ResponseEntity<>("Error registering patient: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }

	// 2. Login
	@PostMapping("/login")
	public ResponseEntity<?> loginCustomer(@Valid @RequestBody PatientDTO patientlogin) throws CustomException {
	    logger.info("Customer login attempt with: {}", patientlogin);
	    Patient patient1 = patientlogin.toEnity();
	    String customer = patientService.verify(patient1);
	    if (customer != null) {
	        logger.info("Customer verified successfully");
	        return ResponseEntity.ok(customer);
	    } else {
	        logger.warn("Login failed: Required both email and password");
	        throw new CustomException("Required Both email and password");
	    }
	}

	// 3. Get Doctor by ID
	@GetMapping("/doctors/{doctorId}")
    public ResponseEntity<?> getByDoctorId(@PathVariable @NotBlank @Positive String doctorId) throws CustomException {
        if (doctorId == null || doctorId.trim().isEmpty()) {
            throw new CustomException("Doctor ID must be provided");
        }
        String url = baseUrl + "/" + doctorId;
        logger.info("Requesting URL: {}", url);
        try {
            ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
         
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                logger.info("Doctor record found: {}", response.getBody());
                return response;
            } else {
                logger.warn("No doctor record found for ID: {}", doctorId);
                throw new CustomException("No doctor record found for ID: " + doctorId);
            }
        } catch (Exception ex) 
        {      
          logger.error("Exception occurred while fetching doctor with ID {}: {}", doctorId);
          throw new CustomException("No Doctor found with that ID: " + doctorId);
      }
	}


	
	
			private String buildUrl(String baseUrl, String param, String value) {
				String url = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam(param, value).toUriString();
				return url;
			}
	

	// 4. Show Doctors by Specialization
		    @GetMapping("/doctors")
		    public ResponseEntity<?> showDoctorsBySpecialization(@RequestParam("specialization") String specialization) throws CustomException {
		        if (specialization == null || specialization.trim().isEmpty()) {
		            throw new CustomException("Specialization must be provided");
		        }
		        String url = buildUrl(baseUrl, "specialization", specialization);
		        logger.info("Requesting URL: {}", url);
		        try {
		            ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, null,
		                new ParameterizedTypeReference<List>() {}
		            );		           
		            if (response.getStatusCode().value() == HttpStatus.OK.value() && response.getBody() != null && !response.getBody().isEmpty()) {
		                return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
		            } else {
		                throw new CustomException("No doctor record found for specialization: " + specialization);
		            }

		        } catch (Exception ex) {
		            logger.error("Exception occurred while fetching doctors for specialization {}: {}", specialization, ex.getMessage());
		            throw new CustomException("no doctors found with that specialization: " + specialization);
		        }
		    }
		      
	// 5. Book Appointment
		    
		    @PostMapping("/appointments")
		    public ResponseEntity<String> bookAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {
		        logger.info("Booking appointment: {}", appointmentDTO);
		        try {
		            appointmentService.bookAppointment(appointmentDTO);
		            logger.info("Appointment booked successfully");
		            return new ResponseEntity<>("Appointment booked successfully", HttpStatus.CREATED);
		        } catch (CustomException e) {
		            logger.error("Error booking appointment: {}", e.getMessage(), e);
		            
		            if (e.getMessage().contains("already booked")) {
		                return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		            } else {
		                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		            }
		        } catch (Exception e) {
		            logger.error("Unexpected error: {}", e.getMessage(), e);
		            return new ResponseEntity<>("Unexpected error occurred while booking appointment", HttpStatus.INTERNAL_SERVER_ERROR);
		        }
		    }
		    
		    
		    
		    
		  //6 type3 it works    
		    @GetMapping("/patient/appointments")
		    public ResponseEntity<List<AppointmentDTO>> getAppointments() {
		        logger.info("Received request to get appointments");
		        try {
		            List<AppointmentDTO> appointments = patientService.getAppointmentsForCurrentMonth();
		            logger.info("Successfully retrieved {} appointments", appointments.size());
		            return ResponseEntity.ok(appointments);
		        } catch (Exception e) {
		            logger.error("Error occurred while retrieving appointments", e);
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		        }
		    }
		    
	    

}










