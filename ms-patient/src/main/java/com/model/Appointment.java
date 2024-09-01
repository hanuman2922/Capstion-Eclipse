package com.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="app_id")
    private int appId;

    //@ManyToOne
   // @JoinColumn(name = "patient_id", nullable = false)
    @Column(name="patient_id")
    private int patientId;
    
    

    
   
    
	@Column(name = "doctor_id")
    private int  doctorID;
    
	@FutureOrPresent
    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

   
    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }


	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	public Appointment() {
		super();
		
	}

	public Appointment(int appId, int patientId, int doctorID, LocalDate appointmentDate) {
		super();
		this.appId = appId;
		this.patientId = patientId;
		this.doctorID = doctorID;
		this.appointmentDate = appointmentDate;
	}

	@Override
	public String toString() {
		return "Appointment [appId=" + appId + ", patientId=" + patientId + ", doctorID=" + doctorID
				+ ", appointmentDate=" + appointmentDate + "]";
	}
	
   
}



