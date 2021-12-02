package com.somshine.webApp.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.somshine.webApp.configuration.CompanyClient;
import com.somshine.webApp.configuration.SoapClientConfig;
import com.somshine.webApp.model.Company;
import com.somshine.webApp.webService.GetCompanyRequest;
import com.somshine.webApp.webService.GetCompanyResponse;

@RestController
public class PaymentController {
}
