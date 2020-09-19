package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int rollno;
	private String name,email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User() {
	}
	public User(int rollno,String name, String email) {
		this();
		this.name = name;
		this.email = email;
		this.rollno = rollno;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	@Override
	public String toString() {
		return "User [rollno=" + rollno + ", name=" + name + ", email=" + email + "]";
	}
	
}
