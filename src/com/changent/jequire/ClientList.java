package com.changent.jequire;
import java.util.*;

public class ClientList extends Object {
	private ArrayList list = new ArrayList();

	public void add(Client c) {
		list.add(c);
	}

	public Client get(int index) {
		return (Client)list.get(index);
	}

	public int size() { return list.size(); }

	public Iterator iterator() {
		return list.iterator();
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		Iterator e = list.iterator();

        if( e.hasNext() ) {
			buffer.append( ((Client)e.next()).toString() );
		}

        while( e.hasNext() ) {
			buffer.append(":");
			buffer.append( ((Client)e.next()).toString() );
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		ClientList cl = new ClientList();
		for(int i = 0; i < 7; i++) {
			cl.add( new Client( i + 1, "client" + (i + 1) ) );
		}

		Iterator e = cl.iterator();

        while(e.hasNext())
          System.out.println( ((Client)e.next()).toString() );
      }
} //~ end of class ClientList