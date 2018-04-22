package com.scp.userstory;

public class Student {

	private int studAge;
	private String studName;
	private Phone phoneNumber;
	public int getStudAge() {
		return studAge;
	}
	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public Phone getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "\nStudent [studAge=" + studAge + ", studName=" + studName + ", phoneNumber=" + phoneNumber + "]";
	}
	public Student(int studAge, String studName, Phone phoneNumber) {
		super();
		this.studAge = studAge;
		this.studName = studName;
		this.phoneNumber = phoneNumber;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
