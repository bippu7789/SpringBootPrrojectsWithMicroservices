package com.nt.runners;

import org.springframework.boot.CommandLineRunner;

public class AlertServiceRunner implements CommandLineRunner {

	public AlertServiceRunner() {
		System.out.println("AlertServiceRunner::0 param constructor");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Alert service runner");
		System.out.println("Command line arguments are::");
		for (String arg : args) {
			System.out.println(arg);
		}

	}

}
