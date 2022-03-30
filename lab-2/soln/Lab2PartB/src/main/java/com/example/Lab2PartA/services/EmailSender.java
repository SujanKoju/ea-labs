package com.example.Lab2PartA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailSender implements IEmailSender {
    @Value("${mail.server:smtp.acme.com}")
    public String outgoingMailServer;
    private final ILogger logger;

    @Autowired
    public EmailSender(ILogger logger) {
        this.logger = logger;
    }

    public String getOutgoingMailServer() {
        return outgoingMailServer;
    }

    public void sendEmail(String email, String message) {
        System.out.println("EmailSender: sending '" + message + "' to " + email);
        logger.log("Email is sent: message= " + message + " , emailaddress =" + email);
    }

}
