package com.nt.service;

import java.util.List;

import com.nt.entity.Actor;

public interface IActorService {
	public String removeActorsByIdSinBatch(List<Integer> ids);

	public Actor searchActorById(int aid);

	public List<Actor> searchActorByActor(Actor actor, boolean order, String... properties);

}
