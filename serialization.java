package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import core.Customer;

public interface serialization {
	//java Application --> OOS --> FOS (binary File)
	public static void generateBinaryData(Map<String,Customer> customerMap ,String fileName) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		
		out.writeObject(customerMap);
	}
}