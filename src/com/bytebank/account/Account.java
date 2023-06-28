package com.bytebank.account;

import com.bytebank.user.User;
import com.bytebank.exceptions.NoCreditException;

public abstract class Account {
	private double balance;
	private int agency;
	private int number;
	private User user;
	private static int total = 0;
	private double commissionCounter;

	public Account(int agency, int number, User user) {
		this.agency = agency;
		this.number = number;
		this.user = user;
		Account.total++;
	}

	public boolean deposit(double value) {
		if (value > 0) {
			this.balance += value;
			return true;
		} else {
			return false;
		}
	}

	public void withdraw(double value) {
		try {
			if (this.balance < value) {
				throw new NoCreditException("Saldo insuficiente para realizar esta operación");
			}
			this.balance -= value;
		} catch (NoCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void transfer(double value, Account accountToTransfer) {
		try {
			if (this.getBalance() < value) {
				throw new NoCreditException("Saldo insuficiente para realizar esta operacion");
			}

			if (value + this.getCommission() > this.getBalance()) {
				throw new NoCreditException("No se pudo realizar la transaccion: Su saldo es de $" + this.getBalance()
						+ " pero se le cobra una comision de $" + this.getCommission()
						+ ". Intente enviar menos cantidad");
			}
			accountToTransfer.deposit(value);
			this.withdraw(value + this.getCommission());
			this.messageTransfer(value, this.getCommission());
			
		} catch (NoCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void setCommission(double value) {
		this.commissionCounter = value;
	}

	public double getCommission() {
		return this.commissionCounter;
	}

	public void messageTransfer(double value, double commision) {
		System.out.println("Transaccion realizada exitosamente: $" + value + " y de comisión de cobró: $" + commision);
	}

	// Setters and Getters
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	public static int getTotal() {
		return total;
	}
}
