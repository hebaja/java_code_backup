package br.com.hebaja;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {

		// Create an array list
	      ArrayList al = new ArrayList();
	      
	      // add elements to the array list
	      al.add("C");
	      al.add("A");
	      al.add("E");
	      al.add("B");
	      al.add("D");
	      al.add("F");
	      
	      System.out.println(al.get(0));
	      
	   // Use iterator to display contents of al
	      System.out.print("Original contents of al: ");
	      Iterator itr = al.iterator();
	      
	      while(itr.hasNext()) {
	          Object element = itr.next();
	          System.out.print(element + " ");
	       }
	       System.out.println();
	      
		
		
	}
}
