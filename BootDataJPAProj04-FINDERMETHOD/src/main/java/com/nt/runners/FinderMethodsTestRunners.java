package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IActorRepository;

@Component
public class FinderMethodsTestRunners implements CommandLineRunner {
	@Autowired
	private IActorRepository actorRepo;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("SURESH name actor info");
//		actorRepo.findByAnameEquals("Bipin yadav").forEach(System.out::println);
//
//		System.out.println("Sarath actor info::");
//		actorRepo.findByAnameIs("Sharavan").forEach(System.out::println);

//		System.out.println("==========Teja actor info::======");
//		actorRepo.findByAname("Sharavan").forEach(System.out::println);
//		System.out.println("========================");
//		actorRepo.findByAidBetween(2, 4).forEach(System.out::println);
//		System.out.println("===================Like operation======");
//		actorRepo.findByAnameLike("B%").forEach(System.out::println);
//		
//		System.out.println("===================Like operation======");
//		actorRepo.findByAnameLike("%v").forEach(System.out::println);
//		
//		System.out.println("===================Like operation======");
//		actorRepo.findByAnameLike("%j%").forEach(System.out::println);

//		System.out.println("===================Like operation======");

//		actorRepo.findByAnameStartingWith("B").forEach(System.out::println);
//		System.out.println("===================Containing operation======");
//		actorRepo.findByAnameContainingIgnoreCase("v").forEach(System.out::println);

//		System.out.println("================findByCategoryIgnorecase==============");
//        actorRepo.findByCategoryInIgnoreCaseOrderByAnameAsc(null);

//		System.out.println("===================findByAidGreaterThanEqualAndAidLessThanEqual======");
//		actorRepo.findByAidGreaterThanEqualAndAidLessThanEqual(5, 7).forEach(System.out::println);

//		System.out.println("=========findByStatusTrueOrCategoryEquals=========");
//		actorRepo.findByStatusTrueOrCategoryEquals("Teja").forEach(System.out::println);

		System.out.println("==========findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase=======");
		actorRepo.findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase(3, 6, "ASE").forEach(System.out::println);
	}

}
