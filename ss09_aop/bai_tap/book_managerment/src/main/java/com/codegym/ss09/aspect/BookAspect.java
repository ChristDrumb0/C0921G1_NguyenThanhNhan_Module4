package com.codegym.ss09.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class BookAspect {


    @Pointcut("execution(* com.codegym.ss09.controller.BookController.borrow(..))")
    public void borrowMethodPointCut(){}

    @AfterReturning("borrowMethodPointCut()")
    public void loggerBorrow(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("------------------");
        System.err.println("Borrow book by method:" + methodName + ", time: " + LocalDate.now());
    }

    @Pointcut("execution(* com.codegym.ss09.controller.BookController.giveBack(..))")
    public void giveBackMethodPointCut(){}

    @AfterReturning("giveBackMethodPointCut()")
    public void loggerGiveBack(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("------------------");
        System.err.println("Return book by method: " + methodName + ", time: " + LocalDate.now());
    }

    //đếm số người ghé thăm:
    private int countVisitor = 0;

    @Pointcut("within(com.codegym.ss09.controller.BookController*)")
    public void allControllerPointCut(){}

    @After("allControllerPointCut()")
    public void countVisitor(JoinPoint joinPoint) {
        System.out.println("------------------");
        System.err.println("Tổng số lượt khách ghé thăm thư viện = " +  countVisitor++);
    }
}
