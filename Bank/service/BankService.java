package com.techymeet.jdbcproject.service;

import java.util.ArrayList;

import com.techymeet.jdbcproject.bo.BankBO;

public interface BankService {

	int createAccount(BankBO bankBO);

	ArrayList<BankBO> listAccounters();

	BankBO viewAccounter(int userId);

	int editAccounter(BankBO bankBO);

	int deleteAccounter(int userId);

	ArrayList<BankBO> searchAccounter(BankBO bankbo);

}
