package com.oscar.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;

@NamedQuery(name="Client.findActiveClients", query="SELECT c FROM Client c where c.status=:status")
@NamedQuery(name="Client.findClientId", query="SELECT c FROM Client c where c.id=:id")
//@NamedQuery(name="Client.findAllCustom", query="SELECT c FROM Client")
@Entity
public class Client implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	Long id;
	 String firstName;
	 String lastName;
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="America/Mexico_City")
	 Date birthDate;
	 Boolean status;
	 
	/*
	 * public Client(long l, String string, String string2, String string3, String
	 * string4) { // TODO Auto-generated constructor stub this.id=l;
	 * this.firstName=string; this.lastName=string2; this.phoneNumber=string3;
	 * this.email=string4; }
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	 
	 
	}