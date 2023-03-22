package ru.chay.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//SpringApplication.run(Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext("ru.chay.spring");
		System.out.println(context.getBean("loop"));
	}

}
