package com.nt.runner;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Calling_PLSQLFunctionTestRunner implements CommandLineRunner {
	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		// Unwrape the session object
		Session ses = manager.unwrap(Session.class);
		// Use work(I) callback interface to get JDBC connection object and to write
		// callable statement object bases logic call PL/SQL procedure or function
		ses.doWork(con -> {
			CallableStatement cs = con.prepareCall("{?=CALL FX_GET_ACTORS_DATA_BY_PHONES(?,?)}");
			// Create callable statement object having Query
			cs.registerOutParameter(1, Types.INTEGER);
			// set value IN param
			cs.setLong(2, 111111L);
			cs.setLong(3, 226222L);
			// Call PL/SQL function
			cs.execute();
			// gather result
			ResultSet rs = (ResultSet) cs.getObject(1);
			// process the result set object
			System.out.println(rs.getInt(1) + "" + rs.getString(2) + "" + rs.getLong(3));
		});
	}// main

}// class
