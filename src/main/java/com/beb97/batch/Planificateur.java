package com.beb97.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

// Based upon : https://dimitr.im/spring-batch-schedule
@Component
public class Planificateur {

    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    BatchConfiguration batchConfiguration;


    @Scheduled(cron = "0/5 * * * * *")
    public void schedule() {
        Job job = batchConfiguration.sendEmailJob();
        // Spring batch won’t run the same job with the same parameters twice
        JobParameters jobParams = new JobParametersBuilder()
                .addDate("date", new Date())
                .toJobParameters();
        try {
            jobLauncher.run(job, jobParams);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
