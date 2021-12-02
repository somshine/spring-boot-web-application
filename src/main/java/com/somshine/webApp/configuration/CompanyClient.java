package com.somshine.webApp.configuration;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.somshine.webApp.webService.GetCompaniesRequest;
import com.somshine.webApp.webService.GetCompaniesResponse;
import com.somshine.webApp.webService.GetCompanyRequest;
import com.somshine.webApp.webService.GetCompanyResponse;

public class CompanyClient extends WebServiceGatewaySupport {
	public GetCompanyResponse getCompany(String name) {
        GetCompanyRequest companyRequest = new GetCompanyRequest();
        companyRequest.setName(name);
        return (GetCompanyResponse) getWebServiceTemplate().marshalSendAndReceive(companyRequest);
    }
	
	public GetCompaniesResponse getCompanies() {
        GetCompaniesRequest companiesRequest = new GetCompaniesRequest();
        return (GetCompaniesResponse) getWebServiceTemplate().marshalSendAndReceive(companiesRequest);
    }
 
    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
