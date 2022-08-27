package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01BasicDiApplication {
	// Predefined class as spring bean using spring
	@Bean(name = "ldt")
	public LocalDateTime createLDT() {
		System.out.println("BootProj01BasicDiApplication.createLDT()");
		return LocalDateTime.now();// Static factory method given
									// Local date time Class obj having system date and time
	}

	public static void main(String[] args) {
		// get IOC container from Spring application.run(-,-)
		ApplicationContext ctx = SpringApplication.run(BootProj01BasicDiApplication.class, args);
		// get target spring bean class object
		WishMessageGenerator generator = ctx.getBean("wmg", WishMessageGenerator.class);
		// invoke the b.method
		String result = generator.showWishMesaage("BIPIN");
		System.out.println("Result::" + result);
		// close the container (optional but recomonded)
		((ConfigurableApplicationContext) ctx).close();
	}

}
