/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.alp.salwai;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Seller extends User {

    private List<Product> products;

    public Seller(int id, String name, String password) {
        super(id, name, password);
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}
