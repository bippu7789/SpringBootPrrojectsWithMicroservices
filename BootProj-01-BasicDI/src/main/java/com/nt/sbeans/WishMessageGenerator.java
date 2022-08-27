package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired
	private LocalDateTime ldt;// HAS a properties

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.WishMessageGenerator()-o param constructor");
	}

	// develop b methods
	public String showWishMesaage(String user) {
		System.out.println("WishMessageGenerator.showWishMesaage()");
		// get current hour of the day
		int hour = ldt.getHour();// in 24 hours formate
		// generate the wish message
		if (hour < 12)
			return "Good Morning";
		else if (hour < 16)
			return "Good AfterNoon";
		else if (hour < 20)
			return "Good evening";
		else
			return "Good night";
	}

}
