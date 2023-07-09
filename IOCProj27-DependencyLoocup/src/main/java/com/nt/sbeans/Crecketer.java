package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("cktr")
@PropertySource(value = "classpath:com/nt/commons/Info.properties")
public class Crecketer {
	@Value("${cktr.name}")
	private String name;

	@Value("${cktr.jersyNo}")
	private int jersiNo;

	public Crecketer() {
		System.out.println("Crecketer::0-param constructer");
	}

	public void fielding() {
		System.out.println(name + ": with jersyNo::" + jersiNo + "is fielding");
	}

	public void bouling() {
		System.out.println(name + ": with jersyNo::" + jersiNo + "is bouling");
	}

	public void bicketKeeping() {
		System.out.println(name + ": with jersyNo::" + jersiNo + "is bicketkeeping");
	}

	public void batting() {
		// Create an extra IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// Perform dependency loocup to get bean object (Dependent class object)
		// Crecket bat =ctx.getBeans("bat",CricketBat.class)
		CricketBat bat = ctx.getBean(CricketBat.class);// Loocup with dependent class name
		// invoke the b method
		int runs = bat.scoreRuns();
		System.out.println(name + "with" + jersiNo + "has scored" + runs + "runs");
		// here the second IOC container and its bean are vanished

	}

}
