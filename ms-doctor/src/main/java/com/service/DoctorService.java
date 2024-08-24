package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Doctor;
import com.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
//	DoctorRepository  docRepos;
	DoctorRepository   doctorRepository;

	
	
//	public List<Doctor> listDoctorByDocId(Integer docId) {
//		// TODO Auto-generated method stub
//		return docRepos.findByDoctorId(docId);  // for this findByBookid the word  "id" should match with the entity class attribute. 
//	}
//	
	
	   // working   method 1
	
//	 public Doctor getDoctorById(Integer doctorId) {
//	        return doctorRepository.findById(doctorId).orElse(null);
//	    }
//	    
//	    public List<Doctor> getDoctorsBySpecialization(String specialization) {
//	        return doctorRepository.findBySpecialization(specialization);
//	    }
	    
	    
	    
			// working method 2

//	public List<Doctor> listDoctorBySpecialization(String specialization) {
//		// TODO Auto-generated method stub
//		return doctorRepository.findAllBySpecialization(specialization);
//	}
//	    
// 
//	public List<Doctor> listDoctorBydocId(Integer docId) {
//		// TODO Auto-generated method stub
//		return doctorRepository.findAllByDocId(docId);
//	}  
//	   
	
	
	
	
	    
	 public List<Doctor> getDoctorsBySpecialization(String specialization) {
		 return doctorRepository.findBySpecialization(specialization);
    }
 
	    
	    
	    
	    
}










