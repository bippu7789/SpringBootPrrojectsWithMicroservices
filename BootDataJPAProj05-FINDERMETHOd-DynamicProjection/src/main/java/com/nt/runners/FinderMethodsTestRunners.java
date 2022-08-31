package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;
import com.nt.view.ResultView3;

@Component
public class FinderMethodsTestRunners implements CommandLineRunner {
	@Autowired
	private IActorRepository actorRepo;

	@Override
	public void run(String... args) throws Exception {
		// Using resultView1 as type interface
		Iterable<ResultView1> it = actorRepo.findByCategoryContainingIgnoreCase("A", ResultView1.class);
		it.forEach(view1 -> {
			System.out.println(view1.getAid() + "::" + view1.getAname());
		});
		System.out.println("Using result view2 as type interface");
		Iterable<ResultView2> it2 = actorRepo.findByCategoryContainingIgnoreCase("A", ResultView2.class);
		it2.forEach(view2 -> {
			System.out.println(view2.getCategory() + "::" + view2.getMobileNo());
		});

		System.out.println("Using result view3 as type interface");
		Iterable<ResultView3> it3 = actorRepo.findByCategoryContainingIgnoreCase("A", ResultView3.class);
		it3.forEach(view3 -> {
			System.out.println(view3.getCategory() + "::" + view3.getAid() + " " + view3.getAname());
		});

		System.out.println("==============================SET NEW NAME");
		Actor actor = new Actor();
		actor.setAname("Ranveer");
		System.out.println("Object save with actor repo" + actorRepo.save(actor).getAid() + "Value::");

	}

}
