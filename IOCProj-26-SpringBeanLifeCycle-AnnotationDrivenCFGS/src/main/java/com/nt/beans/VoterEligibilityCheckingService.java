package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("voting")
@PropertySource("com/nt/commons/Info.properties")
public class VoterEligibilityCheckingService {
	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private int age;
	private Date verifiedOn;

	public VoterEligibilityCheckingService() {
		System.out.println("VoterEligibilityCheckingService-0  param constructor");
	}

	public void setName(String name) {
		System.out.println("VoterEligibilityCheckingService.setName()");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("VoterEligibilityCheckingService.setage()");
		this.age = age;
	}

	// Init lifecycle method
	@PostConstruct
	public void myInit() {
		System.out.println("VoterEligibilityCheckingService.myinit");
		verifiedOn = new Date();
		if (name == null || age < 0) {
			throw new IllegalArgumentException("Plese provide the valid input(name and age)");
		}
	}

	// destroy life cycle method
	@PreDestroy
	public void myDestroy() {
		System.out.println("VoterEligibilityCheckingService.myDestroy");
		name = null;
		age = 0;
		verifiedOn = null;
	}

	// b method
	public String checkVoterEligibility() {
		System.out.println("VoterEligibilityCheckingService.checkVoterEligibility()");
		if (age < 18) {
			return "Mr./Mrs" + name + "You are not eligible for voting";
		} else {
			return "Mr./Mrs." + name + "You are eligible for voting";
		}
	}

}
