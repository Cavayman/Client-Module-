package attemp.first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;

public class Copabilities {
	private File file;
	private Customers customers;
	


	public Copabilities() {
		file = new File("Customers.txt");
		customers = new Customers();

	}

	public Copabilities(Customers customers)  {
		file = new File("Custmers.txt");
		this.customers = customers;
	}

	public Copabilities(File file, Customers customers) {
		super();
		if (file.length() == 0) {
			System.out.println("file is empthy.");
		} else {
			this.file = file;
		}
		if (customers.getCustomers().isEmpty()) {
			System.out.println("Your Customers list is empthy ");
		} else {
			this.customers = customers;
		}
		
		
	}
	public Copabilities(String path,String fileName)
	{
		file=new File(path+fileName+".txt");
	}
	
	public void WriteAllCustomers()
	{
		customers.writeToFile(file);
	}
	
	public void readFromFile()
	{
		try {
		 customers.addAll(customers.readFromFile(file));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clear(){
		customers.clearCustomers();
	}
	public void showList(){
		customers.showCustomers();
	}
	
	public void addAll(LinkedList<Customer> list)
	{
		this.customers.addAll(list);
	}
	public void addAll(int index,LinkedList<Customer> list)
	{
		this.customers.addAll(index, list);
	}
	public void addCustomer(Customer c)
	{
		this.customers.addCustomer(c);
	}
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void deleteCustomer(Customer c)
	{
		this.customers.deleteCustomer(c);
	}
	public void deleteCustomerByName(String name)
	{this.customers.deleteCustomer(this.customers.getCustomerByFirstname(name));
		
	}
	public void deleteCustomerBySurname(String surname)
	{
		this.customers.deleteCustomer(this.customers.getCustomerBySurname(surname));
	}
	public void deleteCustomerByValueOfGoods(int value)
	{
		this.customers.deleteCustomer(this.customers.getCustomerByValueOfGoods(value));
	}
	public void showEven(int value)
	{
		this.customers.showCustomersEvenValueOfOrders(value);
	}
	public void showGreater(int value)
	{
		this.customers.showCustomersGreaterValueOfOrders(value);
	}

	 public void addToCustomerItem(Customer customer)
	 {
		 this.customers.getCustomer(customer).setGoodsValue(this.customers.getCustomer(customer).getGoodsValue()+1);
	 }
	 public void subtractOrder(Customer customer)
	 {	if(this.customers.getCustomer(customer).getGoodsValue()>0)
		 this.customers.getCustomer(customer).setGoodsValue(this.customers.getCustomer(customer).getGoodsValue()-1);
	 
	 }
	 public Customer getCustomer(Customer customer)
	 {
		 return this.customers.getCustomer(customer);
	 }
	 public Customer getCustomerByName(String name)
	 {
		 return this.customers.getCustomerByFirstname(name);
	 }
	 public Customer getCustomerByID(int ID){
		 return this.customers.getByID(ID);
	 }
	 public Customer getCustomerByValueofGoods(int value)
	 {return this.customers.getCustomerByValueOfGoods(value);
		 
	 }
	 public Customer getCustomerByAddress(String address)
	 {
		 return this.customers.getCustomerByAddress(address);
	 }
	 public Customer getCustomerBySurname(String Surname){
		 return this.customers.getCustomerBySurname(Surname);
	 }
	 public LinkedList<Customer> getCustomers(){
		 return this.customers.getCustomers();
	 }
	
	
}