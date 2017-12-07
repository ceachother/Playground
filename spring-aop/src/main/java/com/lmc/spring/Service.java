package com.lmc.spring;

import org.springframework.stereotype.Component;

import com.lmc.spring.annotation.AfterMethod;
import com.lmc.spring.annotation.AfterMethodReturning;
import com.lmc.spring.annotation.AfterMethodThrowing;
import com.lmc.spring.annotation.BeforeMethod;
import com.lmc.spring.annotation.LogExecutionTime;

@Component
public class Service {
	
	@BeforeMethod
	@LogExecutionTime
	@AfterMethod
	@AfterMethodReturning
	@AfterMethodThrowing
	public boolean serve() throws InterruptedException {
		System.out.println("------------------serve-------------------");
		Thread.sleep(2000);
		throw new InterruptedException("Throw Exception");
//		return false;
	}
}
