package com.somshine.webApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.somshine.webApp.model.Company;
import com.somshine.webApp.repository.CompanyRepository;

@RestController
@RequestMapping("/company/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
	@Autowired
	private CompanyRepository companyRepository;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Company getProductData(@PathVariable Long id) {
		return companyRepository.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "/selection", method = RequestMethod.GET)
	public List<Company> getProductStockInformation() {
		return companyRepository.findAll();
	}
}
