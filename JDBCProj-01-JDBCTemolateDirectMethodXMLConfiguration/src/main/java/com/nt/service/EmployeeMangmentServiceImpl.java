package com.nt.service;

import com.nt.dao.IEmployeeDAO;

public class EmployeeMangmentServiceImpl implements IEmployeeManagmentService {
	private IEmployeeDAO dao;

	public EmployeeMangmentServiceImpl(IEmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmpsCounts() {
		int count = dao.getEmployeesCounts();
		return count;
	}
}
