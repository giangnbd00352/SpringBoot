package com.example.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the `log time sheet` database table.
 * 
 */
@Entity
@Table(name="`log time sheet`")
public class Log_time_sheet implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Log_time_sheetPK id;

	private int hours;

	private String role;

	private String type;

	public Log_time_sheet() {
	}

	public Log_time_sheetPK getId() {
		return this.id;
	}

	public void setId(Log_time_sheetPK id) {
		this.id = id;
	}

	public int getHours() {
		return this.hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}