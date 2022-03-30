package bank.advices;

import bank.logging.ILogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.util.StopWatch;

/**
 * @author kojusujan1111@gmail.com 29/03/22
 */

public class StopWatchAdvice {
    private final ILogger logger;

    public StopWatchAdvice(ILogger logger) {
        this.logger = logger;
    }

    @Around(value = "execution(* bank.service.*.*(..))")
    public Object logServiceMethodProcessingDuration(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        logger.log("--- TIME TAKEN = " + totalTime + " ms ---");
        return retVal;
    }
}
