package com.nt.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LinksServiceImpl implements ILinksService {
	@Override
	public Set<String> fetchAllLanguages() {
		Locale locale[] = Locale.getAvailableLocales();
		Set<String> langSet = new HashSet<String>();
		for (Locale l : locale) {
			langSet.add(l.getDisplayLanguage());
		}
		return langSet;
	}

	@Override
	public String generateWishMessage() {
		// get system date time
		LocalDateTime ldt = LocalDateTime.now();
		// get current hour of the dat
		int hour = ldt.getHour();
		if (hour < 12) {
			return "Good Moring";
		} else if (hour < 16) {
			return "Good After noon";
		} else if (hour < 20) {
			return "Good Evening";
		} else {
			return "Good Night";
		}

	}

}
