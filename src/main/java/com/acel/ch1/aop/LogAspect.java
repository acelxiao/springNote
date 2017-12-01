package com.acel.ch1.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect //1
@Component //2
public class LogAspect {
	
	@Pointcut("@annotation(com.acel.ch1.aop.Action)") //3
	public void annotationPointCut(){};

	@Before("annotationPointCut()") //4
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("基于注解的前置拦截 :" + action.name()); //5
	}

	@After("annotationPointCut()") //4
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("基于注解的后置拦截 :" + action.name()); //5
	}
	  
    @Before("execution(* com.acel.ch1.aop.DemoMethodService.*(..))") //6
	public void before2(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("基于方法名字的前置拦截 :"+method.getName());

	}

	@After("execution(* com.acel.ch1.aop.DemoMethodService.*(..))")
	public void after2(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("基于方法名字的后置拦截 :"+method.getName());
	}
	   
	  
	
}
