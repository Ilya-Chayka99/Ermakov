package ru.chay.spring.Stock;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class ManageStocks {
    private Map<String,Integer> stocks = new HashMap<>();
    private Map<String,List<StockObserver>> stockObserver = new HashMap<>();

    public void registerStock(Stock ...stock){
        for(Stock st:stock){
            stocks.put(st.getName(),st.getPrice());
        }
    }
    @Autowired
    public void collectStockObserver(List<StockObserver> st){
        for(StockObserver so:st){
            for(String str:so.getStocks()){
                List<StockObserver> list;
                if(stockObserver.containsKey(str)){
                    list = stockObserver.get(str);
                }
                else {
                    list = new ArrayList<>();
                }
                list.add(so);
                stockObserver.put(str,list);
            }
        }
    }
    public void setPrice(String name,Integer price){
        List<StockObserver> list= stockObserver.get(name);
        for(StockObserver so:list){
            so.update(new EventStock(name,price,stocks.get(name)));
        }
        stocks.put(name,price);

    }

}
