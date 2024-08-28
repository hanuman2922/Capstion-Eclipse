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
import com.model.Patient;
import com.service.AppointmentService;
import com.service.PatientService;

import jakarta.validation.Valid;

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
/*
	// Register
	@PostMapping
	public ResponseEntity<?> Register(@Valid @RequestBody Patient patient) {
		Patient register = patientService.addNewPatient(patient);
		return new ResponseEntity<>(register, HttpStatus.OK);
	}

	// login
	@PostMapping("/login")
	public ResponseEntity<?> loginCustomer(@Valid @RequestBody PatientDTO patientlogin) {
		Patient patient1 = patientlogin.toEnity();
		String customer = patientService.verify(patient1); // changed Learner to string
		if (customer != null) {
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Required Both email and password");
		}
	}

	// 3 doctors by id working

	@GetMapping("/doctors/{doc_id}")
	public ResponseEntity<?> getDoctorById(@Valid @PathVariable("doc_id") int Id) {
		String url = "http://doctormicroservice/doctors/" + Id; // assuming the doctor microservice has a /doctors
																// endpoint

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (response.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
			return ResponseEntity.ok(response.getBody());
		} else if (response.getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)) {
			return new ResponseEntity<String>("No Doctor found with that id ", HttpStatus.NOT_FOUND);
		}
		//return  ResponseEntity.status(response.getStatusCode()).body(response.getBody());
		return new ResponseEntity<>(response.getBody(),response.getStatusCode());
	}

	// new specilization
	private String buildUrl(String baseUrl, String param, String value) {
		String url = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam(param, value).toUriString();
		return url;
	}
	//4
	@GetMapping("/doctors")
	public ResponseEntity<?> showDoctorsBySpecialization(@RequestParam("specialization") String specialization) {
		String url = buildUrl(baseUrl, "specialization", specialization);
		System.out.println(url);
		ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List>() {
				});
		if (response.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
			return new ResponseEntity<List>(response.getBody(), HttpStatus.OK);
		} else if (response.getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)) {
			return new ResponseEntity<String>("No doctor record found specialization", HttpStatus.NOT_FOUND);
		}
		return null;

	}



					
	//5				
					
	 @PostMapping("/appointments")
	    public ResponseEntity<String> bookAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {
	        try {
	            // Call the service to book the appointment
	            appointmentService.bookAppointment(appointmentDTO);
	            return new ResponseEntity<>("Appointment booked successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	            // Handle exceptions and errors
	            return new ResponseEntity<>("Error booking appointment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	*/
	
	
	 private static final Logger logger = LoggerFactory.getLogger(PatientContoller.class);
/*
	 // 1.Register
	    @PostMapping("/register")
	    public ResponseEntity<?> Register(@Valid @RequestBody Patient patient) {
	        logger.info("Registering new patient: {}", patient);
	        Patient register = patientService.addNewPatient(patient);
	        logger.info("Patient registered successfully: {}", register);
	        return new ResponseEntity<>(register, HttpStatus.OK);
	    }
	    
	    
	 //2. Login
	    @PostMapping("/login")
	    public ResponseEntity<?> loginCustomer(@Valid @RequestBody PatientDTO patientlogin) {
	        logger.info("Customer login attempt with: {}", patientlogin);
	        Patient patient1 = patientlogin.toEnity();
	        String customer = patientService.verify(patient1); // changed Learner to string
	        if (customer != null) {
	            logger.info("Customer verified successfully");
	            return ResponseEntity.ok(customer);
	        } else {
	            logger.warn("Login failed: Required both email and password");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Required Both email and password");
	        }
	    }
	    
	    
	    // 3.Get Doctor by ID
	    @GetMapping("/doctors/{doc_id}")
	    public ResponseEntity<?> getDoctorById(@Valid @PathVariable("doc_id") int Id) {
	        logger.info("Fetching doctor with ID: {}", Id);
	        String url = baseUrl + "/doctors/" + Id; // assuming the doctor microservice has a /doctors endpoint
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

	        if (response.getStatusCode().is2xxSuccessful()) {
	            logger.info("Doctor found: {}", response.getBody());
	            return ResponseEntity.ok(response.getBody());
	        } else if (response.getStatusCode().is4xxClientError()) {
	            logger.warn("No Doctor found with ID: {}", Id);
	            return new ResponseEntity<>("No Doctor found with that id", HttpStatus.NOT_FOUND);
	        }
	        logger.error("Error occurred while fetching doctor with ID: {}", Id);
	        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
	    }
	
		// new specilization
		private String buildUrl(String baseUrl, String param, String value) {
			String url = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam(param, value).toUriString();
			return url;
		}
	
	    //4. Show Doctors by Specialization
	    @GetMapping("/doctors")
	    public ResponseEntity<?> showDoctorsBySpecialization(@RequestParam("specialization") String specialization) {
	        logger.info("Fetching doctors with specialization: {}", specialization);
	        String url = buildUrl(baseUrl, "specialization", specialization);
	        logger.debug("Constructed URL: {}", url);
	        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, null,
	                new ParameterizedTypeReference<List>() {
	                });
	        if (response.getStatusCode().is2xxSuccessful()) {
	            logger.info("Doctors found: {}", response.getBody());
	            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	        } else if (response.getStatusCode().is4xxClientError()) {
	            logger.warn("No doctor record found for specialization: {}", specialization);
	            return new ResponseEntity<>("No doctor record found for specialization", HttpStatus.NOT_FOUND);
	        }
	        logger.error("Error occurred while fetching doctors by specialization: {}", specialization);
	        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
	    }
	
	
	    // 5.Book Appointment
	    @PostMapping("/appointments")
	    public ResponseEntity<String> bookAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {
	        logger.info("Booking appointment: {}", appointmentDTO);
	        try {
	            appointmentService.bookAppointment(appointmentDTO);
	            logger.info("Appointment booked successfully");
	            return new ResponseEntity<>("Appointment booked successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	            logger.error("Error booking appointment: {}", e.getMessage(), e);
	            return new ResponseEntity<>("Error booking appointment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
*/
	 
	 

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	 //6
//	 @GetMapping("/patient/appointments")
//     public ResponseEntity<List<AppointmentDTO>> getAppointments() {
//         List<AppointmentDTO> appointments = patientService.getAppointmentsForCurrentMonth();
//         return ResponseEntity.ok(appointments);  
//     }
	 
	 
	 //6  type 2
//	 @GetMapping("/patient/appointments")
//	 public ResponseEntity<List<AppointmentDTO>> getAppointments() {
//	     try {
//	         List<AppointmentDTO> appointments = patientService.getAppointmentsForCurrentMonth();
//	         return ResponseEntity.ok(appointments);
//	     } catch (Exception e) {
//	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//	     }
//	 }
//	 
	 
	 
	 //6 type3
	 @GetMapping("/patient/appointments")
	 public ResponseEntity<List<AppointmentDTO>> getAppointments() {
	     try {
	         List<AppointmentDTO> appointments = patientService.getAppointmentsForCurrentMonth();
	         return ResponseEntity.ok(appointments);
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	     }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
			

}

