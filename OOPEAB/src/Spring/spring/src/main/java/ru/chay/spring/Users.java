package ru.chay.spring;

import lombok.Data;
@Data
@Table("users")

public class Users {
    private String username;
    private Long id;
    private Integer depart;

    public Users() {
    }

    @Override
    public String toString() {
        return "\nUsers{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", depart=" + depart +
                '}';
    }
}