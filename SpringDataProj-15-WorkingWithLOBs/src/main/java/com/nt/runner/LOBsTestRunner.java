package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonInfoManagementService;

public class LOBsTestRunner implements CommandLineRunner {

	@Autowired
	IPersonInfoManagementService service;

	@Override
	public void run(String... args) throws Exception {

		// read input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter person name::");
		String name = sc.next();
		System.out.println("Enter DOBT(YYYYMMDDhhmmss::)");
		String dob = sc.next();
		System.out.println("Is the person married::");
		Boolean ms = sc.nextBoolean();
		System.out.println("Enter photo file path::");
		String photuPath = sc.next();
		System.out.println("Enter resume file path");
		String resumePath = sc.next();
		// Converting string date value to Local date time obj

		LocalDateTime ldt = LocalDateTime.parse(dob);
		// prepare byte from the photu file content
		File file1 = new File(photuPath);
		FileInputStream fis = new FileInputStream(file1);
		byte[] photuContent = new byte[(int) file1.length()];
		fis.read(photuContent);

		// prepare char for the resume file content
		File file2 = new File(resumePath);
		FileReader reader = new FileReader(file2);

		char[] resumecontent = new char[(int) file2.length()];
		reader.read(resumecontent);
		// Create entity class object
		PersonInfo info = new PersonInfo();
		info.setPname(name);
		info.setMarried(ms);
		info.setDob(ldt);
		info.setPhoto(photuContent);
		info.setResume(resumecontent);

		// save the object
		try {
			System.out.println(service.registerPerson(info));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
