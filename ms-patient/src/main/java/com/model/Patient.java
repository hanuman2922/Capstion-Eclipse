package com.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="email is mandatory")
    @Column(name = "email", unique = true, length = 50)
    private String email;
    
    @NotEmpty(message="pass_word is mandatory")
    @Column(name = "pass_word", length = 35, nullable = false)
    private String password;

    @NotEmpty(message="patient_name is mandatory")
    @Column(name = "patient_name", length = 50, nullable = false)
    private String patientName;

    @NotEmpty(message="patient_dob is mandatory")
    @Column(name = "patient_dob", nullable = false)
    private java.sql.Date patientDob;

    @NotEmpty(message="contact is mandatory")
    @Column(name = "contact", length = 20, nullable = false, unique = true)
    private String contact;

    @NotEmpty(message="Please mention your gender")
    @Column(name = "gender", length = 10, nullable = false)
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

    public java.sql.Date getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(java.sql.Date patientDob) {
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

	public Patient(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
   
}

