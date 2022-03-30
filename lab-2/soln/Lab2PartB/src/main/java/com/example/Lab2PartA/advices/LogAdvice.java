package com.example.Lab2PartA.advices;

import com.example.Lab2PartA.services.EmailSender;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @author kojusujan1111@gmail.com 29/03/22
 */
@Aspect
@Configuration
public class LogAdvice {

    @After(value = "execution(* com.example.Lab2PartA.services.IEmailSender.sendEmail(..))&&args(email, message)", argNames = "joinPoint,email,message")
    public void logAfterMethodExecution(JoinPoint joinPoint, String email, String message) {
        EmailSender emailSender = (EmailSender) joinPoint.getTarget();
        System.out.println(LocalDateTime.now() + " method = " + joinPoint.getSignature().getName() +
                " address = " + email + " message = " + message + " outgoing mail server = " + emailSender.outgoingMailServer);
    }

}
