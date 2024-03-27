package org.jsp.bank.dao;

public interface UserDAO {
	public boolean userLogin(String bankEmailId, int password);
	public void debit(int accountNumber, int password);
	void mobileToMobileTransaction(String mobilenumber);
}