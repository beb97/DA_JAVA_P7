package com.beb97.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;

@SpringBootApplication
@EnableScheduling

public class BatchApplication {

	/** Based upon :
	https://spring.io/guides/gs/batch-processing/#scratch
	 */

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class);
	}

}
