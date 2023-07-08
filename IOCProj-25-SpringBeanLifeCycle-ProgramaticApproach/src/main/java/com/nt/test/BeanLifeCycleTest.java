package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VoterEligibilityCheckingService;

public class BeanLifeCycleTest {

	public static void main(String[] args) {
		// Create container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get spring bean class object reference
		VoterEligibilityCheckingService service = ctx.getBean(VoterEligibilityCheckingService.class);
		// Invoking the b method
		String result = service.checkVotingEligibility();
		System.out.println(result);
		// close the container
		ctx.close();

	}

}
