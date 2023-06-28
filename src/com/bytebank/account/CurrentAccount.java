package com.bytebank.account;

import com.bytebank.user.User;

public class CurrentAccount extends Account {
		
	public CurrentAccount(int agency, int number, User user) {
		super(agency, number, user);
	}
	
	@Override
	public void transfer(double value, Account accountToTransfer) {
		super.setCommission((value * 5) / 100);
		super.transfer(value, accountToTransfer);
	}
		    
}
