package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAOP {

    @Pointcut("execution(* com.codegym.controller.BookController.showBorrow(..))")

    public void callMethod() {
    }

    int count = 10;

    @After("callMethod()")
    public void afterCallMethod(JoinPoint joinPoint) {
        if (count==0){

        }
        count--;
        System.out.printf("Phương thức mượn" + joinPoint.getSignature().getName() + "Time:" + LocalDate.now());
    }
}
