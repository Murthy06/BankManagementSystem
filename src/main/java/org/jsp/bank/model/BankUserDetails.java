package org.jsp.bank.model;

import java.time.LocalDate;

public class BankUserDetails {
	private int userId;
	private String userName;
	private String userBankEmailId;
	private String userEmailId;
	private int userPassword;
	private String userGender;
	private String userAddress;
	private LocalDate userDateOfBirth;
	private int userAccountNumber;
	private double userAmount;
	private String userMobileNumber;
	private String ifscCode;
	
	public BankUserDetails() {
		
	}
	
	public BankUserDetails(int userId, String userName, String userBankEmailId, String userEmailId, int userPassword,
			String userGender, String userAddress, LocalDate userDateOfBirth, int userAccountNumber, double userAmount,
			String userMobileNumber, String ifscCode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userBankEmailId = userBankEmailId;
		this.userEmailId = userEmailId;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userAddress = userAddress;
		this.userDateOfBirth = userDateOfBirth;
		this.userAccountNumber = userAccountNumber;
		this.userAmount = userAmount;
		this.userMobileNumber = userMobileNumber;
		this.ifscCode = ifscCode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBankEmailId() {
		return userBankEmailId;
	}
	public void setUserBankEmailId(String userBankEmailId) {
		this.userBankEmailId = userBankEmailId;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public int getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(int userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public LocalDate getUserDateOfBirth() {
		return userDateOfBirth;
	}
	public void setUserDateOfBirth(LocalDate userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}
	public int getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(int userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public double getUserAmount() {
		return userAmount;
	}
	public void setUserAmount(double userAmount) {
		this.userAmount = userAmount;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	
	
}