package superheroManager.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProcessAnnotation {

    @Around("@annotation(superheroManager.annotations.LogExecutedTime)")
    public Object logTime(ProceedingJoinPoint jointPoint) throws Throwable {
        String requestName = jointPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        Object obj = jointPoint.proceed();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Request " + requestName + " execution duration: " + elapsedTime + " ms.");
        return obj;
    }

}
