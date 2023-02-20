package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private String username;
    private String name;
    private int age;
    private  String password;
    private ArrayList<Product> cart = new ArrayList<>();

    public Account() {
    }

    public Account(String username, String name, int age, String password) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", cart=" + cart +
                '}';
    }
}
