/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.alp.salwai;

/**
 *
 * @author Lenovo
 */
public class Buyer extends User {

    public Buyer(int id, String name, String password) {
        super(id, name, password);
    }

    public boolean hasPurchasedProduct(Product product) {
        return getOrders().stream()
                .flatMap(order -> order.getProducts().keySet().stream())
                .anyMatch(p -> p.equals(product));
    }

    public void addReview(Product product, Review review) {
        if (hasPurchasedProduct(product)) {
            product.addReview(review);
        }
    }
}
