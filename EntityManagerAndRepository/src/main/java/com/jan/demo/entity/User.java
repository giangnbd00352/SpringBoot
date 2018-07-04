package com.jan.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;



/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(value = { "role", "authorities" })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/*private Set<Project> projects = new HashSet<>(0);*/

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String password;

	private String role;

	private String username;
	

	public User() {
	}
	
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}