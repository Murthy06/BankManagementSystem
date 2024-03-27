package org.jsp.bank.dao;

import org.jsp.bank.model.BankUserDetails;

public interface AdminDAO {
	public boolean adminLogin(String emailId,String password);
	public void userRegistration(BankUserDetails bankUserDetails);
	public void selectingAllUserDetails();
	public void updateDetails();
	public void deleteUserDetails(int accountNumber);
}
