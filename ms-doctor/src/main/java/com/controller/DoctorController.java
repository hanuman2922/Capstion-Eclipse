package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exceptions.CustomException;
import com.model.Doctor;
import com.service.DoctorService;



@RestController
@RequestMapping("/doctors")
@Validated
public class DoctorController {
	
	@Autowired
	
	DoctorService doctorService;
	

	
	@GetMapping("/{docId}")   //end points
	public ResponseEntity<List<Doctor>> showDoctorBydocId(@PathVariable("docId")int docId) throws CustomException{
		List<Doctor> DocList=doctorService.listDoctorBydocId(docId);		
		//System.out.println("Running on port number: "+port);
		if(DocList==null || DocList.isEmpty() )
		{
			throw new CustomException("No records found for that doctor Id "+docId);
		}
		return new ResponseEntity<>(DocList,HttpStatus.OK);		
	}
	

	
	@GetMapping
	public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@RequestParam String specialization) {
	    List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
	    if (doctors == null || doctors.isEmpty()) {
	        throw new ResponseStatusException(
	                HttpStatus.NOT_FOUND, "No doctors found for that specialization " + specialization);
	    }
	    return ResponseEntity.ok(doctors);
	}
	
	
	
	
	
	  @Value("${server.port}")
		private String port;
	
	
	
	
	
  

}



