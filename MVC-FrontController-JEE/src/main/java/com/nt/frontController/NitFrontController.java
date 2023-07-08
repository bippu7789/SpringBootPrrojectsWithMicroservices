package com.nt.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.controller.LinksController;

@WebServlet("/")
public class NitFrontController extends HttpServlet {
	private LinksController handler = null;

	@Override
	public void init() throws ServletException {
		super.init();

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lvn = null;
		if (req.getServletPath().equalsIgnoreCase("/wish")) {
			lvn = handler.showWishMessage(req);
		} else if (req.getServletPath().equalsIgnoreCase("/lang")) {
			lvn = handler.showAllLanguage(req);
		} else
			throw new IllegalArgumentException("invalid  servlet path");
		// view message
		String destPage = null;
		if (lvn.equalsIgnoreCase("wish_result"))
			destPage = "/show_wish.jsp";
		else if (lvn.equalsIgnoreCase("all_lang"))
			destPage = "/show_languages.jsp";
		else
			throw new IllegalArgumentException("invalid LVN");
		// forward the request to dest
		RequestDispatcher td = req.getRequestDispatcher(destPage);
		td.forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
