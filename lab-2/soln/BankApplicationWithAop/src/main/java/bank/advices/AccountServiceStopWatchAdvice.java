package bank.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

/**
 * @author kojusujan1111@gmail.com 29/03/22
 */
@Aspect
@Configuration
public class AccountServiceStopWatchAdvice {
    Logger logger = LoggerFactory.getLogger(AccountServiceStopWatchAdvice.class);


}
