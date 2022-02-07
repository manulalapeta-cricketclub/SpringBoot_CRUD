package com.solidprinciples;

public class Employee {

	private int id;
	private String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void printMe() {
		System.out.println("Employee id is : " + this.id + " and employee name is : " + this.name);
	}

}
