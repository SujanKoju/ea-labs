package bank.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
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
public class DaoLogAdvice {
    Logger logger = LoggerFactory.getLogger(DaoLogAdvice.class);

    @After(value = "execution(* bank.dao.*.*(..))")
    public void logAfterDaoCalled(JoinPoint joinPoint) {
        logger.info("---- DAO CALLED , method = " + joinPoint.getSignature().getName());
    }

    @Around(value = "execution(* bank.service.*.*(..))")
    public Object logServiceMethodProcessingDuration(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        logger.info("--- TIME TAKEN = " + totalTime + " ms ---");
        return retVal;
    }

    @After(value = "execution(* bank.jms.IJMSSender.sendJMSMessage(..))")
    public void logAfterMessageSent(JoinPoint joinPoint) {
        logger.info("---- Message Sent with text = " + joinPoint.getArgs()[0]);
    }
}
