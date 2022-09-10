package com.nt.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;

@Component
public class Calling_PL_ProcedureTrstRunner implements CommandLineRunner {
	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {

		// Create stored procedure object having PL/SQL Procedure name result type
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_ACTORS_BY_CATEGORIES", Actor.class);
		// register IN,OUT param PL/SQL procedure
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Actor.class, ParameterMode.REF_CURSOR);// registoring out parametre
		// set vallue to in param
		query.setParameter(1, "ASE");
		query.setParameter(2, "cleark");
		// call PL/SQL procedure
		List<Actor> list = query.getResultList();
		// process the result
		list.forEach(System.out::println);

	}// main

}// class
