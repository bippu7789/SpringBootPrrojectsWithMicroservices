package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IBankService;

@Component
public class TxnMnmtTestRunner implements CommandLineRunner {
	@Autowired
	private IBankService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			String msz = service.transferMonet(32482612962L, 32482612963L, 500000);
			System.out.println(msz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
