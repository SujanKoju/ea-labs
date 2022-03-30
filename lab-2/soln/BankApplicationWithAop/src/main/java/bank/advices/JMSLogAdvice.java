package bank.advices;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * @author kojusujan1111@gmail.com 29/03/22
 */
@Aspect
@Configuration
public class JMSLogAdvice {
    private final ILogger logger;

    public JMSLogAdvice(ILogger logger) {
        this.logger = logger;
    }

    @After(value = "execution(* bank.jms.IJMSSender.sendJMSMessage(..))")
    public void logAfterMessageSent(JoinPoint joinPoint) {
        logger.log("---- Message Sent with text = " + joinPoint.getArgs()[0]);
    }
}
