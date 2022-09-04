package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {

	@Query("update Account set amount=amount-:amount where accountNo=:srcAccNo")
	@Modifying
	public int withdrawMoney(long srcAccNo, double amount);

	@Query("update Account set amount=amount+:amount where accountNo=:destAccNo")
	@Modifying
	public int depositeMoney(long destAccNo, double amount);

}
