package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
	
	
	//public List<Doctor> findByDoctorId(Integer docId);
	
	
			// working  method 1
//	List<Doctor> findBySpecialization(String specialization);
//
//	Optional<Doctor> findById(Integer doctorId);

	
	
	
	   // method 2
	
//	List<Doctor> findAllBySpecialization(String specialization);
//
//	List<Doctor> findAllByDocId(Integer docId);
	
	
	
  // method 3
	
	List<Doctor> findBySpecialization(String specialization);
	
	
	
	
	
	
	

}
