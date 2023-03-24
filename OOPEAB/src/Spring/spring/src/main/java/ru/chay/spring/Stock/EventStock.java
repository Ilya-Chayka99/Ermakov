package ru.chay.spring.Stock;

public class EventStock {
    private String stock;
    private Integer prise;
    private Integer lprise;

    public EventStock(String stock, Integer prise, Integer lprise) {
        this.stock = stock;
        this.prise = prise;
        this.lprise = lprise;
    }

    public String getStockName(){
        return stock;
    }

    public Integer getNewPrice() {
        return prise;
    }

    public Integer getOldPrice() {
        return lprise;
    }
}
