package attemp.first;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class TestMyCopabilityModule {
static Copabilities module=new Copabilities();
static Customer c1;
static Customer c2;
static Customer c3;

static Customer l1;
static Customer l2;
static Customer l3;
static Customer l4;

static File f;
static LinkedList<Customer> list;
@BeforeClass
public static void beforeClass(){
	module.clear();
	c1=new Customer("Jack","Durov","str.Stalina 18",2);
	c2=new Customer("Oleg","Kotsik","str.Kulparkivska 183",5);
	c3=new Customer("Petr","Shevchenko","str.Odesska 192",0);
	f=new File("Base.txt");
	list=new LinkedList<Customer>();
	list.add(l1=new Customer("list1","LIST","str.List",1));
	list.add(l2=new Customer("list2","LIST","str.List",2));
	list.add(l3=new Customer("list3","LIST","str.List",3));
	list.add(l4=new Customer("list4","LIST","str.List",4));
	module.setFile(f);
	
	
}

@Before
public  void before()
{
	module.addCustomer(c1);
	module.addCustomer(c2);
	module.addCustomer(c3);
	module.setFile(f);
	module.WriteAllCustomers();
	}

@Test
public void addAll(){
	module.addAll(list);
	assertEquals("List already contains 3.Now let add list*4 = 7",7,module.getCustomers().size());
}
@Test
public void addAllWithValue(){
	module.addAll(2,list);
	
	assertSame("we will add list^4 on 2 position, so on 2,3,4,5 will be our list",list.get(0),module.getCustomers().get(2));
	
}
@Test 
public void addCustomer()
{Customer temp=new Customer("Test","test","test",23);
module.addCustomer(temp);
assertTrue(module.getCustomers().contains(temp));
	
}
@Test 
public void addToCustomerItem(){
	module.addToCustomerItem(c1);
	assertEquals("We will add item to c1 2+1=3",3,module.getCustomer(c1).getGoodsValue());
}
@Test
public void clear(){
	module.addCustomer(c1);//it was 3 now 4
	module.clear();//  0 
	assertEquals(0, module.getCustomers().size());;
}
@Test
public void deleteCustomer(){
	module.deleteCustomer(c1);
	assertEquals(2,module.getCustomers().size());
}
@Test 
public void deleteCustomerByName()
{module.deleteCustomerByName("Oleg");
assertNull(module.getCustomerByName("Oleg"));
assertNull(module.getCustomer(c2));
	
}
@Test
public void deleteCustomerBySurname()
{module.deleteCustomerBySurname("Kotsik");
assertNull(module.getCustomerBySurname("Kotsik"));
assertNull(module.getCustomer(c2));
	
}

@Test
public void deleteCustomerByValueOfGoods()
{module.deleteCustomerByValueOfGoods(5);
assertNull(module.getCustomerByValueofGoods(5));
assertNull(module.getCustomer(c2));
}
@Test
public void getCustomer()
{assertEquals(c2, module.getCustomer(c2));
}
@Test
public void getCustomerByAddress()
{ String Address=c3.getAddress();
	assertEquals(c3, module.getCustomerByAddress(Address));
}
@Test
public void getCustomerById()
{ int ID=c3.getID();
	assertEquals(c3, module.getCustomerByID(ID));
}
@Test
public void getCustomerByName()
{ String Name=c3.getFirsName();
	assertEquals(c3, module.getCustomerByName(Name));
}
@Test
public void getCustomerBySurname()
{ String SecondName=c3.getSecondName();
	assertEquals(c3, module.getCustomerBySurname(SecondName));
}
@Test
public void getCustomerByValueOfGoods()
{ int Value=c3.getGoodsValue();
	assertEquals(c3, module.getCustomerByValueofGoods(Value));
}
@Test
public void getCustomerS()
{ list.clear();
	list.add(c1);
	list.add(c2);
	list.add(c3);
	
	assertEquals(list, module.getCustomers());
}
@Test
public void getFile()
{ assertEquals(f,module.getFile());

}
@Test
public void readFromFile()

{ module.readFromFile();
	assertEquals("Our file has 3 customers 3+3 = 6", 6, module.getCustomers().size());

}
@Test
public void setFile()

{ 	File temp=new File("ask.txt");
	module.setFile(temp);
	assertEquals( temp,module.getFile());

}
@Test
public void subtractOrder()
{ 	int value = c2.getGoodsValue();
	module.subtractOrder(c2);
assertEquals(value-1,module.getCustomer(c2).getGoodsValue());

}
@Test
public void WriteAllCustomers()
{ 	module.WriteAllCustomers();
	module.clear();
	assertEquals(0,module.getCustomers().size());
	module.readFromFile();
	assertEquals(3,module.getCustomers().size());

}







@After
public void after(){
	beforeClass();
}
}
