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
//		int count = actorRepo.insertActor("rahul", "Teacher", 8953874932L);
//		System.out.println(count == 0 ? "Records not inserted" : "Records inserted");
		
		System.out.println("Date::"+actorRepo.showDate());

	}
}
