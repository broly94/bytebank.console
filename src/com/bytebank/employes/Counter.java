package com.bytebank.employes;

import com.bytebank.intercaces.IBonusType;
import com.bytebank.user.User;

public class Counter extends Official{
	public Counter(double salary, User user) {
		super(salary, user);
	}
	
	@Override
	public double getBonus() {
		return (this.salary * IBonusType.Counter) / 100;
	}
}
