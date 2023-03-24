package ru.chay.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import ru.chay.spring.Stock.EventStock;
import ru.chay.spring.Stock.StockObserver;
import ru.chay.spring.Streaming.DataReader;
import ru.chay.spring.Streaming.DataWriter;
import ru.chay.spring.Streaming.Process;
import ru.chay.spring.Streaming.Streaming;
import ru.chay.spring.TrafficLight.Color;
import ru.chay.spring.TrafficLight.TrafficLight;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;

@Configuration
public class Config {
    @Bean
    String hello(){
        return "Hello world";
    }
    @Bean
    @Scope("prototype")
    int random(Rand rand){
        return rand.rand();
    }

    @Bean
    @Lazy
    Date date(){
        return new Date();
    }
    @Bean
    @Qualifier("Stud")
    Predicate<Integer> range(){
        return (x)->(x>=2 && x<=5);
    }
    @Bean
    int min(){
        return 1;
    }
    @Bean
    int max(){
        return 5;
    }

    @Bean
    Feedback good(){
        return new Feedback("Очень хорошо",4);
    }
    @Bean
    Feedback usual(){
        return new Feedback("Сойдет",3);
    }
    @Bean
    @Lazy
    Feedback hardToSay(int random){
        return new Feedback("Сложно сказать",random);
    }
    @Bean
    @Lazy
    Feedback topFeedback(List<Feedback> rev){
        Feedback f = rev.get(0);
        for(Feedback fid:rev)
            if(f.getRang()< fid.getRang())
                f=fid;
        return f;
    }
    @Bean
    @Scope("prototype")
    Student getSt(@Qualifier("Stud") Predicate<Integer> rule){
        return new Student("DR", Arrays.asList(1,4,8,4,99,3,5),rule);
    }
    @Bean
    @Scope("prototype")
    TrafficLight trafficLight(Color black){
        return new TrafficLight(black);
    }

    //streaming ----------------------------------------------
    @Bean
    @Qualifier("IN")
    String nameFileInput(){
        return "src/main/java/ru/chay/spring/Streaming/my.txt";
    }
    @Bean
    @Qualifier("OUT")
    String nameFileOutput(){
        return "src/main/java/ru/chay/spring/Streaming/my2.txt";
    }
    @Bean
    @Scope("prototype")
    @Order(4)
    Process<String> processRemove1(){
        return new Process<String>() {
            @Override
            public String process(String string) {
                System.out.println(4);
                return string.replaceAll("1","");
            }
        };
    }
    @Bean
    @Scope("prototype")
    @Order(1)
    Process<String> processToUpperCase(){
        return new Process<String>() {
            @Override
            public String process(String string) {
                System.out.println(1);
                return string.toUpperCase();
            }
        };
    }
    @Bean
    @Scope("prototype")
    @Order(2)
    Process<String> processRemoveA(){
        return new Process<String>() {
            @Override
            public String process(String string) {
                System.out.println(2);
                return string.replaceAll("А","");
            }
        };
    }
    @Bean
    @Scope("prototype")
    @Order(3)
    Process<String> processLongWords(){
        return new Process<String>() {
            @Override
            public String process(String string) {
                System.out.println(3);
                StringBuilder st = new StringBuilder();
                for(String word:string.split(" ")){
                   if(word.length()>4){
                       st.append(word);
                       st.append(" ");
                   }
                }
                return st.toString();
            }
        };
    }
    @Bean
    @Scope("prototype")
    DataReader dataReader(@Qualifier("IN")String name){
        return new DataReader() {
            @Override
            public String reader() throws FileNotFoundException {
                String list="";
                File f =new File(name);
                Scanner sc = new Scanner(f);
                while (sc.hasNext()){
                    list+=sc.nextLine()+"\n";

                }
                sc.close();
                return list;
            }
        };
    }
    @Bean
    @Scope("prototype")
    DataWriter dataWriter(@Qualifier("OUT")String name){
        return new DataWriter() {
            @Override
            public void writer(String s) throws IOException {
                PrintWriter writer1 =new PrintWriter(name);
                writer1.write(s);
                writer1.flush();
                writer1.close();
            }
        };
    }
    @Bean
    @Scope("prototype")
    Streaming streaming(DataReader dataReader, DataWriter dataWriter,List<Process> list){
        return new Streaming(dataReader,dataWriter,list);
    }

    //Observer Stocks -----------------------------------------------
    @Bean
    @Scope("prototype")
    StockObserver printer(){
        return new StockObserver() {
            private String[] stocks={"ORCL"};

            public String[] getStocks() {
                return stocks;
            }

            @Override
            public void update(EventStock event) {
                if (event.getStockName().equals("ORCL") && event.getNewPrice() < 70) {
                    System.out.println("PRINTER: Need to buy ORCL! price: "+event.getNewPrice());
                }
            }
        };
    }
    @Bean
    @Scope("prototype")
    StockObserver bot(){
        return new StockObserver() {
            private String[] stocks={"ORCL","TESLA"};

            public String[] getStocks() {
                return stocks;
            }

            @Override
            public void update(EventStock event) {
                if (Arrays.stream(stocks).toList().contains(event.getStockName())) {
                    System.out.println("BOT: Stock " + event.getStockName() + " price changed to " + event.getNewPrice());
                }
            }
        };
    }



}
