package com.somshine.webApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.somshine.webApp.income.Income;
import com.somshine.webApp.income.IncomeFactory;
import com.somshine.webApp.income.IncomeType;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class DashboardController {
	@RequestMapping(value = "/income/{type}", method = RequestMethod.GET)
	public Map<String, String> getIncomeByType(@PathVariable String type) {
		IncomeType incomeType = IncomeType.valueOf(type.toUpperCase());
		Income income = IncomeFactory.getIncome(incomeType);
		
//		Income income = IncomeFactory.getIncome(IncomeType.DAILY);
		income.calculateIncome();
		
		Map<String, String> incomeDetails = new HashMap<>();  
		incomeDetails.put("type", type.toString());
//		incomeDetails.put("type", IncomeType.DAILY.toString());
		incomeDetails.put("amount", income.getAmount().toString());
		return incomeDetails;
	}
}
