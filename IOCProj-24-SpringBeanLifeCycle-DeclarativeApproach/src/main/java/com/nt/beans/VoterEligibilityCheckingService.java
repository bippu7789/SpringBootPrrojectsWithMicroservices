package com.nt.beans;

import java.util.Date;

public class VoterEligibilityCheckingService {
	private String name;
	private int age;
	private Date verifiedOn;

	public VoterEligibilityCheckingService() {
		System.out.println("VoterEligibilityCheckingService::0-param-constructor");
	}

	public void setName(String name) {
		System.out.println("VoterEligibilityCheckingService.setName()");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("VoterEligibilityCheckingService.setAge()");
		this.age = age;
	}

	// init lifeCycle method
	public void myInit() {
		System.out.println("VoterEligibilityCheckingService.myInit()");
		verifiedOn = new Date();// Initialization of left over properties who are not in injectionss
		if (name == null || age < 0) {// Verification of injection value
			throw new IllegalArgumentException("Invalid input (name or age)");
		}
	}

	// Destroy life cycle method
	public void myDestroy() {
		System.out.println("VoterEligibilityCheckingService.destroy");
		name = null;
		age = 0;
		verifiedOn = null;
	}

	// Business methods
	public String checkVotingeligility() {
		System.out.println("VoterEligibilityCheckingService.checkvotingeligibility()");
		if (age < 0) {
			return "Mr./Mrs." + name + "You are not eligible for voting";
		} else {
			return "Mr./Mrs." + name + "You are eligible for voting";

		}
	}
}
