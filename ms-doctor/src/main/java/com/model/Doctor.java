package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doc_id")
	private Integer docId;
	
	
	@Column(name="doc_name")
	private String docName;
	
	private String specialization;
	
	private String expertise;
	
	@Column(name="available_time")
	private String availableTime;
	
	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}



	public Doctor(String docName, String specialization, String expertise, String availableTime) {
		super();
		this.docName = docName;
		this.specialization = specialization;
		this.expertise = expertise;
		this.availableTime = availableTime;
	}
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DoctorService [docId=" + docId + ", docName=" + docName + ", specialization=" + specialization
				+ ", expertise=" + expertise + ", availableTime=" + availableTime + "]";
	}
	

}
