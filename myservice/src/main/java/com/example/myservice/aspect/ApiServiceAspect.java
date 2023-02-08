package com.example.myservice.aspect;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiServiceAspect {

    @Autowired
    private MeterRegistry meterRegistry;

    @Pointcut("execution(public * com.example.myservice.controller.*.*(..))")
    public void callApiServices() {

    }

//    @Around("callApiServices()")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        meterRegistry.counter("myservice.http.api", Tag.of("consumer", joinPoint.))
//    }


}
