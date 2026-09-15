package com.example.demo.models;

import java.time.Duration;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,
	    property = "workId"
		)
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String workId;
	private String title;
	private String description;
	private String status;
	private LocalDateTime createdOn;
	private LocalDateTime startedOn;
    private LocalDateTime closedOn;
    private Long tat;
    
    @JsonBackReference("11") //what is this
    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;
	
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getStartedOn() {
		return startedOn;
	}
	public void setStartedOn(LocalDateTime startedOn) {
		this.startedOn = startedOn;
	}
	public LocalDateTime getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(LocalDateTime closedOn) {
		this.closedOn = closedOn;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Long getTat() {
		if(this.closedOn != null && this.startedOn != null) {
		   this.tat = Duration.between(closedOn, startedOn).toHours();
		   return tat;
		}
		else
		   return tat;
	}
	public void setTat(Long tat) {
		this.tat = tat;
	}
    
}
