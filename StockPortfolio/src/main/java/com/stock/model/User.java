package com.stock.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
	private String firstName;
	private String lastName;
	private String email;

	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Two users are equal if their firstName, lastName and email address is same.
	 */
	@Override
	public boolean equals(Object obj) {
		return (this.firstName.equals(((User) obj).firstName)
				&& this.lastName.equals(((User) obj).lastName) && this.email
					.equals(((User) obj).email));
	}
	
	
	 public static void main(String[] args) {

	        //make a sample Array List
	        List<String> list = new ArrayList<String>();
	        list.add("one");
	        list.add("two");
	        list.add("three");
	        list.add("five");

	        System.out.println("The list contains one " + list.contains("one"));
	        System.out.println("The list contains two " + list.contains("two"));
	        System.out.println("The list contains four " + list.contains("four"));


	        //make a sample Linked List
	        List<Integer> integerList = new LinkedList<Integer>();
	        integerList.add(1);
	        integerList.add(2);
	        integerList.add(3);
	        integerList.add(5);


	        System.out.println("The list contains 1 " + integerList.contains(1));
	        System.out.println("The list contains 2 " + integerList.contains(2));
	        System.out.println("The list contains 4 " + integerList.contains(4));
	        
	        //Make an array list of custom objects
	        List<User> userList = new ArrayList<User>();
	        userList.add(new User("ani","bha","abcd@gg.com"));
	        userList.add(new User("ani2","bha2","abcd2@gg.com"));
	        userList.add(new User("ani5","bha5","abcd5@gg.com"));
	        
	        //create a custom object 
	        User user1 = new User("ani", "bha", "abcd@gg.com");
	        System.out.println("The list contains user with name ani bha and email id: abcd@gg.com : "+userList.contains(user1));
	        
	        User user2 = new User("aa","bb","aa@bb.com");
	        System.out.println("The list contains user with name ani bha and email id: aa@bb.com : "+userList.contains(user2));
	        
	    }
}
