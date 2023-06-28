package com.bytebank.employes;

import com.bytebank.intercaces.IBonusType;
import com.bytebank.user.User;

public class Manager extends Official {
	
	public Manager(double salary, User user) {
		super(salary, user);
	}
	
	@Override
	public double getBonus() {
		return (this.salary * IBonusType.Manager) / 100;
	}
}
