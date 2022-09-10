package com.nt.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonInfoManagementService;

public class LOBTestRunner1 implements CommandLineRunner {
	@Autowired
	IPersonInfoManagementService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			// Logic to retrive the object
			// invoke method
			PersonInfo info = service.getPersonByPid(3);
			if (info != null) {
				System.out
						.println(info.getPid() + " " + info.getPname() + " " + info.getMarried() + " " + info.getDob());
				byte[] photoContent = info.getPhoto();
				char[] resumeContent = info.getResume();
				// Create new file
				FileOutputStream fos = new FileOutputStream("new_photu.jpg");
				fos.write(photoContent);
				fos.close();
				// Create resume file
				FileWriter writer = new FileWriter("resume.txt");
				writer.write(resumeContent);
				writer.close();
				System.out.println("Files are retrived and saved");
			} else {
				System.out.println("records not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
