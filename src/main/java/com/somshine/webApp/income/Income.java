package com.somshine.webApp.income;

public abstract class Income {
	private IncomeType incomeType;
	private Double amount;
	
	public Income(IncomeType incomeType) {
		this.incomeType = incomeType;
	}
	
	public abstract void calculateIncome();
	
	public IncomeType getIncomeType() {
		return this.incomeType;
	}

	public void setIncomeType(IncomeType incomeType) {
		this.incomeType = incomeType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
