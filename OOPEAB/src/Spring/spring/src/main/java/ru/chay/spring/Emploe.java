package ru.chay.spring;

import lombok.Data;
import lombok.ToString;

@Data
@Table("users")
public class Emploe {
    private String username;
    private Long id;
    private Integer depart;

    public Emploe() {
    }

    @Override
    public String toString() {
        return "\nEmploe{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", depart=" + depart +
                '}';
    }
}
