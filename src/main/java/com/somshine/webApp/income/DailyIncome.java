package com.somshine.webApp.income;

public class DailyIncome extends Income {

	public DailyIncome() {
		super(IncomeType.DAILY);
	}

	@Override
	public void calculateIncome() {
		this.setAmount(60d);
	}

}
