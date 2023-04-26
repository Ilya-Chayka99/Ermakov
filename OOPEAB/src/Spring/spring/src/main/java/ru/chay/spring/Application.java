package ru.chay.spring;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.chay.spring.Stock.ManageStocks;
import ru.chay.spring.Stock.Stock;
import ru.chay.spring.Streaming.Streaming;
import ru.chay.spring.TrafficLight.*;

import javax.xml.transform.Result;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {
	@SneakyThrows
	public static void main(String[] args) throws IOException {

		//SpringApplication.run(Application.class, args);
//		ApplicationContext context = new AnnotationConfigApplicationContext("ru.chay.spring");

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


		System.out.println(selectEmploeByDepartment("Zara"));
		System.out.println(selectEmploeByDepartment("Inpit"));

	}

	@SneakyThrows
	public static List<Emploe> selectEmploeByDepartment(String dep){
		List<Emploe> list=new ArrayList<>();
		Class.forName("org.postgresql.Driver");
		try(Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Airline".concat("?" + "currentSchema=public"),
				"ilya", "123e123e")) {

//			Statement st = connection.createStatement();

//			st.execute("INSERT INTO users(username, depart) values ('aa',1)");
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT users.id as id, users.username as user , department.name as dep FROM users " +
							"join department on department.id = users.depart " +
							"where department.name=?");
			preparedStatement.setString(1, dep);
			ResultSet res1 = preparedStatement.executeQuery();
//			res.next();
			while (res1.next()){
				Emploe e = new Emploe();
				e.setName(res1.getString("user"));
				e.setId(Integer.parseInt(res1.getString("id")));
				e.setDep(res1.getString("dep"));
//				System.out.println(res1.getString("id")+" "+res1.getString("dep"));
				list.add(e);
			}
			return list;
//			System.out.println(res.getString(2));
// <T> List<T> select(Class<T>) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1

		} catch (Exception ignored){
			throw new RuntimeException(ignored);
		}


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






