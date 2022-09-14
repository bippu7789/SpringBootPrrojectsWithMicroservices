package com.nt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "TBL_TECH_CHASERS")
public class TechChasers {
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "city")
	private String city;

	@Column(name = "date")
	private Date date;

	@Override
	public String toString() {
		return "TechChasers [id=" + id + ", name=" + name + ", city=" + city + ", date=" + date + "]";
	}

}
