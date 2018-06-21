package com.jan.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accID;

	private String email;

	private String name;

	private String pass;

	private String role;

	@ManyToMany
	@JoinTable(name = "account_role", joinColumns = { @JoinColumn(name = "account_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;

	// bi-directional many-to-many association to Project
	// @ManyToMany
	// @JoinTable(
	// name="relation"
	// , joinColumns={
	// @JoinColumn(name="accountId")
	// }
	// , inverseJoinColumns={
	// @JoinColumn(name="codenumber")
	// }
	// )
	// private List<Project> projects;

	public Account() {
	}

	public Account(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	// public List<Project> getProjects() {
	// return this.projects;
	// }
	//
	// public void setProjects(List<Project> projects) {
	// this.projects = projects;
	// }

}