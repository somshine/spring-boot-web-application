package com.somshine.webApp.income;

public class YearlyIncome extends Income {

	public YearlyIncome() {
		super(IncomeType.DAILY);
	}

	@Override
	public void calculateIncome() {
		this.setAmount(60000d);
	}

}
