package com.beb97.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class MailCompletionNotificationListener extends JobExecutionListenerSupport {

    @Autowired
    public MailCompletionNotificationListener() {
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("!!! MAIL JOB FINISHED! Time to verify the results");
        }
    }
}