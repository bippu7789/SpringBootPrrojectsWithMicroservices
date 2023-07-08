package com.nt.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.service.ILinksService;
import com.nt.service.LinksServiceImpl;

public class LinksController {
	private ILinksService service;

	public LinksController() {
		service = new LinksServiceImpl();

	}

	public String showWishMessage(HttpServletRequest req) {
		String result = service.generateWishMessage();
		// keep result in request scope
		req.setAttribute("wmsg", result);
		// return logical view name
		return "wish_result";

	}

	public String showAllLanguage(HttpServletRequest req) {
		// use service
		Set<String> langSet = service.fetchAllLanguages();
		// keep result in result scope
		req.setAttribute("lang_Info", langSet);
		// LVN
		return "all_language";
	}

}
