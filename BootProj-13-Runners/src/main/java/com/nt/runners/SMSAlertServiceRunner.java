package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SMSAlertServiceRunner implements ApplicationRunner {
	public SMSAlertServiceRunner() {
		System.out.println("SMSAlertServiceRunner: 0 param constructor)");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SMSAlertServiceRunner.run()");
		System.out.println("Non options args" + args.getNonOptionArgs());
		System.out.println("Option args key" + args.getOptionNames());
		System.out.println("Option args value" + Arrays.deepToString(args.getSourceArgs()));

	}

}
