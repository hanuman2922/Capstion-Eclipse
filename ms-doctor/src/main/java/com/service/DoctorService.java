package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Doctor;
import com.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository   doctorRepository;


	public List<Doctor> listDoctorBydocId(Integer docId) {

		return doctorRepository.findAllByDocId(docId);
	}  
	
	    
	 public List<Doctor> getDoctorsBySpecialization(String specialization) {
		 return doctorRepository.findBySpecialization(specialization);
    }
 
	    
	    
	    
	    
}










