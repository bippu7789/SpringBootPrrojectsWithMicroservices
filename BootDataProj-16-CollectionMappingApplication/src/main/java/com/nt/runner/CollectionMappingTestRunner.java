package com.nt.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.EmployeeInfo;
import com.nt.repository.EmployeeInfoRepository;

@Component
public class CollectionMappingTestRunner implements CommandLineRunner {

	@Autowired
	EmployeeInfoRepository EmpRepo;

	@Override
	public void run(String... args) throws Exception {
		EmployeeInfo info = new EmployeeInfo();
		info.setEname("BIPIN");
	//	info.setFriends(List.of("NITIN", "BISHAL", "SAMEER", "AMJATH"));// java 9 List.of()
	//	info.setPhones(Set.of(9695573777L, 9695573788L));// java 9 Set.of()
	//	info.setIdDetails(Map.of("Adhar", 9796543L, "panno", 98765L));// java 9 Set.of()
		// retriving data
		Iterable<EmployeeInfo> it = EmpRepo.findAll();
		it.forEach(System.out::println);

	}

}
