package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VoterEligibilityCheckingService;

public class BeanLifecycleTest {

	public static void main(String[] args) {
		// Create container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Spring bean class object reference
		VoterEligibilityCheckingService service = ctx.getBean("voting", VoterEligibilityCheckingService.class);
		// Invoking the b method
		String result = service.checkVoterEligibility();
		System.out.println(result);
		// close the container
		ctx.close();

	}

}
