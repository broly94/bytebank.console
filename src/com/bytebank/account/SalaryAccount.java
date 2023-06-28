package com.bytebank.account;

import com.bytebank.user.User;

public class SalaryAccount extends Account{
	
	public SalaryAccount(int agency, int number, User user) {
		super(agency, number, user);
	}

	@Override
	public void transfer(double value, Account accountToTransfer) {
		super.setCommission((value * 6) / 100);
		super.transfer(value, accountToTransfer);
	}
			
}
