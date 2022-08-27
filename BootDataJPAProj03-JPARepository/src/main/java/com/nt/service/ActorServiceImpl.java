package com.nt.service;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service("actorService")

public class ActorServiceImpl implements IActorService {

	@Autowired
	IActorRepository actorRepo;

	@Override
	public String removeActorsByIdSinBatch(List<Integer> ids) {
		List<Actor> list = actorRepo.findAllById(ids);// Jpa repository method
		int count = list.size();
		actorRepo.deleteAllByIdInBatch(ids);

		return count + "No of records are deleted in batch";
	}

	@Override
	public Actor searchActorById(int aid) {

		return actorRepo.getReferenceById(aid);
	}

	@Override
	public List<Actor> searchActorByActor(Actor actor, boolean order, String... properties) {
		// Example example = Example.of(actor);
		// sort object
		Sort sort = Sort.by(order ? Direction.ASC : Direction.DESC, properties);
		// List<Actor> list = actorRepo.findAll(example, sort);
		return null;
	}

}
