package org.jsp.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class UserDAOimp implements UserDAO {
	final private String selectAccNumAndPassword = "select * from bank_user_details where User_Account_Number=? and User_Password=?";
	final private String url="jdbc:mysql://localhost:3306/advancejavaproject?user=root&password=12345";
	final private String select="select * from bank_user_details where User_Bank_Email_Id=? and User_Password=?";
	final private String update= "update bank_user_details set User_Amount=? where User_Password=?";
	final private String insertIntoStatement="insert into statement values (?,?,?,?,?,?,?,?,?)";
	final private String selectmobile="select * from bank_user_details where User_Mobile_Number=?";
	final private String updateamount="update bank_user_details set User_Amount=? where User_Mobile_Number=?";
	Scanner scanner = new Scanner(System.in);

	@Override
	public boolean userLogin(String bankEmailId, int password) {
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setString(1, bankEmailId);
			ps.setInt(2, password);
			ResultSet set = ps.executeQuery();
			if(set.next()) {
				return true;
			}
			else {
				return false;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void debit(int accountNumber, int password) {
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(selectAccNumAndPassword);
			ps.setInt(1, accountNumber);
			ps.setInt(2, password);
			ResultSet set = ps.executeQuery();
			if(set.next()) {
				System.out.println("Enter your Amount : ");
				double amount=scanner.nextDouble();
				if(amount>=0)
				{
					double databaseamount = set.getDouble("User_Ammount");
					if(databaseamount>=amount)
					{
						double remainingamount=databaseamount-amount;
						PreparedStatement ps1= connection.prepareStatement(update);
						ps1.setDouble(1, remainingamount);
						ps1.setInt(2, password);
						int result = ps1.executeUpdate();
						if(result!=0)
						{
							System.out.println("Amount debited successfully");
						}
						else
						{
							System.out.println("Server error 404");
						}
					}
					else
					{
						System.out.println("Insufficient amount");
					}
				}
				else
				{
					System.out.println("Invalid amount");
				}
			}else {
				System.out.println("Invalid Account Details.");
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override									//Senders mobile number
	public void mobileToMobileTransaction(String mobilenumber)
	{
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(selectmobile);
			ps.setString(1, mobilenumber);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Enter receivers mobile number");
				String rmobilenumber=scanner.next();
				PreparedStatement psr=connection.prepareStatement(selectmobile);
				psr.setString(1, rmobilenumber);
				ResultSet setr=psr.executeQuery();
				if(setr.next())
				{
					System.out.println("Enter your amount");
					double useramount=scanner.nextDouble();
					if(useramount>=0)
					{
						double senderdatabaseamount=rs.getDouble("User_Amount");
						if(senderdatabaseamount>=useramount)
						{
							double debit=senderdatabaseamount-useramount;
							PreparedStatement psu = connection.prepareStatement(updateamount);
							psu.setDouble(1, debit);
							psu.setString(2, mobilenumber);
							int result=psu.executeUpdate();
							if(result!=0)
							{
								PreparedStatement pssus=connection.prepareStatement(insertIntoStatement);
								pssus.setString(1, "Debit");
								pssus.setDate(2, Date.valueOf(LocalDate.now()));
								pssus.setString(2,"Mobile Transaction");
								Random random = new Random();
								int transactionId = random.nextInt(10000000);
								if(transactionId<1000000)
								{
									transactionId+=1000000;
								}
								pssus.setInt(4, transactionId);
								pssus.setString(5, useramount+"Dr");
								pssus.setInt(6, rs.getInt("User_Id"));
								pssus.setInt(7, rs.getInt("Bank_Account_Number"));
								pssus.setTime(8, Time.valueOf(LocalTime.now()));
								pssus.setString(9, debit+"Rs");
								int statementResult=pssus.executeUpdate();
								if(statementResult!=0)
								{
									PreparedStatement psrus = connection.prepareStatement(insertIntoStatement);
									psrus.setString(1, "Credit");
									psrus.setDate(2, Date.valueOf(LocalDate.now()));
									psrus.setString(3, "Mobile Transaction");
									Random random1 = new Random();
									int transactionId1 = random1.nextInt(10000000);
									if(transactionId1<1000000)
									{
										transactionId1+=1000000;
									}
									psrus.setInt(4, transactionId1);
									//Amount
									psrus.setString(5, useramount+"Cr");
									
									//Id
									psrus.setInt(6, setr.getInt("User_Id"));
									
									//Account Number
									psrus.setInt(7, setr.getInt("Bank_Account_Number"));
									
									//Time
									psrus.setTime(8, Time.valueOf(LocalTime.now()));
									
									
									
								}
							}
							else
							{
								
							}
						}
						else
						{
							System.out.println("Insufficient amount");
						}
					}
				}
				else
				{
					System.out.println("Invalid Data");
				}
			}
			else
			{
				System.out.println("Invalid mobile number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}