/**
 * Class: B.Sc. in Computing
 * Author: Pauric Mc Ginley
 * Description: Tester for the Customer class
 * Date: 29/10/2017
**/

package ie.lyit.testers;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;

public class CustomerTester {

	public static void main(String[] args) {
		// Create a Customer object called customerA
		Customer customerA = new Customer();

		// Display customerA's details on screen
		System.out.println(customerA);

		// set customerA's details
		customerA.setName(new Name("Mr", "Homer", "Simpson"));
		customerA.setAddress("12 Hi Road,Letterkenny");
		customerA.setPhoneNumber("087 1234567");
		customerA.setEmailAddress("homer@hotmail.com");

		// Display customerA's details on screen
		System.out.println(customerA);

		// Create a Customer object called customerB with initial values
		Customer customerB = new Customer("Ms", "Lisa", "Simpson", "The Green,Ennis", "085 0987654",
				"lisa.simpson@gmail.com");

		// Display customerB's details on screen
		System.out.println(customerB);

		// Check if customerA is the same as customerB
		if (customerA.equals(customerB))
			System.out.println(customerA + " is the same customer as " + customerB);
		else
			System.out.println(customerA + " is not the same customer as " + customerB);

		// Check if customerB is female
		if (customerB.getName().isFemale())
			System.out.println(customerB.getName() + " is female.");
		else
			System.out.println(customerB.getName() + " is male.");
	}
}
