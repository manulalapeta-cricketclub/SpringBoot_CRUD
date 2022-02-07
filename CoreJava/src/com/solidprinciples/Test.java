package com.solidprinciples;

public class Test {
	public static void main(String[] args) {
		Employee employee = new Employee(1, "code");
		employee.printMe();
		
		TrainedEmployees employeeT = new TrainedEmployees(1, "code","sarat");
		employeeT.printMe();
	}
}
