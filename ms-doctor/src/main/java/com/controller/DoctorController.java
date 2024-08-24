package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.model.Doctor;
import com.service.DoctorService;



@RestController
@RequestMapping("/doctors")
@Validated
public class DoctorController {
	
	@Autowired
	//DoctorService docService;
	DoctorService doctorService;
	
	// its working   method 1
	
//	  @GetMapping("/{docId}")
//	    public ResponseEntity<Doctor> getDoctorById(@PathVariable("docId") Integer doctorId) {
//	        Doctor doctor = doctorService.getDoctorById(doctorId);
//	        if (doctor == null) {
//	            return ResponseEntity.notFound().build();
//	        }
//	        return ResponseEntity.ok(doctor);
//	    }
//	  
//	  
//	  @GetMapping
//	    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@RequestParam String specialization) {
//	        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
//	        return ResponseEntity.ok(doctors);
//	    }
	
 
//	  @Value("${server.port}")
//		private String port;
	
	

	
		// method 2


//	@GetMapping("/{docId}")   //end points
//	public ResponseEntity<List<Doctor>> showDoctorBydocId(@PathVariable("docId")Integer docId) throws CustomException{
//		List<Doctor> DocList=doctorService.listDoctorBydocId(docId);		
//		//System.out.println("Running on port number: "+port);
//		if(DocList==null || DocList.isEmpty() )
//		{
//			throw new CustomException("No records found for that doctor Id "+docId);
//		}
//		return new ResponseEntity<>(DocList,HttpStatus.OK);		
//	}
//
//	
//	
//	@GetMapping("/specialization/{specialization}")   
//	public ResponseEntity<List<Doctor>> showDoctorBySpecialization(@PathVariable("specialization")String specialization) throws CustomException{
//		List<Doctor> DocList=doctorService.listDoctorBySpecialization(specialization);		
//
//		if(DocList==null || DocList.isEmpty() )
//		{
//			throw new CustomException("No records found for specialization "+specialization);
//		}
//		return new ResponseEntity<>(DocList,HttpStatus.OK);		
//	}
//	  
	
	
	// method 3 
	
	@GetMapping
	public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@RequestParam String specialization) {
	    List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
	    if (doctors == null || doctors.isEmpty()) {
	        throw new ResponseStatusException(
	                HttpStatus.NOT_FOUND, "No doctors found for that specialization " + specialization);
	    }
	    return ResponseEntity.ok(doctors);
	}
	
	
	
	
	
	
	
	
	
	
	
  

}



