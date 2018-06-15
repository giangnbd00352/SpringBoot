package com.jan.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codenumber;

	private String customer;

	private String description;

	private String pm;

	private String technology;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//                }, mappedBy="projects")
//	private List<Account> accounts;
//
//	public List<Account> getAccounts() {
//		return accounts;
//	}
//
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}

	public Project() {
	}

	public int getCodenumber() {
		return this.codenumber;
	}

	public void setCodenumber(int codenumber) {
		this.codenumber = codenumber;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPm() {
		return this.pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

}