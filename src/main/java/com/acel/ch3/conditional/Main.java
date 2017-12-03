package com.acel.ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConditionConifg.class);
		
		ListService listService = context.getBean(ListService.class);
		
		
		System.out.println(context.getEnvironment().getProperty("os.name") 
				+ "系统的命令是: "
				+ listService.showListCmd());
		
		context.close();
	}
}
