package com.beb97.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;


public class MailProcessor implements ItemProcessor<Person, SimpleMailMessage> {

    private static final String EMAIL_TEMPLATE =
            "Welcome,\nDont forget your book!\n %s";
    private static final String EMAIL_FROM = "test@gmail.com";
    private static final String EMAIL_SUBJECT = "Welcome!";



    @Override
    public SimpleMailMessage process(final Person person) throws Exception {

        System.out.println("Creating mail for: " + person);

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(EMAIL_FROM);
        mail.setTo(person.getEmail());
        mail.setSubject(EMAIL_SUBJECT);
        mail.setText(String.format(EMAIL_TEMPLATE, person));

        return mail;
    }

}