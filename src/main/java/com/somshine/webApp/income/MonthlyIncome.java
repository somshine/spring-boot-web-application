package com.somshine.webApp.income;

public class MonthlyIncome extends Income {

	public MonthlyIncome() {
		super(IncomeType.DAILY);
	}

	@Override
	public void calculateIncome() {
		this.setAmount(600d);
	}

}
