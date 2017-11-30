/**
 * Class: B.Sc. in Computing
 * Author: Pauric Mc Ginley
 * Description: Serializer for Customer class
 * Date: 30/10/2017
**/

package ie.lyit.serialize;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;
import java.io.*;
import java.util.*;

//Implement CustomerDAO
public class CustomerSerializer implements CustomerDAO {
	private ArrayList<Customer> customers;

	private final String FILENAME = "customers.ser";

	// Create a singleInstance Variable
	private static CustomerSerializer singleInstance;

	// Default Constructor
	private CustomerSerializer() {
		System.out.println("Inside CustomerSerializer Class Constructor");
		// Construct a Customer ArrayList
		customers = new ArrayList<Customer>();
	}

	// Gets singleInstance
	public static CustomerSerializer getSingleInstance() {
		if (singleInstance == null) {
			singleInstance = new CustomerSerializer();
			System.out.println("Single Object Created: " + singleInstance);
		}
		return singleInstance;
	}

	// Displays singleInstance
	public void displaySingleton() {
		System.out.println("CustomerSerializer object: " + singleInstance);
	}

	// add() method
	@SuppressWarnings("resource")
	public void add() {
		Scanner keyboardIn = new Scanner(System.in);
		// Create a Customer object
		Customer customer = new Customer();
		// Enter Title
		System.out.println("Enter Title: ");
		String title = keyboardIn.next();
		// Enter First Name
		System.out.println("Enter First Name: ");
		String firstName = keyboardIn.next();
		// Enter Last Name
		System.out.println("Enter Last Name: ");
		String lastName = keyboardIn.next();
		customer.setName(new Name(title, firstName, lastName));
		// Enter Address
		System.out.println("Enter Address: ");
		String address = keyboardIn.next();
		customer.setAddress(address);
		// Enter Last Name
		System.out.println("Enter Phone Number: ");
		String phoneNumber = keyboardIn.next();
		customer.setPhoneNumber(phoneNumber);
		// Enter Email
		System.out.println("Enter Email: ");
		String email = keyboardIn.next();
		customer.setEmailAddress(email);
		// add it to the customers ArrayList
		customers.add(customer);
	}

	// list() method
	public void list() {
		// for every Customer object in customers
		for (Customer cObject : customers)
			// Display it
			System.out.println(cObject);
	}

	// view() method
	public Customer view() {
		Scanner keyboard = new Scanner(System.in);

		// Read the number of the customer to be viewed from the user
		System.out.println("Enter number of customer : ");
		int customerToView = keyboard.nextInt();

		for (Customer cObject : customers) {
			// if its number equals the number of customerToView
			if (cObject.getNumber() == customerToView) {
				// Display it
				System.out.println(cObject);
				return cObject;
			}
			keyboard.close();
		}
		// If we reach this code the customer was not found so return null
		return null;
	}

	// edit() method
	public void edit() {
		// Call view() to find, display & return the customer to edit
		Customer cObject2 = view();
		// If the customer != null, then...
		if (cObject2 != null) {
			// get it's index
			int index = customers.indexOf(cObject2);
			@SuppressWarnings("resource")
			Scanner keyboardIn = new Scanner(System.in);
			System.out.println("Enter Title: ");
			String title = keyboardIn.next();
			System.out.println("Enter First Name: ");
			String firstName = keyboardIn.next();
			System.out.println("Enter Last Name: ");
			String lastName = keyboardIn.next();
			cObject2.setName(new Name(title, firstName, lastName));
			System.out.println("Enter Address: ");
			String address = keyboardIn.next();
			cObject2.setAddress(address);
			System.out.println("Enter Phone Number: ");
			String phoneNo = keyboardIn.next();
			cObject2.setPhoneNumber(phoneNo);
			System.out.println("Enter Email: ");
			String email = keyboardIn.next();
			cObject2.setEmailAddress(email);
			// Reset the object in customers
			customers.set(index, cObject2);
		}
	}

	// delete() method
	public void delete() {
		// Call view() to find, display, & return the customer to delete
		Customer cObject2 = view();
		// If the customer != null, i.e. it was found then...
		if (cObject2 != null)
			// ...remove it from customer
			customers.remove(cObject2);
	}

	// This method will serialize the customers ArrayList when called
	public void writeRecordsToFile() {
		ObjectOutputStream os = null;
		try {
			// Serialize the ArrayList
			FileOutputStream fileStream = new FileOutputStream(FILENAME);

			os = new ObjectOutputStream(fileStream);

			os.writeObject(customers);
		} catch (FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store books.");
		} catch (IOException ioE) {
			System.out.println(ioE.getMessage());
		} finally {
			try {
				os.close();
			} catch (IOException ioE) {
				System.out.println(ioE.getMessage());
			}
		}
	}

	// This method will deserialize the books ArrayList when called
	@SuppressWarnings("unchecked")
	public void readRecordsFromFile() {
		ObjectInputStream is = null;

		try {
			// Deserialize the ArrayList
			FileInputStream fileStream = new FileInputStream(FILENAME);

			is = new ObjectInputStream(fileStream);

			customers = (ArrayList<Customer>) is.readObject();
		} catch (FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store customers.");
		} catch (IOException ioE) {
			System.out.println(ioE.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				is.close();
			} catch (IOException ioE) {
				System.out.println(ioE.getMessage());
			}
		}
	}
}