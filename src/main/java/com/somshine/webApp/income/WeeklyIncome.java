package com.somshine.webApp.income;

public class WeeklyIncome extends Income {

	public WeeklyIncome() {
		super(IncomeType.DAILY);
	}

	@Override
	public void calculateIncome() {
		this.setAmount(6000d);
	}
	
}
