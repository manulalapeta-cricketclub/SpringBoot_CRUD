package com.solidprinciples;

public class TrainedEmployees extends Employee{
	
	private String training;

	public TrainedEmployees(int id, String name, String training) {
		super(id, name);
		this.training = training;
	}

	public void printMe() {
		
		System.out.println("Employee training in :"+this.training);
	}
}
