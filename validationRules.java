package utils;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import core.Customer;
import core.Plan;
import exceptions.CustomException;

public class validationRules {

	public static void validateEmail(String email) throws CustomException {
		if (!email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
			throw new CustomException("Invalid email ...");
	}

	public static void checkForDuplicateEmail(String email, Map<String, Customer> customerMap) throws CustomException {
		if (customerMap.containsKey(email))
			throw new CustomException("User already exists with Email Id ...");
	}

	public static void validatePhoneNo(String phoneNo) throws CustomException {
		if (!phoneNo.matches("^[0-9]{10}$"))
			throw new CustomException("Invalid Phone no ...");
	}

	public static void validatePlanAmount(Plan plan, double amount) throws CustomException {
		if (!(plan.getPlanPrice() == amount))
			throw new CustomException("Invalid plan :: Amount does not match with plan selected...");
	}

	public static void validateAndAddUser(String firstName, String lastName, String email, String password,
			String address, String phoneNo, LocalDate registrationDate, double finalAmount, Plan plan,
			Map<String, Customer> customerMap) throws CustomException {
		Customer customer = new Customer(firstName, lastName, email, password, address, phoneNo, registrationDate,
				finalAmount, plan);

		validateEmail(email);
		checkForDuplicateEmail(email, customerMap);
		validatePhoneNo(phoneNo);
		validatePlanAmount(plan, finalAmount);

		customerMap.put(email, customer);
	}
}
