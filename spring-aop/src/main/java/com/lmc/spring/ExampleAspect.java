package com.lmc.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {
	
	@Around("@annotation(com.lmc.spring.annotation.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Around:" + joinPoint.getSignature());
		long start = System.currentTimeMillis();
		
		Object proceed = joinPoint.proceed();
		
		long executionTime = System.currentTimeMillis() - start;
		
		System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}
	
	@Before("@annotation(com.lmc.spring.annotation.BeforeMethod)")
	public void beforeMethod(JoinPoint joinPoint) throws Throwable {
		System.out.println("Before:" + joinPoint.getSignature());
	}
	
	@After("@annotation(com.lmc.spring.annotation.AfterMethod)")
	public void afterMethod(JoinPoint joinPoint) throws Throwable {
		System.out.println("After:" + joinPoint.getSignature());
	}
	
	@AfterReturning(
			pointcut = "@annotation(com.lmc.spring.annotation.AfterMethodReturning)",
			returning = "result")
	public void afterMethodReturning(JoinPoint joinPoint, Object result) throws Throwable {
		System.out.println("AfterReturning:" + joinPoint.getSignature());
		System.out.println("Value:" + result);
	}
	
	@AfterThrowing(
			pointcut = "@annotation(com.lmc.spring.annotation.AfterMethodThrowing)",
			throwing = "error")
	public void afterMethodThrowing(JoinPoint joinPoint, Throwable error) throws Throwable {
		System.out.println("AfterThrowing:" + joinPoint.getSignature());
		System.out.println("Exception:" + error);
	}
	
}
