package ru.chay.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.chay.spring.Stock.ManageStocks;
import ru.chay.spring.Stock.Stock;
import ru.chay.spring.Streaming.Streaming;
import ru.chay.spring.TrafficLight.Black;
import ru.chay.spring.TrafficLight.Red;
import ru.chay.spring.TrafficLight.TrafficLight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {

		//SpringApplication.run(Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext("ru.chay.spring");
////		System.out.println(context.getBean("hello"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("random"));
//		System.out.println(context.getBean("date"));
////		System.out.println(context.getBean("hardToSay"));
//		System.out.println(context.getBean("topFeedback"));
//		System.out.println("---------------- 8.2.4");
//		System.out.println(context.getBean("getSt1"));
//		System.out.println("---------------- 8.2.5");
//		FabricaStudent fabricaStudent =(FabricaStudent) context.getBean("fabricaStudent");
//		System.out.println(fabricaStudent.createStudent("Rom"));
//		System.out.println(fabricaStudent.createStudent("Rom2", List.of(1,2,3,4,5,67,3,4)));
//		TrafficLight trafficLight = (TrafficLight) context.getBean("trafficLight");
//		trafficLight.next();
//		trafficLight.next();
//		trafficLight.on();
//		trafficLight.next();
//		trafficLight.next();
//		trafficLight.next();
//		trafficLight.next();
//		trafficLight.off();
//		trafficLight.next();
//		trafficLight.next();
//		System.out.println(context.getBean("range"));

//		Streaming streaming =context.getBean("streaming", Streaming.class);
//		streaming.compile();

		ManageStocks manageStocks = context.getBean("manageStocks", ManageStocks.class);
		manageStocks.registerStock(new Stock("ORCL",500),new Stock("TESLA",300));
		manageStocks.setPrice("ORCL",30);
		manageStocks.setPrice("TESLA",50);
		manageStocks.setPrice("ORCL",300);
		manageStocks.setPrice("ORCL",1);

	}

}
