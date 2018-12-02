package com.changent.jequire;
import java.util.*;

public class CustomerList extends Object {
	private ArrayList list = new ArrayList();

	public void add(Customer c) {
		list.add(c);
	}

	public Customer get(int index) {
		return (Customer)list.get(index);
	}

	public int size() { return list.size(); }

	public Iterator iterator() {
		return list.iterator();
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		Iterator e = list.iterator();

        if( e.hasNext() ) {
			buffer.append( ((Customer)e.next()).toString() );
		}

        while( e.hasNext() ) {
			buffer.append(":");
			buffer.append( ((Customer)e.next()).toString() );
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		CustomerList cl = new CustomerList();
		for(int i = 0; i < 7; i++) {
			cl.add( new Customer( i + 1, "cust" + (i + 1) ) );
		}

		Iterator e = cl.iterator();

        while(e.hasNext())
          System.out.println( ((Customer)e.next()).toString() );
      }
} //~ end of class CustomerList