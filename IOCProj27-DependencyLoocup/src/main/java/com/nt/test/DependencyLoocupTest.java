package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Crecketer;

public class DependencyLoocupTest {

	public static void main(String[] args) {
		// Create the container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get target class object
		Crecketer cktr = ctx.getBean("cktr",Crecketer.class);
		cktr.batting();
		cktr.bouling();
		cktr.fielding();
		// Close the container
		ctx.close();

	}

}
