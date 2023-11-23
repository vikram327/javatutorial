package utils;

import java.time.LocalDate;
import java.util.*;

import core.Customer;
import core.Plan;
import exceptions.CustomException;

public class MessUtils {

	public static Map<String, Customer> populateMap() {

		Map<String, Customer> customerMap = new HashMap<>();

		customerMap.put("preeti@gmail.com", new Customer("preeti", "patil", "preeti@gmail.com", "12345", "Akurdi",
				"1234567890", LocalDate.of(2023, 11, 04), 3000.0, Plan.MONTHLY));
		customerMap.put("riya@gmail.com", new Customer("riya", "raut", "riya@gmail.com", "12345", "Baner", "5412945678",
				LocalDate.of(2022, 12, 02), 11700.0, Plan.QUARTERLY));
		customerMap.put("pooja@gmail.com", new Customer("pooja", "patil", "pooja@gmail.com", "12345", "Ravet",
				"1234564478", LocalDate.of(2023, 01, 05), 17500.0, Plan.HALFYEAR));
		customerMap.put("prachi@gmail.com", new Customer("prachi", "mehta", "prachi@gmail.com", "12345", "Akurdi",
				"3547583425", LocalDate.of(2023, 03, 05), 32000.0, Plan.YEARLY));
		customerMap.put("om@gmail.com", new Customer("om", "patil", "om@gmail.com", "12345", "Pune", "123545678",
				LocalDate.of(2023, 01, 11), 17500.0, Plan.HALFYEAR));
		customerMap.put("ram@gmail.com", new Customer("ram", "pawar", "ram@gmail.com", "12345", "akurdi", "123456178",
				LocalDate.of(2021, 06, 14), 11700.0, Plan.QUARTERLY));
		customerMap.put("siya@gmail.com", new Customer("siya", "mehta", "siya@gmail.com", "12345", "Ravet", "129345678",
				LocalDate.of(2023, 07, 22), 3000.0, Plan.MONTHLY));
		return customerMap;
	}

	public static Customer loginUser(String email, String password, Map<String, Customer> customerMap)
			throws CustomException {

		Customer cust = customerMap.get(email);
		if (cust != null) {
			if (cust.getPassword().equals(password)) //override equals() for password
				return cust;
			else
				throw new CustomException("Invalid password :: Password does not match for email Id...");
		} else
			throw new CustomException("Invalid email :: User does not exist ...");
	}
	
	public static void changePassword(String email,String oldPassword,String newPassword,Map<String,Customer> customerMap) throws CustomException {
		Customer customer = loginUser(email,oldPassword,customerMap);
		customer.setPassword(newPassword);
	}

	public static void sortByFirstName(Map<String, Customer> customerMap) {

		Comparator<Customer> firstNameComparator = (c1, c2) -> c1.getFirstName().compareTo(c2.getFirstName());
		customerMap.values()
		.stream()
		.sorted(firstNameComparator)
		.forEach(System.out::println);
	}

	public static void sortByPlan(Map<String, Customer> customerMap) {

		Comparator<Customer> planComparator = (c1, c2) -> c1.getPlan().compareTo(c2.getPlan());
		customerMap.values().
		stream().
		sorted(planComparator).
		forEach(System.out::println);
	}

	public static void sortByDateOfRegistration(Map<String, Customer> customerMap) {

		Comparator<Customer> DORComparator = (c1, c2) -> c1.getRegistrationDate().compareTo(c2.getRegistrationDate());
		customerMap.values()
		.stream()
		.sorted(DORComparator)
		.forEach(System.out::println);
	}
	
	public static void capitalFirstLetterOfFname(Map<String,Customer> customerMap) {
		customerMap
		.values()
		.forEach(p->p.setFirstName(p.getFirstName()
				.replace(p.getFirstName().charAt(0), p.getFirstName().toUpperCase().charAt(0))));
	}
	
	public static void getRegisteredInMonth(Map<String,Customer> customerMap) {
		customerMap.values()
		.stream()
		.filter(p->p.getRegistrationDate().getMonthValue()==01)
		.forEach(p->System.out.println(p.getEmail()));
	}
	
	public static void registeredForMonthly(Map<String,Customer> customerMap) {
		customerMap.values()
		.stream()
		.filter(p->p.getPlan().equals(Plan.MONTHLY))
		.forEach(System.out::println);
	}
	
	public static void getCustomersInAkurdi(Map<String,Customer> customerMap) {
		customerMap.values()
		.stream()
		.filter(p->p.getAddress().equalsIgnoreCase("Akurdi"))
		.forEach(System.out::println);
	}
	
	public static void applyDiscount(Map<String,Customer> customerMap) {
		customerMap.values()
		.stream()
		.filter(p->p.getPlan().equals(Plan.YEARLY))
		.forEach(p->p.setFinalAmount(p.getPlan().getPlanPrice()-(p.getPlan().getPlanPrice()*0.2)));
	}
	
	public static void removeCustomers(Map<String,Customer> customerMap) {
		customerMap
		.values()
		.removeIf(p->p.getPlanEndDate().isBefore(LocalDate.now()));
	}

}
