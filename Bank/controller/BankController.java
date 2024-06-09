package com.techymeet.jdbcproject.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.techymeet.jdbcproject.bo.BankBO;
import com.techymeet.jdbcproject.service.BankService;
import com.techymeet.jdbcproject.service.BankServiceImpl;

public class BankController {

	public static void main(String[] args) {
		introduction();
		Scanner scannerObj = new Scanner(System.in);
		boolean status = true;

		//accountServiceImpl.createAccount();

		while (status) {
			System.out.println();
			System.out.println("Please Choose Any One Option :");
			System.out.println("Type 1: Create Accounter");
			System.out.println("Type 2: List Accounters");
			System.out.println("Type 3: view Accounter");
			System.out.println("Type 4: Edit Accounter");
			System.out.println("Type 5: Search Account");
			System.out.println("Type 6: Delete Accounter");
			System.out.println("Type 7: Exit");
         int optionNumber = scannerObj.nextInt();
			switch (optionNumber) {
			case 1:
				createAccount();
				break;
			case 2:
				listAccounters();
				break;
			case 3:
				viewAccounter();
				break;
			case 4:
				editAccounter();
				break;
			case 5:
				searchAccounter();
				break;
			case 6:
				deleteAccounter();
				break;
			case 7:
				exit();
				status=false;
				break;
			  
			default:
				System.out.println("Please give valid option");
			}
		}

	}

	private static void createAccount() {
		BankService bankService = new BankServiceImpl();
		Scanner scannerObj = new Scanner(System.in);
		BankBO bankBO = new BankBO();
		System.out.println("Please Enter Your Personal Details!!");
		System.out.println();

		System.out.println("Please Enter Accounter Name :");
		String accounterName = null;
		boolean nameStatus = true;
		try {
			while (nameStatus) {
				accounterName = scannerObj.nextLine();
				if (!accounterName.isEmpty()) {
					bankBO.setAccounterName(accounterName);
					nameStatus = false;
				} else {
					System.out.println("Please Enter Valid Accounter Name !!!");
					System.out. println();
					System.out.println("Please Enter Accounter Name :");

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Accounter Name :" + e);
		}

		System.out.println("Please Enter Account Number :");
		long accountNumber = 0;
		boolean accNumStatus = true;
		try {
			while (accNumStatus) {
				accountNumber = scannerObj.nextLong();
				if (0 < accountNumber) {
					bankBO.setAccountNumber(accountNumber);
					accNumStatus = false;
					scannerObj.nextLine();
				} else {
					System.out.println("Please Enter Valid Account Number !!!");
					System.out.println();
					System.out.println("Please Enter Account Number :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please enter valid Account number :" + e);
		}

		System.out.println("Please Enter Email Address :");
		String emailAddress = null;
		boolean emailStatus = true;
		try {
			while (emailStatus) {
				emailAddress = scannerObj.nextLine();
				if (!emailAddress.isEmpty()) {
					bankBO.setEmailAddress(emailAddress);
					emailStatus = false;
				} else {
					System.out.println("Please Enter Valid Email Address !!!");
					System.out.println();
					System.out.println("Please Enter Email Address :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Email Address :" + e);
		}

		System.out.println("Please Enter Password :");
		String password = null;
		boolean passwordStatus = true;
		try {
			while (passwordStatus) {
				password = scannerObj.nextLine();
				if (!password.isEmpty()) {
					bankBO.setPassword(password);
					passwordStatus = false;
				} else {
					System.out.println("Please Enter Valid Password !!!");
					System.out.println();
					System.out.println("Please Enter Password :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Password :" + e);
		}

		System.out.println("Please Enter Mobile Number :");
		String mobileNum = null;
		boolean mobileStatus = true;
		try {
			while (mobileStatus) {
				mobileNum = scannerObj.nextLine();
				if (null != mobileNum && mobileNum.matches("\\d{10}")) {
					bankBO.setMobileNumber(Long.parseLong(mobileNum));
					mobileStatus = false;
					//scannerObj.nextLine();
				} else {
					System.out.println("Please Enter Valid Mobile Number !!!");
					System.out.println();
					System.out.println("Please Enter Mobile Number :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please enter valid mobile number :" + e);
		}

		System.out.println("Please Enter Adhar Number :");
		long adharNum = 0;
		boolean adharStatus = true;
		try {
			while (adharStatus) {
				adharNum = scannerObj.nextLong();
				if (0 < adharNum) {
					bankBO.setAdharNumber(adharNum);
					adharStatus = false;
					scannerObj.nextLine();
				} else {
					System.out.println("Please Enter Valid Adhar Number !!!");
					System.out.println();
					System.out.println("Please Enter Adhar Number :");
				}
			}
		} catch (Exception e) {
			System.out.println("please enter valid Adhar number :" + e);
		}

		System.out.println("Please Enter Address :");
 	String address = null;
		boolean addressStatus = true;
		try {
			while (addressStatus) {
				address = scannerObj.nextLine();
				if (!address.isEmpty()) {
					bankBO.setAddress(address);
					addressStatus = false;
				} else {
					System.out.println("Please Enter Valid Address !!!");
					System.out.println();
					System.out.println("Please Enter Address :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Address :" + e);
		}

		int status = bankService.createAccount(bankBO);

		if (0 < status) {
			System.out.println("User created sucessfully");
		} else {
			System.out.println("User creation failed");
		}
	}

	private static void listAccounters() {
		BankService bankService = new BankServiceImpl();
		try {
			ArrayList<BankBO> bankBOList = bankService.listAccounters();
			if (0 < bankBOList.size() && !bankBOList.isEmpty() && null != bankBOList) {
				for (BankBO bankBO : bankBOList) {
					System.out.println();
					System.out.println("User Id :" + bankBO.getUserId());
					System.out.println("Accounter Name :" + bankBO.getAccounterName());
					System.out.println("Account Number :" + bankBO.getAccountNumber());
					System.out.println("Email Address :" + bankBO.getEmailAddress());
					System.out.println("Password :" + bankBO.getPassword());
					System.out.println("adhar Number :" + bankBO.getAdharNumber());
					System.out.println("Address :" + bankBO.getAddress());
					System.out.println("Mobile Number :" + bankBO.getMobileNumber());
					System.out.println();
				}
			} else {
				System.out.println("No Record Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void viewAccounter() {
		BankService bankService = new BankServiceImpl();
		Scanner scannerObj = new Scanner(System.in);
		BankBO bankBO = new BankBO();
		System.out.println("Please Enter user Id :");
		int userId = 0;
		boolean userIdStatus = true;
		try {
			while (userIdStatus) {
				userId = scannerObj.nextInt();
				if (0 < userId) {
					userIdStatus = false;
					scannerObj.nextLine();
				} else {
					System.out.println("Please Enter valid User Id !!!");
					System.out.println();
					System.out.println("Please Enter User Id :");
				}
			}
			if (0 < userId) {
				bankBO = bankService.viewAccounter(userId);
				if (null != bankBO) {
					System.out.println();
					System.out.println("User Id :" + bankBO.getUserId());
					System.out.println("Accounter Name :" + bankBO.getAccounterName());
					System.out.println("Account Namuber :" + bankBO.getAccountNumber());
					System.out.println("Email Address :" + bankBO.getEmailAddress());
					System.out.println("Password :" + bankBO.getPassword());
					System.out.println("Mobile Number :" + bankBO.getMobileNumber());
					System.out.println("adhar Number :" + bankBO.getAdharNumber());
					System.out.println("Address :" + bankBO.getAddress());
					System.out.println();
				} else {
					System.out.println("UserId Not Found ");
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid User Id :" + e);
		}
	}

	private static void editAccounter() {
		System.out.println("Welcome to Edit Accounter");
		Scanner scannerObj = new Scanner(System.in);
		BankBO bankBO = new BankBO();
		BankService bankService = new BankServiceImpl();

		System.out.println("Please Enter User Id :");
		int userId = 0;
		boolean userIdStatus = true;
		try {
			while (userIdStatus) {
				userId = scannerObj.nextInt();
				if (userId > 0) {
					bankBO.setUserId(userId);
					userIdStatus = false;
					scannerObj.nextLine();
				} else {
					System.out.println("Please Enter Valid Accounter Name !!!");
					System.out.println();
					System.out.println("Please Enter Accounter Name :");

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Accounter Name :" + e);
		}

		System.out.println("Please Enter Accounter Name :");
		String accounterName = null;
		boolean nameStatus = true;
		try {
			while (nameStatus) {
				accounterName = scannerObj.nextLine();
				if (!accounterName.isEmpty()) {
					bankBO.setAccounterName(accounterName);
					nameStatus = false;
				} else {
					System.out.println("Please Enter Valid Accounter Name !!!");
					System.out.println();
					System.out.println("Please Enter Accounter Name :");

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Accounter Name :" + e);
		}

		System.out.println("Please Enter Account Number :");
		long accountNumber = 0;
		boolean accNumStatus = true;
		try {
			while (accNumStatus) {
				accountNumber = scannerObj.nextLong();
				if (0 < accountNumber) {
					bankBO.setAccountNumber(accountNumber);
					accNumStatus = false;
					scannerObj.nextLine();
				} else {
					System.out.println("Please Enter Valid Account Number !!!");
					System.out.println();
					System.out.println("Please Enter Account Number :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please enter valid mobile number :" + e);
		}

		System.out.println("Please Enter Email Address :");
		String emailAddress = null;
		boolean emailStatus = true;
		try {
			while (emailStatus) {
				emailAddress = scannerObj.nextLine();
				if (!emailAddress.isEmpty()) {
					bankBO.setEmailAddress(emailAddress);
					emailStatus = false;
				} else {
					System.out.println("Please Enter Valid Email Address !!!");
					System.out.println();
					System.out.println("Please Enter Email Address :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Email Address :" + e);
		}

		System.out.println("Please Enter Password :");
		String password = null;
		boolean passwordStatus = true;
		try {
			while (passwordStatus) {
				password = scannerObj.nextLine();
				if (!password.isEmpty()) {
					bankBO.setPassword(password);
					passwordStatus = false;
				} else {
					System.out.println("Please Enter Valid Password !!!");
					System.out.println();
					System.out.println("Please Enter Password :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Password :" + e);
		}

		System.out.println("Please Enter Mobile Number :");
		String mobileNum = null;
		boolean mobileStatus = true;
		try {
			while (mobileStatus) {
				mobileNum = scannerObj.nextLine();
				if (null != mobileNum && mobileNum.matches("\\d{10}")) {
					bankBO.setMobileNumber(Long.parseLong(mobileNum));
					mobileStatus = false;
					scannerObj.nextLine();
				} else {
					System.out.println("Please Enter Valid Mobile Number !!!");
					System.out.println();
					System.out.println("Please Enter Mobile Number :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please enter valid mobile number :" + e);
		}

		System.out.println("Please Enter Adhar Number :");
		long adharNum = 0;
		boolean adharStatus = true;
		try {
			while (adharStatus) {
				adharNum = scannerObj.nextLong();
				if (0 < adharNum) {
					bankBO.setAdharNumber(adharNum);
					adharStatus = false;
					scannerObj.nextLine();
				} else {
					System.out.println("Please Enter Valid Adhar Number !!!");
					System.out.println();
					System.out.println("Please Enter Adhar Number :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please enter valid Adhar number :" + e);
		}

		System.out.println("Please Enter Address :");
		String address = null;
		boolean addressStatus = true;
		try {
			while (addressStatus) {
				address = scannerObj.nextLine();
				if (!address.isEmpty()) {
					bankBO.setAddress(address);
					addressStatus = false;
				} else {
					System.out.println("Please Enter Valid Address !!!");
					System.out.println();
					System.out.println("Please Enter Address :");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Address :" + e);
		}

		int status = bankService.editAccounter(bankBO);

		if (0 < status) {
			System.out.println("User Updated sucessfully");
		} else {
			System.out.println("User Update failed");
		}

	}

	private static void searchAccounter() {
		System.out.println("Welcome to search Student");
		Scanner scannerObj = new Scanner(System.in);
		BankService bankService = new BankServiceImpl();
		BankBO bankbo  = new BankBO();
		System.out.println("Enter AccounterName :");
		String accounterName = null;
		boolean accounterNameStatus = true;
		try {
			while (accounterNameStatus) {
				accounterName= scannerObj.nextLine();
				if (!accounterName.isEmpty()) {
					bankbo .setAccounterName(accounterName);
					accounterNameStatus= false;
				} else {
					System.out.println("Please Enter Valid Accounter Name !!!");
					System.out.println();
					System.out.println("Please Enter Accounter Name :");

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Accounter Name :" + e);
		}

		ArrayList<BankBO> bankBOList = bankService.searchAccounter(bankbo );

		if (0 < bankBOList.size() && !bankBOList.isEmpty() && null != bankBOList) {
			for (BankBO bankBO : bankBOList) {
				System.out.println();
				System.out.println("User Id :" + bankBO.getUserId());
				System.out.println("Accounter Name :" + bankBO.getAccounterName());
				System.out.println("Account Number :" + bankBO.getAccountNumber());
				System.out.println("Email Address :" + bankBO.getEmailAddress());
				System.out.println("Password :" + bankBO.getPassword());
				System.out.println("adhar Number :" + bankBO.getAdharNumber());
				System.out.println("Address :" + bankBO.getAddress());
				System.out.println("Mobile Number :" + bankBO.getMobileNumber());
				System.out.println();
			}
		} else {
			System.out.println("No Record Found");
		}

	}

	private static void deleteAccounter() {
		System.out.println("Welcome to Delete Accounter");
		Scanner scannerObj = new Scanner(System.in);
		BankService bankService = new BankServiceImpl();
		System.out.println("Please Enter User Id :");
		int userId = 0;
		boolean userIdStatus = true;
		try {
			while (userIdStatus) {
				userId = scannerObj.nextInt();
				if (userId > 0) {
					userIdStatus = false;
					scannerObj.nextLine();
				} else {
					System.out.println("Please Enter Valid Accounter Name !!!");
					System.out.println();
					System.out.println("Please Enter Accounter Name :");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("please Enter valid Accounter Name :" + e);
		}
		int status = bankService.deleteAccounter(userId);

		if (0 < status) {
			System.out.println("User Deleted sucessfully");
		} else {
			System.out.println("User Delete failed");
		}

		System.out.println("Redirecting to List Accounters");
		listAccounters();

	}

	private static void exit() {
		System.out.println("Thank You");

	}

	public static void introduction() {
		System.out.println("Welcome to IOB Bank");

	}

}
