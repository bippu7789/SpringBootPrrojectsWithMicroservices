package com.nt.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.helper.TechChasersHelper;
import com.nt.model.TechChasers;
import com.nt.repository.TechChasersRepository;

@Service
public class TechChasersService {

	@Autowired
	TechChasersRepository repository;

	public ByteArrayInputStream load() {
		List<TechChasers> tutorials = repository.findAll();

		ByteArrayInputStream in = TechChasersHelper.tutorialsToExcel(tutorials);
		return in;
	}

}
