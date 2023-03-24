package ru.chay.spring.Stock;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
public class Stock {
    private final String name;
    private int price;
    public Stock(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
