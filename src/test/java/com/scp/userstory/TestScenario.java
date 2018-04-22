package com.scp.userstory;

import java.util.ArrayList;
import java.util.List;

public class TestScenario {

	public static void main(String[] args) {
		
		List<String> airtelSet = new ArrayList<String>();
		airtelSet.add("+91 0111111");
		airtelSet.add("+91 0222222");
		airtelSet.add("+91 0333333");
		
		List<String> vodaphone = new ArrayList<String>();
		vodaphone.add("+91 1111111");
		vodaphone.add("+91 1222222");
		vodaphone.add("+91 1333333");
		
		
		List<String> idea = new ArrayList<String>();
		idea.add("+91 2111111");
		idea.add("+91 2222222");
		idea.add("+91 2333333");
		
		
		
		Phone p1= new Phone(11111, airtelSet);
		Phone p2= new Phone(22222, vodaphone);
		Phone p3= new Phone(33333, idea);
		
		
		Student st1 = new Student(21,"ABC",p1);
		Student st2 = new Student(22,"MNP",p2);
		Student st3 = new Student(23,"PQR",p3);
		
		
		/*System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		*/
		List<Student> listOfStudents = new ArrayList<Student>();
		listOfStudents.add(st1);
		listOfStudents.add(st2);
		listOfStudents.add(st3);
		System.out.println(listOfStudents);
		
		
		
	}
}
