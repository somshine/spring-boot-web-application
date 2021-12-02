package com.somshine.webApp.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@CrossOrigin(origins = "http://localhost:3000")
public class JobInvokerController {
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("accountJob")
	Job accountKeeperJob;

	@RequestMapping(value = "/run-batch-job", method = RequestMethod.GET)
	public String handle() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addString("source", "Spring Boot").toJobParameters();
		jobLauncher.run(accountKeeperJob, jobParameters);

		return "Batch job has been invoked";
	}
}
