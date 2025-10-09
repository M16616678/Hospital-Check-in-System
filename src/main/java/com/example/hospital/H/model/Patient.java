
package com.example.hospital.H.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Patient {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @NotBlank(message = "First name cannot be blank")
 private String firstName;

 @NotBlank(message = "Last name cannot be blank")
 private String lastName;

 @NotBlank(message = "Email cannot be blank")
 @Email(message = "Email should be valid")
 private String email;

 @NotBlank(message = "Phone number cannot be blank")
 private String phone;
 
 private LocalDate dob; // Date of birth

 // Constructors, Getters, and Setters

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
}
