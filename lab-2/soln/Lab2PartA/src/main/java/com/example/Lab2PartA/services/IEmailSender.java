package com.example.Lab2PartA.services;

public interface IEmailSender {
	void sendEmail(String email, String message);
	String getOutgoingMailServer();
}
