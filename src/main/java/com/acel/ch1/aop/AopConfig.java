package com.acel.ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.acel.ch1.aop")
@EnableAspectJAutoProxy //1
public class AopConfig {

}
