package com.bytebank.user;

public class User {
    String name;
    String document;
    int age;
    
    public User(String name, String document, int age) {
    	this.name = name;
    	this.document = document;
    	this.age = age;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
