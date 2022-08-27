package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IEmployeeManagmentService;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Spring bean class object (Service class object)
		IEmployeeManagmentService service = ctx.getBean("empService", IEmployeeManagmentService.class);
		try {
			System.out.println("Employeess count::" + service.fetchEmpsCounts());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		ctx.close();
	}

}
