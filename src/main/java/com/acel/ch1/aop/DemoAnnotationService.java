package com.acel.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
	@Action(name="拦截信息")
    public void add(){
        System.out.println("方法执行啦!!!!!");
    }
   
}
