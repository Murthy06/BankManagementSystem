package org.jsp.bank;

import java.time.LocalDate;
import java.util.Scanner;

import org.jsp.bank.dao.AdminDAO;
import org.jsp.bank.dao.AdminHelperClass;
import org.jsp.bank.dao.UserDAO;
import org.jsp.bank.dao.UserHelperClass;
import org.jsp.bank.model.BankUserDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AdminDAO adminDao = AdminHelperClass.adminHelperMethod();
        UserDAO userDao = UserHelperClass.userHelperMethod();
        System.out.println("Enter \n 1. For Admin Login \n 2. For User Login");
        Scanner scanner = new Scanner(System.in);
        int welcome = scanner.nextInt();
        boolean status=true;
        while(status) {
        	switch(welcome) {
            case 1: {
            	int count=1;
            	boolean check=true;
            	while(check) {
            		System.out.println("Enter your Email-Id : ");
                	String emailId=scanner.next();
                	System.out.println("Enter your Password : ");
                	String password=scanner.next();
                	boolean result = adminDao.adminLogin(emailId, password);
                	if(result) {
                		System.out.println("Enter "
                				+ "\n 1.For User Registration "
                				+ "\n 2.For All USer Details "
                				+ "\n 3.Update Details "
                				+ "\n 4.For Delettion");
                		int choice=scanner.nextInt();
                		switch(choice) {
                		case 1:
                			BankUserDetails userDetails=new BankUserDetails();
                			System.out.println("Enter Your Name : ");
                			String name=scanner.next();
                			userDetails.setUserName(name);
                			System.out.println("Enter Your Email Id : ");
                			userDetails.setUserEmailId(scanner.next());
                			System.out.println("Enter Your Gender : ");
                			userDetails.setUserGender(scanner.next());
                			System.out.println("Enter Your Address : ");
                			userDetails.setUserAddress(scanner.next());
                			System.out.println("Enter Your Date Of Birth : ");
                			String dob=scanner.next();
                			userDetails.setUserDateOfBirth(LocalDate.parse(dob));
                			System.out.println("Enter Your Amount : ");
                			Double amount=scanner.nextDouble();
                			userDetails.setUserAmount(amount);
                			System.out.println("Enter Your Mobile Number : ");
                			String mobileNum=scanner.next();
                			userDetails.setUserMobileNumber(mobileNum);
                			adminDao.userRegistration(userDetails);
                		break;
                		case 2:
                			adminDao.selectingAllUserDetails();
                		break;
                		case 3:
                			adminDao.updateDetails();
                		break;
                		case 4:
                			System.out.println("Enter Your Account Number : ");
                			int accountNumber=scanner.nextInt();
                			adminDao.deleteUserDetails(accountNumber);
                		break;
                		default:System.out.println("Enter a Valid Choice.");
                		}
                		check=false;
                	}else {
                		System.out.println("Invalid Details.");
                		if(count==3) {
                			System.out.println("you have exceeded your limit");
                			check=false;
                		}
                		else {
                			count++;
                		}
                	}
            	}
            	break;
            }
            case 2: userDao.userLogin("qsp", 5678);
            break;
            default : System.out.println("Enter a Valid Choice.");
            }
        	System.out.println("Do You Want To Continue : \n  Yes \n  No");
        	String choice=scanner.next();
        	if(choice.equals("yes")) {
        		System.out.println("Enter \n 1. For Admin Login \n 2. For User Login");;
                welcome = scanner.nextInt();
        		status=true;
        	}
        	else {
        		System.out.println("Thank You Visit Again...!");
        		status=false;
        	}
        }
        		
    }
}