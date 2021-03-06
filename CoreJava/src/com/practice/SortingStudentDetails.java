package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortingStudentDetails {

	public static void main(String[] args) {

		Student s1 = new Student(90, "sarat");
		Student s2 = new Student(54, "kumar");
		Student s3 = new Student(89, "sajja");
		Student s4 = new Student(98, "Charitha");
		Student s5 = new Student(98, "Ashok");
		
		List<Student> list = new ArrayList<>();

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		System.out.println(list);

		List<Student> res = list.stream()
				.sorted(Comparator.comparing(Student::getMarks, Comparator.reverseOrder()).thenComparing(Student::getName))
				.collect(Collectors.toList());

		System.out.println(res);
	}

}
