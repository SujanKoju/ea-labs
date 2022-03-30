package com.example.Lab2PartA.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

/**
 * @author kojusujan1111@gmail.com 29/03/22
 */
@Aspect
@Configuration
public class DaoDurationMonitoringAdvice {
    @Around(value = "execution(* com.example.Lab2PartA.daos.ICustomerDAO.*(..))")
    public Object logDaoDuration(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println("--- TIME TAKEN = " + totalTime+" ms ---");
        return retVal;
    }
}
