/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.alp.salwai;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class User {

    private int id;
    private String name;
    private String password;
    private List<Order> orders;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.orders = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
