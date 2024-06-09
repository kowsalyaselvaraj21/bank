package com.techymeet.jdbcproject.dao;

import java.util.ArrayList;

import com.techymeet.jdbcproject.vo.BankVO;

public interface BankDao {

	int createAccount(BankVO bankVO);

	ArrayList<BankVO> listAccounters();

	BankVO viewAccounter(int userId);

	int editAccounter(BankVO bankVO);

	int deleteAccounter(int userId);

	ArrayList<BankVO> searchAccounter(BankVO bankvo);

}
