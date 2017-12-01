package com.acel.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.acel.ch2.el")
@PropertySource("classpath:test.properties")//7
public class ElConfig {
	
	@Value("I Love You!") //1 固定
    private String normal;

	@Value("#{systemProperties['os.name']}") //2 操作系统属性
	private String osName;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }") //3 表达式
    private double randomNumber;

	@Value("#{demoService.another}") //4 其他类的属性
	private String fromAnother;

	@Value("classpath:test.txt") //5 文件
	private Resource testFile;

	@Value("http://www.baidu.com") //6 网络
	private Resource testUrl;

	@Value("${book.name}") //7 配置文件
	private String bookName;

	@Autowired
	private Environment environment; //7
	
	@Bean //7
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	


	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			
			System.out.println(IOUtils.toString(testFile.getInputStream(), "UTF-8"));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
