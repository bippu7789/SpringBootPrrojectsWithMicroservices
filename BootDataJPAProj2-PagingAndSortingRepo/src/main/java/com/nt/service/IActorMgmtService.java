//IActorMgmtService.java
package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Actor;

public interface IActorMgmtService {
	public Iterable<Actor> showActorsByOrder(boolean asc, String... properties);

	public Page<Actor> showPageRecords(int pageNumber, int pageSize);

	public void showActorsByPage(int pageSize);

}
