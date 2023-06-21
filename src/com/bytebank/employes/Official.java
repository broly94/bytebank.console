package com.bytebank.employes;

import com.bytebank.intercaces.IOfficial;
import com.bytebank.user.User;

public abstract class Official implements IOfficial {
	
	protected double salary;
	protected User user;
	
	public Official(double salary, User user) {
		this.salary = salary;
		this.user = user;
	}
	
	public User getUser(){
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public abstract double getBonus();
	
	
}
