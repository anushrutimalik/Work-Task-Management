package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String fullname;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable=false, unique=true)
	private String contact;
	
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;
	
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(String id, String fullname, String email, String contact, Role role) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.contact = contact;
		this.role = role;
	}
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
