package com.changent.jequire;
import java.util.*;

public class StakeholderList extends Object {
	private ArrayList list = new ArrayList();

	public void add(Stakeholder s) {
		list.add(s);
	}

	public Stakeholder get(int index) {
		return (Stakeholder)list.get(index);
	}

	public int size() { return list.size(); }

	public Iterator iterator() {
		return list.iterator();
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		Iterator e = list.iterator();

        if( e.hasNext() ) {
			buffer.append( ((Stakeholder)e.next()).toString() );
		}

        while( e.hasNext() ) {
			buffer.append(":");
			buffer.append( ((Stakeholder)e.next()).toString() );
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		StakeholderList cl = new StakeholderList();
		for(int i = 0; i < 7; i++) {
			cl.add( new Stakeholder( i + 1, "stakeholder" + (i + 1) ) );
		}

		Iterator e = cl.iterator();

        while(e.hasNext())
          System.out.println( ((Stakeholder)e.next()).toString() );
      }
} //~ end of class StakeholderList