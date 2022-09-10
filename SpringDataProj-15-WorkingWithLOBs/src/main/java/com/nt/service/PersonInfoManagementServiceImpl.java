package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.PersonInfo;
import com.nt.repository.IPersonInfoRepository;

@Service("personService")
public class PersonInfoManagementServiceImpl implements IPersonInfoManagementService {
	@Autowired
	IPersonInfoRepository repo;

	@Override
	public String registerPerson(PersonInfo info) {
		return repo.save(info).getPid() + "Person is saved";
	}

	@Override
	public PersonInfo getPersonByPid(int pid) {
		return repo.findById(pid).orElseThrow(() -> new IllegalArgumentException("Invalid pid"));
	}

}
