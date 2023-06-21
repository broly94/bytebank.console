package com.bytebank.employes;

public class BonusControl {
	private double totalBonus;
	
	public double registerBonus(Official official) {
		this.totalBonus = this.totalBonus + official.getBonus();
		System.out.println("Cantidad gastada en bonus: " + this.totalBonus);
		return this.totalBonus;
	}
}
