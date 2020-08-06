
package com.beb97.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.mail.SimpleMailMessage;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    DataSource dataSource;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private static final String QUERY_FIND_PERSONN = "SELECT * FROM people";

    @Bean
    // Read an input
    public ItemReader<Person> personReader() {
        return new JdbcCursorItemReaderBuilder<Person>()
                .name("personReader")
                .dataSource(dataSource)
                .sql(QUERY_FIND_PERSONN)
                .rowMapper(new BeanPropertyRowMapper<>(Person.class))
                .build();
    }

    @Bean
    public Job sendEmailJob() {
        return jobBuilderFactory.get("sendEmailJob")
//                .preventRestart()
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Person, SimpleMailMessage> chunk(10)
                .reader(personReader())
                .processor(mailProcessor())
                .writer(sendMail())
                .build();
    }
     @Bean
     public SendMail sendMail() {
            return new SendMail();
     }

    @Bean
    // Transform the input
    public MailProcessor mailProcessor() {
        return new MailProcessor();
    }

    @Bean
    public MailCompletionNotificationListener listener() {
        return new MailCompletionNotificationListener();
    }

}