/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.alp.salwai;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Review {

    private int id;
    private User user;
    private Product product;
    private double rating;
    private String comment;
    private Date date;

    public Review(int id, User user, Product product, double rating, String comment, Date date) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public String getReviewDetails() {
        return String.format("User: %s, Rating: %.1f, Comment: %s", user.getName(), rating, comment);
    }

    public double getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }
}
