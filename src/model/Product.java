package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private int id;
    private String name;
//    thể tích, dung tích sản phẩm
    private int volume;
//    số lượng sản phẩm
    private int amount;
    private double price;
    private ArrayList<Product> cart = new ArrayList<>();

    public Product() {
    }


    public Product(int id, String name, int volume, int amount, double price) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.amount = amount;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String covertPrice(double price) {
        String covertPrice = String.format("%.0f VND", price);
        return covertPrice;
    } public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return String.format("%15s%-15s%-15s%-15s%-15s%-6s","",id,name,volume,amount,covertPrice(getPrice()));
    }

}
