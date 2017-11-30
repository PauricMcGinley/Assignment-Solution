/**
 * Class: B.Sc. in Computing
 * Author: Pauric Mc Ginley
 * Description: Converts a string to an int
 * Date: 29/10/2017
**/

package ie.lyit.hotel;

import javax.swing.JOptionPane;

public class IntToString {
	public static void main(String[] args) {
		String numberAsString = JOptionPane.showInputDialog(null, "Enter an integer");

		// Attempt to convert the String to an Int
		int number = Integer.parseInt(numberAsString);
		System.out.println("Conversion was successful!\n" + "The integer entered is " + number + ".");
	}
}
