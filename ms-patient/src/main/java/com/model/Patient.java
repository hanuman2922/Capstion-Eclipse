package com.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
      
    @NotEmpty(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Column(name = "email", unique = true, length = 50)
    private String email;

    @NotEmpty(message = "Password is mandatory")
    @Size(min = 6, max = 35, message = "Password must be between 6 and 35 characters")
    @Column(name = "pass_word", length = 35)
    private String password;

    @NotEmpty(message = "Patient name is mandatory")
    @Column(name = "patient_name", length = 50)
    private String patientName;

    @NotNull(message = "Patient date of birth is mandatory")
    @Past(message = "Date of birth must be in the past")
    @Column(name = "patient_dob")
    private Date patientDob;

    @NotEmpty(message = "Contact is mandatory")
    @Size(min = 10, message = "Contact number must be 10 ")
    @Column(name = "contact", length = 20)
    private String contact;

    @NotEmpty(message = "Please mention your gender")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    @Column(name = "gender", length = 10)
    private String gender;
    
    
    
    
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(Date patientDob) {
        this.patientDob = patientDob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient (String email, String password, String patientName, Date patientDob, String contact, String gender) {
		super();
		this.email = email;
		this.password = password;
		this.patientName = patientName;
		this.patientDob = patientDob;
		this.contact = contact;
		this.gender = gender;
	}

	public Patient( String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", email=" + email + ", password=" + password + ", patientName=" + patientName
				+ ", patientDob=" + patientDob + ", contact=" + contact + ", gender=" + gender + "]";
	}


	
	
	
   
}

