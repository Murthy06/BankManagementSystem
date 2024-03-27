package org.jsp.bank.dao;

public class AdminHelperClass {
	public static AdminDAO adminHelperMethod()
	{
		AdminDAO adminDao=new AdminDAOimp();
		return adminDao;
	}
}
