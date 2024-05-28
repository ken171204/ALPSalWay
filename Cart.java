/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.alp.salwai;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class Cart {

    private Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public void viewCart() {
        products.forEach((product, quantity) -> {
            System.out.println(product.getDetails() + ", Quantity: " + quantity);
        });
        System.out.println("Total: Rp" + formatPrice(getTotalPrice()));
    }

    public double getTotalPrice() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void clear() {
        products.clear();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private String formatPrice(double price) {
        return String.format("%,.0f", price);
    }
}
