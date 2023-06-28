package com.bytebank.account;

import com.bytebank.user.User;

public class SavingsAccount extends Account {
	
	public SavingsAccount(int agency, int number, User user) {
		super(agency, number, user);
	}
	
	@Override
	public void transfer(double value, Account accountToTransfer) {
		super.setCommission((value * 10) / 100);
		super.transfer(value, accountToTransfer);
	}	
  }
