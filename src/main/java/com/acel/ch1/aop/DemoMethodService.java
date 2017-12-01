package com.acel.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {
	public void add(){
		System.out.println("方法执行啦!!!!!");
	}
}
