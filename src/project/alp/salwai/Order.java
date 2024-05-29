/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.alp.salwai;

import java.util.Map;
import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class Order {

    private int id;
    private User user;
    private Map<Product, Integer> products;
    private String status;
    private String trackingNumber;

    public Order(int id, User user, Map<Product, Integer> products) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.status = "Processing";
    }

    public void placeOrder() {
        this.status = "Placed";
        this.trackingNumber = "TRK" + id + new Random().nextInt(10000);
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public String getTrackingInfo() {
        return "Tracking Number: " + trackingNumber + ", Estimated Delivery Days: " + (new Random().nextInt(10) + 1);
    }
}
