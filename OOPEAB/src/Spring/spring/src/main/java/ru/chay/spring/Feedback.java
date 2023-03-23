package ru.chay.spring;

import lombok.ToString;

@ToString
public class Feedback {
    private String mass;
    private int rang;

    public Feedback(String mass, int rang) {
        this.mass = mass;
        this.rang = rang;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
}
