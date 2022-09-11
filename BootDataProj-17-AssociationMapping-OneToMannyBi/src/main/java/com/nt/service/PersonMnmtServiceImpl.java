package com.nt.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("personService")
public class PersonMnmtServiceImpl implements IPersonMnmtService {
	@Autowired
	IPersonRepository personRepo;

	@Autowired
	IPhoneNumberRepository phoneRepo;

	@Override
	public String saveDataUsingPerson(Person per) {
		return "Person and his phone number are saved" + personRepo.save(per) + "with ID value";
	}
//
//	@Override
//	public String savedataUsingPhoneNumber(List<PhoneNumber> phonesList) {
//		List<String> msges = new ArrayList<>();
//		if (phonesList.size() > 0) {
//
//			for (PhoneNumber ph : phonesList) {
//				msges.add("Phone number maped with person are saved with" + phoneRepo.save(ph) + "id value");
//			}
//		}
//		return msges.toString();
//	}

	@Override
	public String savedataUsingPhoneNumber(Set<PhoneNumber> phonesSet) {
		int count = phoneRepo.saveAll(phonesSet).size();
		return count + "PhoneNumber object maped to person obj are saved";

	}
}