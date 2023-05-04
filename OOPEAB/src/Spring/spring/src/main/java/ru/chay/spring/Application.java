package ru.chay.spring;

import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
	@SneakyThrows
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext("ru.chay.spring");

		Repo repo= context.getBean(Repo.class);
		System.out.println(repo.select1(Emploe.class));











//		Repositor repositor = context.getBean(Repositor.class);
//		System.out.println(repositor.findAll());
//		System.out.println(repositor.countByUsername());



//		SpringApplication.run(Application.class, args);

//		Stream.generate(()->2)
//				.limit(4)
//				.forEach(System.out::println);

//		Stream.of("Privet   ","Vasa  ","zz ","upt","yy")
//				.map(x->x.trim())
//				.collect(Collectors.groupingBy(String::length))
//				.entrySet()
//				.forEach(System.out::println);
//		Student s1 = new Student("Vasa");
//		Student s2 = new Student("Katia");
//		Student s3 = new Student("Ilya");
//		Student s4 = new Student("Oleg");
//		Student s5 = new Student("Petya");
//		s1.setRang(4,5,5,5,5);
//		s2.setRang(2,2,3,5);
//		s3.setRang(5,5,5,5);
//		s4.setRang(4,4,4,4,4);
//		s5.setRang(4,5,5,5,5,2,2,2);
//
//		Stream.of(s1,s2,s3,s4,s5)
//				.collect(Collectors.groupingBy(Student::getAvg))
//				.entrySet()
//				.forEach(System.out::println);


//		List<Integer> k = Stream.of(1,3,5,2,9,8)
//				.filter(x->x%2==0)
//				.map(x->x/2)
////				.reduce(0, Integer::sum)
//				.collect(Collectors.toList());
//		System.out.println(k);
//
//		long z= Stream.of(1,5,-6,-5,-1)
//				.filter(x->x>=0)
//				.count();
//		System.out.println(z);

//		int c= Stream.of("1","-3","-7","20")
//				.map(Integer::parseInt)
//				.map(Math::abs)
//				.max()
//				.orElse(0);

//		String ss= Stream.of("qwe","aa","abc")
//				.filter(x->x.contains("a"))
//				.collect(Collectors.joining(" ","<",">"));
//		System.out.println(ss);
//
//		long u= Stream.of("qwe","aa","abc")
//				.flatMapToInt(String::chars)
//				.filter(x->x=='a')
//				.count();
//		System.out.println(u);
//
//		System.out.println(Stream.of("qwe","aa","abc")
//				.collect(Collectors.groupingBy(x->x.charAt(0))));
//
//
//		System.out.println( Stream.of("qwe","aa","abc",null)
//				.filter(Objects::nonNull)
//				.flatMapToInt(String::chars)
//				.distinct()
//				.count()
//		);
//
//		System.out.println( Stream.of("qwe ggr","aa","abc",null)
//				.filter(Objects::nonNull)
//				.map(x->x.split(" "))
//				.flatMap(Arrays::stream)
//				.filter(x->x.length()>=3)
//				.count()
//
//
////				точки
////				уникальные
////				сортировка
////				в одну ломанную
//
//		);

//		PoliLine pp= Stream.of(new Point(99,6),new Point(1,3),new Point(1,3),new Point(6,99))
//				.sorted((o1, o2) ->o1.y > o2.y? 1 : -1)
//				.distinct()
//				.reduce(new PoliLine(),PoliLine::addPoliLinePoint,PoliLine::getPoliLine);
//		System.out.println(pp);

	}


}




































// 		- Пустой стрим: Stream.empty() // Stream<String>
//		- Стрим из List: list.stream() // Stream<String>
//		- Стрим из Map: map.entrySet().stream() // Stream<Map.Entry<String, String>>
//		- Стрим из массива: Arrays.stream(array) // Stream<String>
//		- Стрим из указанных элементов: Stream.of("a", "b", "c") // Stream<String>


//	List<Integer> list = Stream.of(1, 2, 3)
//			.collect(Collectors.toList());
//// list: [1, 2, 3]
//
//	String s = Stream.of(1, 2, 3)
//			.map(String::valueOf)
//			.collect(Collectors.joining("-", "<", ">"));
//// s: "<1-2-3>"






