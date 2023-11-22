package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.core.Donor;
import com.core.donationFrequency;

public interface DonorDataUtils {

//	Enter FirstName,LastName,PhoneNo,Email,Password,Address,
//	Amount,DonationDate(YYYY-MM-DD),
//	Donation Frequency(onetime,monthly,yearly)
	
	
	static Map<String,Donor> populateData() {
		Map<String,Donor> donormap=new HashMap<>();
		donormap.put("udit@gmail.com", new Donor("udit","gupta","9689687903","udit@gmail.com","test123","Pune",600.0,LocalDate.parse("2023-11-17"),donationFrequency.onetime));
		donormap.put("aman@gmail.com", new Donor("aman","thakur","9875641230","aman@gmail.com","aman@123","Pune",1600.0,LocalDate.parse("2023-04-17"),donationFrequency.monthly));
		donormap.put("vikram@gmail.com", new Donor("vikram","singh","8521479630","vikram@gmail.com","vikram#44","Pune",6000.0,LocalDate.parse("2023-05-18"),donationFrequency.yearly));
		return donormap;
	}
	
	static void storeDataToFile(String filename,Map<String,Donor> donormap) throws IOException {
		
		try(ObjectOutputStream write=new ObjectOutputStream(new FileOutputStream(filename))){
			write.writeObject(donormap);
		}
	}
	
	static Map<String,Donor> restoreDataFromFile(String filename) throws FileNotFoundException, IOException{
		
		try(ObjectInputStream read=new ObjectInputStream(new FileInputStream(filename))){
			try {
				return (Map<String,Donor>)read.readObject();
			} catch (ClassNotFoundException | IOException  e) {
				// TODO Auto-generated catch block
				return new HashMap<>();
				//e.printStackTrace();
			}
		} 
		
	}
	
	
}
