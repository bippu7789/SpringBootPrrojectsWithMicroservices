package com.nt.service;

import com.nt.entity.PersonInfo;

public interface IPersonInfoManagementService {
	public String registerPerson(PersonInfo info);
	public PersonInfo getPersonByPid(int pid);

}
