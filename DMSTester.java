package com.tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.core.Donor;
import com.core.donationFrequency;


import static com.validations.DonorClassValidations.*;
import static com.utils.DonorDataUtils.*;

public class DMSTester {

	public static void main(String[] args) {
		
		Map<String,Donor> donarMap=new HashMap<>();
		donarMap=populateData();
		
		boolean exit=false;
		try(Scanner sc=new Scanner(System.in))
		{
			do
			{
			
			
			
			System.out.println(
							"1.Signup for new Donar\n"+
							"2.Signin if Already exist\n"+
							"3.Display All Donars\n"+
							"4.Sort Donar as per Donation Amount Descending\n"+
							"5.Display all Donar who donates monthly\n"+
							"6.Display all donar who donates in the month of April\n"+
							"7.Load Data From File\n"+
							"8.Exit\n"
					);
			
			System.out.print("Enter Choice : ");
			switch(sc.nextInt()) {
			
			case 1:{
				
				
//				String fname, String lname, String phoneNo, String email, 
//				String password, String address,
//				double amount, LocalDate donationDate, donationFrequency dFreq
				System.out.println("Enter FirstName,LastName,PhoneNo,Email,Password,Address,Amount,DonationDate(YYYY-MM-DD),Donation Frequency(onetime,monthly,yearly)");
			
				validateAllInput(sc.next(), sc.next(), sc.next(), validateEmail(sc.next()), sc.next(), sc.next(), sc.nextDouble(), parseDate(sc.next()), parseFrequency(sc.next()), donarMap);
				System.out.println("Donar Added..!!");
				
				
				
				break;
			}
			case 2:{
				System.out.println("Enter Email and Password");
				Donor login=authenticateDonar(sc.next(), sc.next(), donarMap);
				System.out.println("Welcome, "+login.getFname()+" logged in..!!!");
				break;
			}
			case 3:{
				System.out.println("Displaying All Donors");
				donarMap.values().stream().forEach(System.out::println);
				break;
			}
			case 4:{
				System.out.println("Displaying Donor as Per Amount(Descending Order)");
				donarMap.values().stream().sorted((d1,d2)->(((Double)d2.getAmount()).compareTo((Double)d1.getAmount()))).forEach(System.out::println);
				break;
			}
			case 5:{
				System.out.println("Displaying Donor Donates Monthly");
				donarMap.values().stream().filter(i-> i.getdFreq()==donationFrequency.monthly).forEach(System.out::println);
				break;
			}
			case 6:{
				System.out.println("Displaying all donar who donates in the month of April");
				donarMap.values().stream().filter(i-> i.getDonationDate().getMonthValue()==4).forEach(System.out::println);
				break;
			}
			case 7:{
				System.out.println("Enter File Name to load Data");
				donarMap=restoreDataFromFile(sc.next());
				System.out.println("Data Restored...!!!");
				break;
			}
			case 8:{
				exit=true;
				System.out.print("Enter File Name to Store Data");
				storeDataToFile(sc.next(),donarMap);
				System.out.println("Data Stored..!!!");
				System.out.println("Exiting...!!!!");
				break;
			}
			}
			
			
			
			}while(!exit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
