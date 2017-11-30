/**
 * Class: B.Sc. in Computing
 * Author: Pauric Mc Ginley
 * Description: Tester for CustomerSerializer class
 * Date: 30/10/2017
**/

package ie.lyit.testers;

import ie.lyit.serialize.CustomerSerializer;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class CustomerSerializerTester {

	public static void main(String[] args) {

		// Create a CustomerSerializer Object
		CustomerSerializer customerSerializer = CustomerSerializer.getSingleInstance();
		int option = 0;

		// Read the ArrayList from the File
		customerSerializer.readRecordsFromFile();
		Scanner keyboardIn = new Scanner(System.in);

		do {
			try {
				System.out.println("\t1. Add");
				System.out.println("\t2. List");
				System.out.println("\t3. View");
				System.out.println("\t4. Edit");
				System.out.println("\t5. Delete");
				System.out.println("\t6. Quit");
				System.out.println("Enter Option: ");
				option = keyboardIn.nextInt();
				switch (option) {
				case 1:
					customerSerializer.add();
					break;
				case 2:
					customerSerializer.list();
					break;
				case 3:
					customerSerializer.view();
					break;
				case 4:
					customerSerializer.edit();
					break;
				case 5:
					customerSerializer.delete();
					break;
				case 6:
					break;
				default:
					System.out.println("INVALID OPTION...");
				}
			} catch (InputMismatchException e) {
				System.out.println("Option choice should be an integer");
				keyboardIn.next();
			} catch (NoSuchElementException f) {
				System.out.print("Customer No not in list");
				break;
			}
		} while (option != 6);

		customerSerializer.writeRecordsToFile();
		keyboardIn.close();
	}
}
