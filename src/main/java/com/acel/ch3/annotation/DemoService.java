package com.acel.ch3.annotation;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	public void outputResult(){
		System.out.println("自定义组合注解");
	}

}
