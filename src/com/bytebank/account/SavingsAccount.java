package com.bytebank.account;

import com.bytebank.user.User;

public class SavingsAccount extends Account {

	private double commissionCounter;
	
	public SavingsAccount(int agency, int number, User user) {
		super(agency, number, user);
	}
	
	@Override
	public boolean transfer(double value, Account accountToTransfer) {
		if(super.getBalance() >= 0) {
			if(accountToTransfer instanceof SavingsAccount) {
				this.setCommission((value * 10) / 100);
				accountToTransfer.deposit(value);
				this.messageTransfer(value, this.getCommission());
				super.withdraw(value + this.getCommission());
				return true;
			}
			
			if(accountToTransfer instanceof CurrentAccount) {
				this.setCommission((value * 5) / 100);
				accountToTransfer.deposit(value);
				this.messageTransfer(value, this.getCommission());
				super.withdraw(value + this.getCommission());
				return true;
			}
			if(accountToTransfer instanceof SalaryAccount) {
				this.setCommission((value * 3) / 100);
				accountToTransfer.deposit(value);
				this.messageTransfer(value, this.getCommission());
				super.withdraw(value + this.getCommission());
				return true;
			}
			return true;
		} else {
			System.out.println("No hay saldo suficiente para realizar esta operación");
			return false;
		}
		
	}
	
    public void setCommission(double value) {
    	this.commissionCounter += value;
    }
    
    public double getCommission() {
    	return this.commissionCounter;
    }
	
    public void messageTransfer(double value, double commision) {
    	System.out.println("Transaccion realizada exitosamente: $" + value + " y de comisión de cobró: $" + commision);
    }

}
