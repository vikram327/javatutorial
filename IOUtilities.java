package utils;

import core.Customer;
import static utils.serialization.generateBinaryData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IOUtilities {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (Scanner sc = new Scanner(System.in);) {
			
			Map<String,Customer> customerMap = MessUtils.populateMap();
			
			System.out.println("Enter file name to store data : ");
			serialization.generateBinaryData(customerMap, sc.next());
			
			System.out.println("Enter file name from which you want to read data : ");
			deSerialization.restoreFromBinaryData(sc.next());
			
		}
	}
}
