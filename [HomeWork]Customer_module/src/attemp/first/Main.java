package attemp.first;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main {

	public static void main(String[] args) {

		Customer c=new Customer("Oleg1","ShutUp","lviv", 213);
		 Customer c1=new Customer("Oleg2","ShutUp","lviv", 213);
		 Customer c2=new Customer("Oleg3","ShutUp","lviv", 213);
		 Customer c3=new Customer("Oleg4","ShutUp","lviv", 213);
		 Customer c4=new Customer("Oleg5","ShutUp","lviv", 213);
		 Customer c5=new Customer("Oleg6","ShutUp","lviv", 213);
		 Customer c6=new Customer("Oleg7","ShutUp","lviv", 213);
		 Customer c7=new Customer("Oleg8","ShutUp","lviv", 213);
		 Customer c8=new Customer("Oleg9","ShutUp","lviv", 213);
		 Customer c9=new Customer("Oleg10","ShutUp","lviv", 213);
	
		
	Customers cc = new Customers();
		 cc.addCustomer(c);
		 cc.addCustomer(c1);
		 cc.addCustomer(c2);
		 cc.addCustomer(c3);
		 cc.addCustomer(c4);
		 cc.addCustomer(c5);
		 cc.addCustomer(c6);
		 cc.addCustomer(c7);
		 cc.addCustomer(c8);
		 cc.addCustomer(c9);
			 
		 
		 
		Copabilities cop=new Copabilities(cc);
	
		cop.showList();
	
}
}