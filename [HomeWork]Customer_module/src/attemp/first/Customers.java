package attemp.first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Customers {
	private ObjectOutputStream OOS;
	private FileInputStream fis;
	private LinkedList<Customer> customers = new LinkedList<Customer>();
	private static int count = 1;

	public Customers() {
		// TODO Auto-generated constructor stub
	}

	public Customers(LinkedList<Customer> customers) {
		super();
		this.customers = customers;
	}

	public void addAll(LinkedList<Customer> customers) {
		Iterator<Customer> it = customers.iterator();
		while (it.hasNext()) {
			Customer temp = it.next();
			temp.setID(count++);
		}
		this.customers.addAll(customers);
	}

	public void addAll(int index, LinkedList<Customer> customers) {
		Iterator<Customer> it = customers.iterator();
		while (it.hasNext()) {
			Customer temp = it.next();
			temp.setID(count++);
		}
		this.customers.addAll(index, customers);
	}

	public void addCustomer(Customer customer) {
		customer.setID(count++);

		this.customers.add(customer);
		Collections.sort(this.getCustomers());
	}

	public boolean deleteCustomer(Customer customer) {
		if (this.customers.isEmpty()) {
			return false;
		} else {
			if (this.customers.contains(customer)) {
				this.customers.remove(customer);
				count--;
				return true;
			} else
				return false;
		}
	}

	public void showCustomers() {
		Iterator<Customer> ir = this.customers.iterator();
		while (ir.hasNext()) {
			Customer p = ir.next();
			System.out.println(p);
		}
	}
	
public void showCustomersEvenValueOfOrders(int value)
{	Iterator<Customer> ir = this.customers.iterator();
		while (ir.hasNext()) {
			
			Customer p = ir.next();
			if(p.getGoodsValue()<value)
			System.out.println(p);
		}

}

public void showCustomersGreaterValueOfOrders(int value)
{	Iterator<Customer> ir = this.customers.iterator();
		while (ir.hasNext()) {
			
			Customer p = ir.next();
			if(p.getGoodsValue()>value)
			System.out.println(p);
		}

}
	public void clearCustomers() {
		this.customers.clear();
	}

	/**
	 * @return the customers . All kinds of search in our LinkedList/
	 */
	public LinkedList<Customer> getCustomers() {
		return customers;
	}
	public Customer getCustomer(Customer temp)
	{
		Iterator<Customer> it=this.customers.iterator();
		Customer tempCustomer;
		while(it.hasNext())
		{
			tempCustomer=it.next();
			if(tempCustomer.equals(temp))
			return tempCustomer;
		}return null;
	}

	public Customer getCustomerByFirstname(String name) {
	
		Iterator<Customer> it = this.getCustomers().iterator();
		Customer tempCustomer;
		while (it.hasNext()) {
			tempCustomer = it.next();
			if (tempCustomer.getFirsName().equals(name)) {
				return tempCustomer;
			}
		}
	return null ;
	}

	public Customer getCustomerBySurname(String Secondname) {
	
		Iterator<Customer> it = this.getCustomers().iterator();
		Customer tempCustomer;
		while (it.hasNext()) {
			tempCustomer = it.next();
			if (tempCustomer.getSecondName().equals(Secondname)) {
				return tempCustomer;
			}
		}
		return null;
	}

	public Customer getCustomerByValueOfGoods(int value) {
		
		try {
			Iterator<Customer> it = this.customers.iterator();
			while (it.hasNext()) {
				Customer tempCustomer = it.next();
				if (tempCustomer.getGoodsValue() == value)
					return tempCustomer;
			}

		} catch (NullPointerException e) {

		}
		return null;
	}

	public Customer getCustomerEvenValueOfGoods(int value) {
		try {
			Iterator<Customer> it = this.customers.iterator();
			while (it.hasNext()) {
				Customer tempCustomer = it.next();
				if (tempCustomer.getID() < value)
		return tempCustomer;
			}

		} catch (NullPointerException e) {

		}
		return null;

	}

	public Customer getCustomerGreaterValueOfGoods(int value) {
		Customer tempCustomer;
		try {
			Iterator<Customer> it = this.customers.iterator();
			while (it.hasNext()) {
				tempCustomer = it.next();
				if (tempCustomer.getID() > value)
return tempCustomer;
			}

		} catch (NullPointerException e) {

		}
		return null;
	}

	public Customer getCustomerByAddress(String address) {
		/*
		 * We will convert address from Customer in upCase & pur address
		 * variable in upCase ,for reducing clauses.It will improve our search
		 * systeme.
		 */

		Customer tempCustomer;
		try {
			Iterator<Customer> it = this.customers.iterator();
			while (it.hasNext()) {
				tempCustomer = it.next();
				if (tempCustomer.getAddress().toUpperCase().contains(address.toUpperCase()))
				return tempCustomer;
			}

		} catch (NullPointerException e) {

		}
	return null; 
	}

	public Customer getByID(int ID) {
		

		Customer tempCustomer;
		try {
			Iterator<Customer> it = this.customers.iterator();
			while (it.hasNext()) {
				tempCustomer = it.next();
				if (tempCustomer.getID()==ID)
				return tempCustomer;
			}

		} catch (NullPointerException e) {

		}
	return null; 
	}
public LinkedList<Customer> readFromFile(File f) throws IOException, ClassNotFoundException
{ 	 		LinkedList<Customer> temp = new LinkedList<Customer>();
		
		try {
        fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (true) {
           temp.add((Customer) ois.readObject());
        }
    } catch (EOFException ignored) {
        // as expected
    } finally {
        if (fis != null)
            fis.close();
    }
		return temp;
			
		/*──────────────────────────────────────
─▄▄▄───────────▄▄▄▄▄▄▄────────────────
█▀░▀█──────▄▀▀▀░░░░░░░▀▀▄▄────────────
█░░░░█───▄▀░░░░░░░░░░░░░░░▀▄───────▄▄▄
█▄░░░▀▄▄▀░░██░░░░░░░░░░░░░░▀█────█▀▀░█
─█░░░░█▀░░░▀░░░░░░░░██░░░░░░▀█─▄█░░░░█
─▀█░░▄█░░░░░░░▄▄▄░░░░▀░░░░░░░███░░░░█▀
──█▄░█░░░░░▄███████▄░░░░░░░░░█▀░░░░▄▀─
──▀█░█░░░░▄██████████░░░░░░░▄█░░░░▄▀──
───███░░░░███████████░░░░░░▄█░░░░█▀───
────█░░░░░██████████▀░░░░░░█░░░░█▀────
────█░░░░░░▀███████▀░░░░░░░█▄▄▄▀──────
────█░░░░░░░░▀▀▀▀░░░░░░░░░░░▀█────────
────█░░░░░░░░░░░░░░░░░░░░░░░░█────────
────█░░░░░░░░░░░░░░░░░░░░░░░░█────────
────█░░░░░░░░░░░░░░░░░░░░░░░░█────────*/
}

	public boolean writeToFile(File f) {
		/*
		 * add -writing in bytes.
		 */

		try {
			OOS = new ObjectOutputStream(new FileOutputStream(f));
			Iterator<Customer> it = customers.iterator();

			while (it.hasNext()) {

				Customer tempCust = it.next();

				OOS.writeObject(tempCust);

			}
			OOS.flush();
			OOS.close();
			return true;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return false;

	}

}
 
