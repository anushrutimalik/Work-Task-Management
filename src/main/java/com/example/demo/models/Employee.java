package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,
	    property = "id"
)
public class Employee {
       
	   @Id
	   @GeneratedValue(strategy = GenerationType.UUID)
	   private String id;
	   
	   private String fullname;
       private String email;
       private Date dob;
       private String status;
       private String designation;
       private String department;
      
       @JsonIgnore
       @JsonManagedReference("11") //don't understand this part
       @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")//cascade
       private List<Work> works = new ArrayList<>();
       
	   public String getId() {
		   return id;
	   }
	   public void setId(String id) {
		   this.id = id;
	   }
	   public String getFullname() {
		   return fullname;
	   }
	   public void setFullname(String fullname) {
		   this.fullname = fullname;
	   }
	   public String getEmail() {
		   return email;
	   }
	   public void setEmail(String email) {
		   this.email = email;
	   }
	   public Date getDob() {
		   return dob;
	   }
	   public void setDob(Date dob) {
		   this.dob = dob;
	   }
	   public String getStatus() {
		   return status;
	   }
	   public void setStatus(String status) {
		   this.status = status;
	   }
	   public String getDesignation() {
		   return designation;
	   }
	   public void setDesignation(String designation) {
		   this.designation = designation;
	   }
	   public String getDepartment() {
		   return department;
	   }
	   public void setDepartment(String department) {
		   this.department = department;
	   }
	   public void addWork(Work work) { 
		   work.setEmployee(this);
		   works.add(work);
	   }
	   public List<Work> getWorks() {
		  return works;
	   }
	   public void setWorks(List<Work> works) {
		   this.works = works;
	   }
       
}
