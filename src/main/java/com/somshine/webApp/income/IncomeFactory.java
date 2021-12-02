package com.somshine.webApp.income;

public class IncomeFactory {
	public static Income getIncome(IncomeType incomeType) {
		Income income = null;
		switch (incomeType) {
			case DAILY:
				income = new DailyIncome();
				break;
				
			case WEEKLY:
				income = new WeeklyIncome();
				break;
				
			case MONTHLY:
				income = new MonthlyIncome();
				break;
				
			case YEARLY:
				income = new YearlyIncome();
				break;
				
			default:
				income = null;
				break;
		}
		
		return income;
	}
}
