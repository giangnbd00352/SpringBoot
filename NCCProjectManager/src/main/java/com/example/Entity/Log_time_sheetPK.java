package com.example.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the `log time sheet` database table.
 * 
 */
@Embeddable
public class Log_time_sheetPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="user_id", insertable=false, updatable=false)
	private int user_id;

	@Column(name="project_id", insertable=false, updatable=false)
	private int project_id;

	public Log_time_sheetPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuser_id() {
		return this.user_id;
	}
	public void setuser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getproject_id() {
		return this.project_id;
	}
	public void setproject_id(int project_id) {
		this.project_id = project_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Log_time_sheetPK)) {
			return false;
		}
		Log_time_sheetPK castOther = (Log_time_sheetPK)other;
		return 
			(this.id == castOther.id)
			&& (this.user_id == castOther.user_id)
			&& (this.project_id == castOther.project_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.user_id;
		hash = hash * prime + this.project_id;
		
		return hash;
	}
}