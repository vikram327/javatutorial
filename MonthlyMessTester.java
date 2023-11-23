package tester;

import java.time.LocalDate;
import java.util.*;
import static utils.MessUtils.populateMap;
import core.*;
import exceptions.CustomException;
import utils.*;

public class MonthlyMessTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int ch;

			Map<String, Customer> customerMap = populateMap();
			System.out.println("Enter file name : ");
			String fileName = sc.next();

			do {
				System.out.println("========================================================================================================================================================");
				System.out.println("1. Sign up Customer\r\n" 
						+ "2) If already register then sign in\r\n"
						+ "3) Change Password  \r\n" 
						+ "4) Sort Customer as per \r\n" 
						+ "\tA) First name \r\n" + "\tB) According to plan\r\n" + "\tC) According to date of registration\r\n"
						+ "5) Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))\r\n"
						+ "6) Display all Customers\r\n"
						+ "7) Modify all customers first Letter capital of customers first name\r\n"
						+ "8) Display email addresses of the customers who did registration in month of January\r\n"
						+ "9) Display count of the Customers who have register for plan: Monthly\r\n"
						+ "10) Search the Customer who lived in Akurdi.\r\n"
						+ "11) Give the 20% discount to the customers who have selected plan for 1 year.\r\n"
						+ "0) Exit");
				System.out.println("Enter your choice : ");
				ch = sc.nextInt();
				try {
					switch (ch) {
					case 1:
						//Sign up Customer
						System.out.println("Enter firstName, lastName, email Id , password, address, phoneNo, registrationDate, finalAmount, plan");
						//validationRules.validateAndAddUser(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()),sc.nextDouble(),Plan.valueOf(sc.next().toUpperCase()), customerMap);
						serialization.generateBinaryData(customerMap, fileName);
						System.out.println("Customer added successfully ...");
						break;
						
					case 2:
						//Sign in Customer
						System.out.println("Enter email Id and Password : ");
						MessUtils.loginUser(sc.next(),sc.next(),customerMap);
						break;
						
					case 3:
						//Change Password 
						System.out.println("Enter Email Id,Old password,New Password :");
						MessUtils.changePassword(sc.next(), sc.next(), sc.next(), customerMap);
						//To store updated password into file 
						serialization.generateBinaryData(customerMap, fileName); 
						break;
						
					case 4:
						System.out.println("1.Sort by First name  2.Sort by Plan  3.Sort by Date of Registration ");
						System.out.println("Enter your choice : ");
						switch (sc.nextInt()) {
						case 1:
							MessUtils.sortByFirstName(customerMap);
							break;
						case 2:
							MessUtils.sortByPlan(customerMap);
							break;
						case 3:
							MessUtils.sortByDateOfRegistration(customerMap);
							break;
						default:
							System.out.println("Enter valid choice ...");
							break;
						}
						break;
					case 5:
						//Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))
						MessUtils.removeCustomers(customerMap);
						System.out.println("Customers unsubscribed successfully ...");
						break;
					case 6:
						//Display all Customers
						customerMap.values().stream().forEach(p -> System.out.println(p));
						deSerialization.restoreFromBinaryData(fileName);
						break;
					case 7:
						//Modify all customers first Letter capital of customers first name
						MessUtils.capitalFirstLetterOfFname(customerMap);
						System.out.println("First names updated successfully ...");
						break;
						
					case 8:
						//Display email addresses of the customers who did registration in month of January
						MessUtils.getRegisteredInMonth(customerMap);
						break;
						
					case 9 :
						//Display count of the Customers who have register for plan: Monthly
						System.out.println("Customers registered for Monthly plan : ");
						MessUtils.registeredForMonthly(customerMap);
						break;
						
					case 10 :
						//Search the Customer who lived in Akurdi
						System.out.println("Customers living in Akurdi : ");
						MessUtils.getCustomersInAkurdi(customerMap);
						break;
						
					case 11:
						//Give the 20% discount to the customers who have selected plan for 1 year
						System.out.println("Discount applied successfully ...");
						MessUtils.applyDiscount(customerMap);
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}

			} while (ch != 0);
		}

	}

}
