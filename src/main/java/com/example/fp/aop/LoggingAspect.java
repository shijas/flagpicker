/**
 * 
 */
package com.example.fp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.example.fp.dao.impl.FlagPickerDAOImpl;

/**
 * @author shijas
 *
 */

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlagPickerDAOImpl.class);

    @Around("execution(* com.example.fp..*(..)))")
    public Object logMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
         
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
 
        LOGGER.info("Execution time of method: " + className + "." + methodName + " : " + stopWatch.getTotalTimeMillis() +" milliseconds");
 
        return result;
    }

}
