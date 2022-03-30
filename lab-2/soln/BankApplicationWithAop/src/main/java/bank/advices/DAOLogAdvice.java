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
public class DAOLogAdvice {
    private final ILogger logger;

    public DAOLogAdvice(ILogger logger) {
        this.logger = logger;
    }

    @After(value = "execution(* bank.dao.*.*(..))")
    public void logAfterDaoCalled(JoinPoint joinPoint) {
        logger.log("---- DAO CALLED , method = " + joinPoint.getSignature().getName());
    }

}
