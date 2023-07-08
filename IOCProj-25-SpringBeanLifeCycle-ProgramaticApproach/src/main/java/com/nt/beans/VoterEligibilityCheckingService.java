package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class VoterEligibilityCheckingService implements InitializingBean, DisposableBean {

	private String name;
	private int age;
	private Date verifiedOn;

	public VoterEligibilityCheckingService() {
		System.out.println("VoterEligibilityCheckingService()");

	}

	public void setName(String name) {
		System.out.println("VoterEligibilityCheckingService.setName()");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("VoterEligibilityCheckingService.setAge()");
		this.age = age;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("VoterEligibilityCheckingService.destroy()");
		name = null;
		age = 0;
		verifiedOn = null;

	}

// afterPropertiesSet init lifeCycle method
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("VoterEligibilityCheckingService.afterPropetiesSet()");
		verifiedOn = new Date();
		if (name == null || age < 0) {
			throw new IllegalArgumentException("Invalid input name or age");
		}

	}

	// b logic
	public String checkVotingEligibility() {
		System.out.println("VoterEligibilityCheckingService.checkVotingEligibility()");
		if (age < 18) {
			return "Mr./Mrs." + name + "You are not eligible for voting";
		} else {
			return "Mr./Mrs" + name + "You are eligible for voting";
		}
	}

}
