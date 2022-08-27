//PagingAndSortingTestRunner
package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

@Component
public class PagingAndSortingTestRunner implements CommandLineRunner {
	@Autowired
	private IActorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		service.showActorsByOrder(false, "aname").forEach(System.out::println);
		System.out.println("Find all pagable<T> page");
		Page<Actor> page = service.showPageRecords(2, 3);
		List<Actor> list = page.getContent();
		System.out.println("Records are::");
		list.forEach(System.out::println);
		System.out.println("Other info about page");
		System.out.println("current page number" + page.getNumber());
		System.out.println("Current total pages:" + page.getTotalPages());
		System.out.println("Total records" + page.getTotalElements());
		System.out.println("Is it first records" + page.isFirst());
		System.out.println("Is it last records" + page.isLast());
		System.out.println("Find all pagble pagble() call::");
		service.showActorsByPage(3);

	}

}
