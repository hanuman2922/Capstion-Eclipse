package com.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;



public class AppointmentDTO {
	
	
	  private int appId;
	

	@NotNull(message="docctorid is important")
	 private int doctorID;
	 
	 @NotNull(message="patientID is important")
	    private int patientId;
	
	 @NotNull(message="appointment_date is important")
	    private LocalDate appointmentDate;
	    
	    
	 
		public int getAppId() {
			return appId;
		}
		public void setAppId(int appId) {
			this.appId = appId;
		}
	 
	 
		public int getDoctorId() {
			return doctorID;
		}
		public void setDoctorId(int doctorId) {
			this.doctorID = doctorId;
		}
		public int getPatientId() {
			return patientId;
		}
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		
		
		public AppointmentDTO(int doctorID, int patientId, LocalDate appointmentDate) {
				super();
				this.doctorID = doctorID;
				this.patientId = patientId;
				this.appointmentDate = appointmentDate;
			}
		public AppointmentDTO() {
			super();
		}
		public LocalDate getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		@Override
		public String toString() {
			return "AppointmentDTO [appId=" + appId + ", doctorID=" + doctorID + ", patientId=" + patientId
					+ ", appointmentDate=" + appointmentDate + "]";
		}
		
		
	

}
