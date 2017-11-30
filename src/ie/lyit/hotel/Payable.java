/**
 * Class: B.Sc. in Computing
 * Author: Pauric Mc Ginley
 * Description: Payable Interface
 * Date: 29/10/2017
**/

package ie.lyit.hotel;

public interface Payable {
	public abstract double calculateWage(double taxPercentage);

	// Don't have to put in public abstract
	double incrementSalary(double incrementAmount);
}

// A Java interface can contain only abstract
// methods, i.e. methods without a body