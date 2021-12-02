package com.somshine.webApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this is the package name specified in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.somshine.webApp.webService");
		return marshaller;
	}

	@Bean
	public CompanyClient soapConnector(Jaxb2Marshaller marshaller) {
		CompanyClient client = new CompanyClient();
		client.setDefaultUri("http://localhost:8182/ws/company/companies");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
