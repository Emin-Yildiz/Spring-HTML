package com.example.html.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Builder
@Entity
@Table(name = "users")
public class UserHtml {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private int age;

    private boolean isLive;

    public UserHtml(Long id, String username, String password, int age, boolean isLive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.isLive = isLive;
    }

    public UserHtml(String username, String password, int age, boolean isLive) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.isLive = isLive;
    }

    public UserHtml(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId(){
        return id;
    }
    public String getUserName(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getAge(){
        return age;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }
}
