package com.nt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.IAccountRepository;

@Service("bankService")
public class BankServiceImpl implements IBankService {
	@Autowired
	private IAccountRepository accountRepo;

	@Override
	@Transactional
	public String transferMonet(long srcAccNo, long destAccNo, double amount) {
		// use repository methods
		int result1 = accountRepo.withdrawMoney(srcAccNo, amount);
		int result2 = accountRepo.depositeMoney(destAccNo, amount);
		System.out.println("resulttt1::" + result1);
		System.out.println("result2::" + result2);
		if (result1 == 0 || result2 == 0) {
			throw new RuntimeException("Problem in transfer money operation");// must be unchecked exception
		}
		return "Money transfer from" + srcAccNo + "to" + destAccNo + "Amount" + amount;

	}

}
