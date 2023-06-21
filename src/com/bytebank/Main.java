package com.bytebank;

import com.bytebank.employes.BonusControl;
import com.bytebank.employes.Counter;
import com.bytebank.employes.Manager;
import com.bytebank.intercaces.IAgencies;
import com.bytebank.user.User;
import com.bytebank.account.CurrentAccount;
import com.bytebank.account.SavingsAccount;
import com.bytebank.account.SalaryAccount;

public class Main{
	public static void main(String[] args) {
		
		BonusControl bonusControl = new BonusControl();
		
		User leonel = new User("Leonel", "38449519", 28);
		User solange = new User("Solange", "28291929", 34);
		User joaquin = new User("Joaquin", "253738374", 37);
		
		Counter counter = new Counter(2000, leonel);
		bonusControl.registerBonus(counter);
		
		Manager manager = new Manager(4000, solange);
		bonusControl.registerBonus(manager);
		
		
		CurrentAccount accountLeonel = new CurrentAccount(IAgencies.counter, 1, leonel);
		accountLeonel.deposit(2000);
		
		SavingsAccount accountSolange = new SavingsAccount(IAgencies.manager, 2, solange);
		accountSolange.deposit(2000);
		
		SalaryAccount accountJoaquin = new SalaryAccount(IAgencies.client, 3, joaquin);
		
		accountLeonel.transfer(1000, accountSolange);
		
		System.out.println(accountLeonel.getBalance() + " --> balance to leonel");
		accountLeonel.transfer(200, accountJoaquin);
		
		System.out.println(accountLeonel.getBalance()  + " --> balance to Leonel");
		System.out.println(accountSolange.getBalance()  + " --> balance to solange");
		System.out.println(accountJoaquin.getBalance()  + " --> balance to joaquin");
		//System.out.println(accountLeonel.getCommission());
	}
}
