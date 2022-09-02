package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {
	@Autowired
	private IActorRepository actorRepo;

	@Override
	public void run(String... args) throws Exception {
		actorRepo.searchActorByCategory("Developer").forEach(System.out::println);

		System.out.println("----------------------------------");
		actorRepo.findActorsByMobileNumbers(9695573888L, 9695573555L, 9695573111L).forEach(System.out::println);

		System.out.println("----------------------------------");
		actorRepo.findActorsDataByCategoties("ASE", "sales", "cleark").forEach(row -> {
			for (Object val : row)
				System.out.println(val + " ");
		});
		System.out.println("----------------------------------");
		actorRepo.findActorNameByStartLetters("B").forEach(System.out::println);

		System.out.println("----Find by mobile number--------");

		Actor actor = actorRepo.getActorByMobileNo(9695573777L);
		if (actor != null) {
			System.out.println("Actor info::" + actor);
		} else {
			System.out.println("Actor not found");
		}
		System.out.println("------------using object-------------");
		Object data = actorRepo.getActorDataByMobileNo(7777777777L);
		Object result[] = (Object[]) data;
		for (Object val : result) {
			System.out.println(val + " ");
		}

		System.out.println("scaller query giving specific single column value");
		String name = actorRepo.getActorNameByMobileNo(9695573222L);
		System.out.println("Actor name" + name);
		
		System.out.println("=====================================");

		Object aresult[] = (Object[]) actorRepo.getActorsAggrigateData();
		System.out.println("Counts of records" + aresult[0]);
		System.out.println("Min of AID::" + aresult[1]);
		System.out.println("Max of AID::" + aresult[2]);
		System.out.println("Sum of AID::" + aresult[3]);
		System.out.println("Avg of AID::" + aresult[4]);

		System.out.println("----------------------MaxAid----------");
		Actor actorInfo = actorRepo.getActorDataByMaxActorId();
		System.out.println(actorInfo);

	}
}
