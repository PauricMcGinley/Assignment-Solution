/**
 * Class: B.Sc. in Computing
 * Author: Pauric Mc Ginley
 * Description: Converts a string to an int with EH
 * Date: 29/10/2017
**/

package ie.lyit.hotel;

import javax.swing.JOptionPane;

public class IntToStringWithEH {
	public static void main(String[] args) {

		try {
			String numberAsString = JOptionPane.showInputDialog(null, "Enter an integer");

			// Attempt to convert the String to an Int
			int number = Integer.parseInt(numberAsString);
			System.out.println("Conversion was successful!\n" + "The integer entered is " + number + ".");
		} catch (NumberFormatException nFE) {
			System.out.println("Cannot convert to an Integer.");

			System.out.println("\nOutput from getMessage:\n" + nFE.getMessage());
			System.out.println("\nOutput from toString: \n" + nFE.toString());
			System.out.println("\nOutput from printStackTrace: ");
			nFE.printStackTrace();
		} catch (Exception e) {
			System.out.println("An error occurred.");
		}
	}
}
