package com.bytebank.account;

import com.bytebank.user.User;

public abstract class Account {
    private double balance;
    private int agency;
    private int number;
    private User user;
    private static int total = 0;

    public Account(int agency, int number, User user){
        this.agency = agency;
        this.number = number;
        this.user = user;
    	Account.total++;
    }

	public boolean deposit(double value){
        if(value > 0){
            this.balance += value;
            return true;
        }else {
            return false;
        }
    }

    public boolean withdraw(double value) {
        if(this.balance >= value) {
            this.balance -= value;
            return true;
        }else {
            return false;
        }
    }

    public abstract boolean transfer(double value, Account accountToTransfer);
    
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

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public static int getTotal(){
        return total;
    }
}
