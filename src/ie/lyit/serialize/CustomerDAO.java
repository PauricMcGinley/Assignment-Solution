/**
 * Class: B.Sc. in Computing
 * Author: Pauric Mc Ginley
 * Description: CustomerDAO Class
 * Date: 28/11/2017
**/

package ie.lyit.serialize;

//Import Customer Class
import ie.lyit.hotel.Customer;

//Create a CustomerDAO Interface
public interface CustomerDAO {
	public void readRecordsFromFile();

	public void writeRecordsToFile();

	public void add();

	public void list();

	public Customer view();

	public void edit();

	public void delete();
}
