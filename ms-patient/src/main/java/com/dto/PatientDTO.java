package com.dto;

import com.model.Patient;

import jakarta.validation.constraints.NotEmpty;

import jakarta.persistence.Column;


public class PatientDTO {
	
	

	   @NotEmpty(message ="Email is required")
	   private String email;
	    
	    @NotEmpty(message ="Password is Required")
	    private String password;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public PatientDTO(@NotEmpty(message = "Email is required") String email,
				@NotEmpty(message = "Password is Required") String password) {
			super();
			this.email = email;
			this.password = password;
		}

		@Override
		public String toString() {
			return "PatientDTO [email=" + email + ", password=" + password + "]";
		}

		public PatientDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
	    

		public  Patient toEnity() {
			return  new Patient(email, password);
			
		}
	    

}
