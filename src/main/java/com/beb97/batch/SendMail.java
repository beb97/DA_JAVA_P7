package com.beb97.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

public class SendMail implements ItemWriter<SimpleMailMessage> {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void write(List<? extends SimpleMailMessage> messages) {
        messages.stream().forEach((message)->emailSender.send(message));

    }

}