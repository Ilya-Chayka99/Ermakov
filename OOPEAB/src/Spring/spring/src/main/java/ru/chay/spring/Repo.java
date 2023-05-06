package ru.chay.spring;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@NoArgsConstructor
public class Repo<R> {


    @SneakyThrows
    public <T> List<T> select1(){
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class<?> dep = Class.forName(type.getActualTypeArguments()[0].getTypeName());
        List<T> list=new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Airline".concat("?" + "currentSchema=public"),
                "ilya", "123e123e")) {

            Field[] field = dep.getDeclaredFields();
            String name = dep.getDeclaredAnnotation(Table.class).value();
            String args = Arrays
                    .stream(field)
                    .map(Field::getName)
                    .reduce("SELECT",(x,y)-> x.equals("SELECT") ?x+" "+y:x+" ,"+y)+" FROM "+name;

            PreparedStatement preparedStatement = connection.prepareStatement(args);
            ResultSet res1 = preparedStatement.executeQuery();

            while (res1.next()){
                T e =(T) dep.getConstructor().newInstance();
                for(Field f :field){
                    Field s= e.getClass().getDeclaredField(f.getName());
                    s.setAccessible(true);
                    s.set(e,res1.getObject(f.getName()));
                }
                list.add(e);
            }
            return list;
        } catch (Exception ignored){
            throw new RuntimeException(ignored);
        }
    }

}









//    @Autowired
//    Repositor repositor;