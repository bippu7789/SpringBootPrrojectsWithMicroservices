package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IActorService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IActorService service;

	@Override
	public void run(String... args) throws Exception {
		// System.out.println(service.removeActorsByIdSinBatch(List.of(34, 35, 23, 100,
		// 200)));
//		List<Integer> ids = new ArrayList<>();
//		ids.add(34);
//		ids.add(35);
//		ids.add(23);
//		ids.add(100);
//		ids.add(200);
		System.out.println("==================GetrefrenceById()=================");
		try {
			System.out.println("2ed Actor information" + service.searchActorById(20));

		} catch (Exception e) {
			System.out.println("Records not found::");
			e.printStackTrace();
		}

	}

}
