package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEE_INFO_TAB")
@Data
public class EmployeeInfo {
	@Id
	@GeneratedValue
	private int eno;
	@Column(length = 20)
	String ename;

	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_FRIENDS", joinColumns = @JoinColumn(name = "EMO_ID", referencedColumnName = "ENO")) // to
																															// specify
																															// chield
																															// table
																															// and
																															// forign
																															// key
																															// column
	@Column(name = "FRIEND_NAME", length = 20) // to store list elements
	@OrderColumn(name = "FRIEND_INDEX") // to store list elements index
	@ListIndexBase(1)
	private List<String> friends;

	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_PHONES", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ENO"))
	@Column(name = "PHONE_NUMBER") // to store set elements
	private Set<Long> phones;

	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_IDDETAILS", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ENO "))
	@Column(name = "ID_NUMBER")
	private Map<String, Long> idDetails;

}
