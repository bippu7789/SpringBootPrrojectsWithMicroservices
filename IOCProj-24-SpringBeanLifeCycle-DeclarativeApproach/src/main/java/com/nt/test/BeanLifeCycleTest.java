package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VoterEligibilityCheckingService;

public class BeanLifeCycleTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get spring bean object refrence
		VoterEligibilityCheckingService service = ctx.getBean(VoterEligibilityCheckingService.class);
		// Invoke the b method
		String result = service.checkVotingeligility();
		System.out.println(result);
		// Close the coontainer
		ctx.close();
	}

}
