package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Doctor;
import com.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository   doctorRepository;

	 private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

/*	public List<Doctor> listDoctorBydocId(Integer docId) {

		return doctorRepository.findAllByDocId(docId);
	}  
	
	    
	 public List<Doctor> getDoctorsBySpecialization(String specialization) {
		 return doctorRepository.findBySpecialization(specialization);
    }
 */

	    public List<Doctor> listDoctorBydocId(Integer docId) {
	        logger.debug("Fetching doctors with docId: {}", docId);
	        List<Doctor> doctors = doctorRepository.findAllByDocId(docId);
	        logger.debug("Found {} doctors with docId: {}", doctors.size(), docId);
	        return doctors;
	    }

	    public List<Doctor> getDoctorsBySpecialization(String specialization) {
	        logger.debug("Fetching doctors with specialization: {}", specialization);
	        List<Doctor> doctors = doctorRepository.findBySpecialization(specialization);
	        logger.debug("Found {} doctors with specialization: {}", doctors.size(), specialization);
	        return doctors;
	    }
	    
	    
	    
	    
}










