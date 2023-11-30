package utils;
import java.io.*;
import java.util.*;

import core.Customer;

public interface deSerialization {
	// Java application <-- OOS <-- FOS <-- Binary file
	public static void restoreFromBinaryData(String fileName) throws FileNotFoundException, IOException {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			System.out.println(in.readObject());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
