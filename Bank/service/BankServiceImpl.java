package com.techymeet.jdbcproject.service;

import java.util.ArrayList;

import com.techymeet.jdbcproject.bo.BankBO;
import com.techymeet.jdbcproject.dao.BankDao;
import com.techymeet.jdbcproject.dao.BankDaoImpl;
import com.techymeet.jdbcproject.vo.BankVO;

public class BankServiceImpl implements BankService {

	BankDao bankDao = new BankDaoImpl();

	@Override
	public int createAccount(BankBO bankBO) {

		BankVO bankVO = new BankVO();
		int status = 0;
		try {
			bankVO.setAccounterName(bankBO.getAccounterName());
			bankVO.setAccountNumber(bankBO.getAccountNumber());
			bankVO.setEmailAddress(bankBO.getEmailAddress());
			bankVO.setPassword(bankBO.getPassword());
			bankVO.setMobileNumber(bankBO.getMobileNumber());
			bankVO.setAdharNumber(bankBO.getAdharNumber());
			bankVO.setAddress(bankBO.getAddress());
			status = bankDao.createAccount(bankVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public ArrayList<BankBO> listAccounters() {
		ArrayList<BankBO> bankBOList = new ArrayList<>();

		try {
			ArrayList<BankVO> bankVOList = bankDao.listAccounters();

			if (!bankVOList.isEmpty() && bankVOList.size() > 0) {

				for (BankVO bankVO : bankVOList) {
					BankBO bankBO = new BankBO();
					bankBO.setUserId(bankVO.getUserId());
					bankBO.setAccounterName(bankVO.getAccounterName());
					bankBO.setAccountNumber(bankVO.getAccountNumber());
					bankBO.setEmailAddress(bankVO.getEmailAddress());
					bankBO.setPassword(bankVO.getPassword());
					bankBO.setMobileNumber(bankVO.getMobileNumber());
					bankBO.setAdharNumber(bankVO.getAdharNumber());
					bankBO.setAddress(bankVO.getAddress());
					bankBOList.add(bankBO);
				}
			}
 	} catch (Exception e) {
			e.printStackTrace();
		}

		return bankBOList;
	}

	@Override
	public BankBO viewAccounter(int userId) {
		BankBO bankBO = new BankBO();
		try {
			BankVO bankVO = bankDao.viewAccounter(userId);
			if (null != bankVO) {
				bankBO.setUserId(bankVO.getUserId());
				bankBO.setAccounterName(bankVO.getAccounterName());
				bankBO.setAccountNumber(bankVO.getAccountNumber());
				bankBO.setEmailAddress(bankVO.getEmailAddress());
				bankBO.setPassword(bankVO.getPassword());
				bankBO.setMobileNumber(bankVO.getMobileNumber());
				bankBO.setAdharNumber(bankVO.getAdharNumber());
				bankBO.setAddress(bankVO.getAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankBO;
	}

	@Override
	public int editAccounter(BankBO bankBO) {
		BankVO bankVO = new BankVO();
		int status = 0;
		try {
			bankVO.setUserId(bankBO.getUserId());
			bankVO.setAccounterName(bankBO.getAccounterName());
			bankVO.setAccountNumber(bankBO.getAccountNumber());
			bankVO.setEmailAddress(bankBO.getEmailAddress());
			bankVO.setPassword(bankBO.getPassword());
			bankVO.setMobileNumber(bankBO.getMobileNumber());
			bankVO.setAdharNumber(bankBO.getAdharNumber());
			bankVO.setAddress(bankBO.getAddress());
			status = bankDao.editAccounter(bankVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int deleteAccounter(int userId) {
		int status = 0;
		try {
			status = bankDao.deleteAccounter(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
 

	@Override
	public ArrayList<BankBO> searchAccounter(BankBO bankbo) {
		ArrayList<BankBO> bankBOList = new ArrayList<>();
		BankVO bankvo = new BankVO();
		try {
			bankvo.setAccounterName(bankbo.getAccounterName());

			ArrayList<BankVO> bankVOList = bankDao.searchAccounter(bankvo);

			for (BankVO bankVO : bankVOList) {
				BankBO bankBO = new BankBO();
				bankBO.setUserId(bankVO.getUserId());
				bankBO.setAccounterName(bankVO.getAccounterName());
				bankBO.setAccountNumber(bankVO.getAccountNumber());
				bankBO.setEmailAddress(bankVO.getEmailAddress());
				bankBO.setPassword(bankVO.getPassword());
				bankBO.setMobileNumber(bankVO.getMobileNumber());
				bankBO.setAdharNumber(bankVO.getAdharNumber());
				bankBO.setAddress(bankVO.getAddress());
				bankBOList.add(bankBO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bankBOList;
	}

}
