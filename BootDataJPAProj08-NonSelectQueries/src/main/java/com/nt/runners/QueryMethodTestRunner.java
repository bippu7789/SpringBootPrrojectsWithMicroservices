package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IActorRepository;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {
	@Autowired
	private IActorRepository actorRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		int count = actorRepo.updateActorMobileNoByAid(999999999L, 9);
		System.out.println(count == 1 ? "Actor mobile number is updated" : "Actor mobile number is not found");
		
		System.out.println("No of records deleted"+actorRepo.deleteActorsByCategory("sales"));

	}
}
