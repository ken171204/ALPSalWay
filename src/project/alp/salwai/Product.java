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
public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String image;
    private double rating;
    private List<Review> reviews;

    public Product(int id, String name, String description, double price, String category, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
        this.reviews = new ArrayList<>();
        this.rating = 0.0;
    }

    public void addReview(Review review) {
        reviews.add(review);
        updateRating();
    }

    private void updateRating() {
        this.rating = reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
    }

    public String getDetails() {
        return String.format("Product ID: %d, Name: %s, Price: Rp%.0f, Rating: %.1f", id, name, price, rating);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public double getRating() {
        return rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
