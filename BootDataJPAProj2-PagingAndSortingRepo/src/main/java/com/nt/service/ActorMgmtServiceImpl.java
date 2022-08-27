//ActorMgmtServiceImpl.java
package com.nt.service;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service("ActorService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired // Injects InMemory Proxy class obj that implementing our custom Repository(I)
	private IActorRepository actorRepo;

	@Override
	public Iterable<Actor> showActorsByOrder(boolean asc, String... properties) {
		// prepare sort object
		// Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,properties);
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		// get record by applying sorting
		Iterable<Actor> it = actorRepo.findAll(sort);
		return it;

	}

	@Override
	public Page<Actor> showPageRecords(int pageNumber, int pageSize) {
		// Create pagablee object
		PageRequest pagable = PageRequest.of(pageNumber, pageSize);
		// get given page records
		Page<Actor> page = actorRepo.findAll(pagable);
		return page;
	}

	@Override
	public void showActorsByPage(int pageSize) {
		long recordCount = actorRepo.count();
		long pagesCount = recordCount / pageSize;
		pagesCount = (recordCount % pageSize == 0) ? pagesCount : ++pagesCount;
		for (int i = 0; i < pagesCount; ++i) {
			PageRequest pageble = PageRequest.of(i, pageSize);
			Page<Actor> page = actorRepo.findAll(pageble);
			System.out.println((i + 1) + "page Records");
			page.getContent().forEach(System.out::println);

		}
	}

}// class