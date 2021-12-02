package com.somshine.webApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.somshine.webApp.configuration.CompanyClient;
import com.somshine.webApp.configuration.SoapClientConfig;
import com.somshine.webApp.model.Company;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CompanySoapController {
	@RequestMapping(value = "/company/v1/getByName/{name}", method = RequestMethod.GET)
	public Company getCompany(@PathVariable String name) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SoapClientConfig.class);
		CompanyClient companyClient = annotationConfigApplicationContext.getBean(CompanyClient.class);
		com.somshine.webApp.webService.Company company = companyClient.getCompany(name).getCompany();
		
        Company objCompany = new Company();
        objCompany.setId(Long.parseLong(String.valueOf(company.getId())));
        objCompany.setName(company.getName());
        objCompany.setDescription(company.getDescription());
        objCompany.setShoppeId(company.getShoppeId());
        
        System.out.println("Got Response As below ========= : ");
        System.out.println("Id : "+company.getId());
        System.out.println("Name : "+company.getName());
        System.out.println("Description : "+company.getDescription());
        System.out.println("ShoppeId : "+company.getShoppeId());
        
        return objCompany;
	}
	
	@RequestMapping(value = "/company/v1/list", method = RequestMethod.GET)
	public List<Company> getCompanies() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SoapClientConfig.class);
		CompanyClient companyClient = annotationConfigApplicationContext.getBean(CompanyClient.class);
		List<com.somshine.webApp.webService.Company> companies = companyClient.getCompanies().getCompany();
		
        List<Company> responseCompanies = new ArrayList<>();
        for (com.somshine.webApp.webService.Company responseCompany : companies) {
        	Company objCompany = new Company();
			objCompany.setId(Long.parseLong(String.valueOf(responseCompany.getId())));
			objCompany.setName(responseCompany.getName());
	        objCompany.setDescription(responseCompany.getDescription());
	        objCompany.setShoppeId(responseCompany.getShoppeId());
	        responseCompanies.add(objCompany);
		}
        
        return responseCompanies;
	}
}
