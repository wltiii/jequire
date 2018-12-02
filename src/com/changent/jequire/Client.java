package com.changent.jequire; 

//import java.util.*;
//import java.io.*;
//import javax.xml.parsers.*;

//import org.w3c.dom.*;
//import org.xml.sax.*;


public class Client extends Object {
  private int __id = 0;
  private String __name = null;

  public Client() {
  }

  public Client(int id, String name) {
	  __id = id;
	  __name = name.trim();
  }

  public void setID(int id) { __id = id; }

  public void setName(String name) { __name = name; }

  public int getID() 		{ return __id; }

  public String getName()           { return __name; }

  public String toString() {
    StringBuffer buffer = new StringBuffer();

    buffer.append(__id);
    buffer.append(":");
    buffer.append(__name);

    return buffer.toString();
  }

}
