  package com.techymeet.jdbcproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techymeet.jdbcproject.utils.DataBaseConnection;
import com.techymeet.jdbcproject.vo.BankVO;

public class BankDaoImpl implements BankDao {

//	@Override
//	public int createAccount(BankVO bankVO) {
//		int status = 0;
//		try {
//			Connection con = DataBaseConnection.createConnection();
//
//			String query = "insert into users(accounter_name, account_number, email_address, password,adhar_Number, address, mobile_number) values('"
//					+ bankVO.getAccounterName() + "','" + bankVO.getAccountNumber() + "','" + bankVO.getEmailAddress()
//					+ "','" + bankVO.getPassword() + "','" + bankVO.getAdharNumber() + "','" + bankVO.getAddress()
//					+ "','" + bankVO.getMobileNumber() + "')";
//
//			Statement stmt = con.createStatement();
//
//			status = stmt.executeUpdate(query);
//			con.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return status;
//	}

	@Override
	public int createAccount(BankVO bankVO) {
		int status = 0;
		try {
			Connection con = DataBaseConnection.createConnection();
			String query = "insert into users(accounter_name, account_number, email_address, password,adhar_Number, address, mobile_number) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, bankVO.getAccounterName());
			ps.setLong(2, bankVO.getAccountNumber());
			ps.setString(3, bankVO.getEmailAddress());
			ps.setString(4, bankVO.getPassword());
			ps.setLong(5, bankVO.getAdharNumber());
			ps.setString(6, bankVO.getAddress());
			ps.setLong(7, bankVO.getMobileNumber());

			status = ps.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public ArrayList<BankVO> listAccounters() {
		ArrayList<BankVO> bankVOList = new ArrayList<>();
		try {
			Connection con = DataBaseConnection.createConnection();
			String query = "select*from users";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankVO bankVO = new BankVO();
				bankVO.setUserId(rs.getInt(1));
				bankVO.setAccounterName(rs.getString(2));
				bankVO.setAccountNumber(rs.getLong(3));
				bankVO.setEmailAddress(rs.getString(4));
				bankVO.setPassword(rs.getString(5));
				bankVO.setAdharNumber(rs.getLong(6));
				bankVO.setAddress(rs.getString(7));
				bankVO.setMobileNumber(rs.getLong(8));

				bankVOList.add(bankVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankVOList;
	}

	@Override
	public BankVO viewAccounter(int userId) {
		BankVO bankVO = new BankVO();
		try {
			Connection con = DataBaseConnection.createConnection();
			String query = "select*from  users where user_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bankVO.setUserId(rs.getInt(1));
				bankVO.setAccounterName(rs.getString(2));
				bankVO.setAccountNumber(rs.getLong(3));
				bankVO.setEmailAddress(rs.getString(4));
				bankVO.setPassword(rs.getString(5));
				bankVO.setAdharNumber(rs.getLong(6));
				bankVO.setAddress(rs.getString(7));
				bankVO.setMobileNumber(rs.getLong(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankVO;
	}
	
	String str = new String();

	@Override
	public int editAccounter(BankVO bankVO) {
		int status = 0;
		try {
			Connection con = DataBaseConnection.createConnection();
			String query = "update users SET accounter_name = ?,account_number = ?, email_address = ?, password = ?, adhar_Number = ?, address = ?, mobile_number = ? WHERE user_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bankVO.getAccounterName());
			ps.setLong(2, bankVO.getAccountNumber());
			ps.setString(3, bankVO.getEmailAddress());
			ps.setString(4, bankVO.getPassword());
			ps.setLong(5, bankVO.getAdharNumber());
			ps.setString(6, bankVO.getAddress());
			ps.setLong(7, bankVO.getMobileNumber());
			ps.setInt(8, bankVO.getUserId());
			status = ps.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteAccounter(int userId) {
		int status = 0;
		try {
			Connection con = DataBaseConnection.createConnection();
			String query = "delete from users where user_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public ArrayList<BankVO> searchAccounter(BankVO bankvo) {
		ArrayList<BankVO> bankVOList = new ArrayList<>();

		try {
			Connection con = DataBaseConnection.createConnection();
			String query = "select * from users where accounter_name like ?";
//			String query = "select * from users where accounter_name and like CONCAT( '%',?,'%')";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%" + bankvo.getAccounterName() + "%");
//			ps.setString(1, bankvo.getAccounterName());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankVO bankVO = new BankVO();
				bankVO.setUserId(rs.getInt(1));
				bankVO.setAccounterName(rs.getString(2));
				bankVO.setAccountNumber(rs.getLong(3));
				bankVO.setEmailAddress(rs.getString(4));
				bankVO.setPassword(rs.getString(5));
				bankVO.setAdharNumber(rs.getLong(6));
				bankVO.setAddress(rs.getString(7));
				bankVO.setMobileNumber(rs.getLong(8));
				bankVOList.add(bankVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bankVOList;
	}

//	@Override
//	public int createAccount(BankVO bankVO) {
//		int status = 0;
//		try {
//			Connection con = DataBaseConnection.createConnection();
//			String query = "insert into users(accounter_name, account_number, email_address, password,adhar_Number, address, mobile_number) values (?,?,?,?,?,?,?)";
//			PreparedStatement ps = con.prepareStatement(query);
//
//			ps.setString(1, bankVO.getAccounterName());
////			ps.setString(1, bankVO.getAccounterName());
//			ps.setLong(2, bankVO.getAccountNumber());
//			ps.setString(3, bankVO.getEmailAddress());
//			ps.setString(4, bankVO.getPassword());
//			ps.setLong(5, bankVO.getAdharNumber());
//			ps.setString(6, bankVO.getAddress());
//			ps.setLong(7, bankVO.getMobileNumber());
//
//			status = ps.executeUpdate();
//
//			con.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return status;
//	}

}
