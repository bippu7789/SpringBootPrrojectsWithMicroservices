package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PHONE_NUMBERS_OTM")
@Setter
@Getter
public class PhoneNumber {
	@Id
	@GeneratedValue
	private Integer regNo;
	private long phone_number;
	@Column(length = 20)
	private String numberType;
	@Column(length = 20)
	private String provide;
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Person person;

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phone_number=" + phone_number + ", numberType=" + numberType
				+ ", provide=" + provide + ", person=" + person + "]";
	}

	// toString

}
