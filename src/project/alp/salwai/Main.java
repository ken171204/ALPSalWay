/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.alp.salwai;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Main {

    private static List<Product> products = new LinkedList<>();
    private static Map<String, User> users = new HashMap<>();
    private static User currentUser;
    private static Cart currentCart;
    private static Queue<Order> orderQueue = new LinkedList<>();
    private static int orderIdCounter = 1;
    private static int reviewIdCounter = 1;

    public static void main(String[] args) {
        initializeSampleProducts();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (currentUser == null) {
                System.out.println("\nWelcome to the Online Shopping System!");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        login(scanner);
                        break;
                    case 2:
                        register(scanner);
                        break;
                    case 3:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                if (currentUser instanceof Seller) {
                    showSellerMenu(scanner);
                } else {
                    showBuyerMenu(scanner);
                }
            }
        }
    }

    private static void initializeSampleProducts() {
        products.add(new Product(1, "Laptop", "High-end gaming laptop", 17000000.00, "Electronics", "laptop.jpg"));
        products.add(new Product(2, "Smartphone", "Latest model smartphone", 12000000.00, "Electronics", "smartphone.jpg"));
        products.add(new Product(3, "Headphones", "Noise-cancelling headphones", 2500000.00, "Electronics", "headphones.jpg"));
        products.add(new Product(4, "Smartwatch", "Feature-rich smartwatch", 3000000.00, "Electronics", "smartwatch.jpg"));
        products.add(new Product(5, "Camera", "High-resolution digital camera", 8000000.00, "Electronics", "camera.jpg"));
        products.add(new Product(6, "Tablet", "10-inch screen tablet", 5000000.00, "Electronics", "tablet.jpg"));
        products.add(new Product(7, "Monitor", "4K Ultra HD monitor", 6000000.00, "Electronics", "monitor.jpg"));
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your name to login: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        currentUser = users.get(name);

        if (currentUser == null) {
            System.out.println("User not found. Would you like to register? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                register(scanner, name, password);
            } else {
                System.out.println("Returning to main menu.");
            }
        } else {
            if (currentUser.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + name + "!");
            } else {
                System.out.println("Incorrect password. Please try again.");
                currentUser = null;
            }
        }

        if (currentUser != null) {
            currentCart = new Cart();
        }
    }

    private static void register(Scanner scanner) {
        System.out.println("Register as:");
        System.out.println("1. Seller");
        System.out.println("2. Buyer");
        System.out.print("Select an option: ");
        int role = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your name to register: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(name)) {
            System.out.println("User already exists. Please try a different name.");
        } else {
            if (role == 1) {
                currentUser = new Seller(users.size() + 1, name, password);
                System.out.println("Seller registration successful. Welcome, " + name + "!");
            } else if (role == 2) {
                currentUser = new Buyer(users.size() + 1, name, password);
                System.out.println("Buyer registration successful. Welcome, " + name + "!");
            } else {
                System.out.println("Invalid role. Returning to main menu.");
                return;
            }
            users.put(name, currentUser);
        }
    }

    private static void register(Scanner scanner, String name, String password) {
        System.out.println("Register as:");
        System.out.println("1. Seller");
        System.out.println("2. Buyer");
        System.out.print("Select an option: ");
        int role = scanner.nextInt();
        scanner.nextLine();

        if (users.containsKey(name)) {
            System.out.println("User already exists. Please try a different name.");
        } else {
            if (role == 1) {
                currentUser = new Seller(users.size() + 1, name, password);
                System.out.println("Seller registration successful. Welcome, " + name + "!");
            } else if (role == 2) {
                currentUser = new Buyer(users.size() + 1, name, password);
                System.out.println("Buyer registration successful. Welcome, " + name + "!");
            } else {
                System.out.println("Invalid role. Returning to main menu.");
                return;
            }
            users.put(name, currentUser);
        }
    }

    private static void showSellerMenu(Scanner scanner) {
        System.out.println("\n1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. View Products");
        System.out.println("4. View Ratings");
        System.out.println("5. Logout");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addProduct(scanner);
                break;
            case 2:
                removeProduct(scanner);
                break;
            case 3:
                viewProducts();
                break;
            case 4:
                viewRatings();
                break;
            case 5:
                logout();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void showBuyerMenu(Scanner scanner) {
        System.out.println("\n1. View Products");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Place Order");
        System.out.println("5. View Orders");
        System.out.println("6. Add Review");
        System.out.println("7. Logout");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                viewProducts();
                break;
            case 2:
                addProductToCart(scanner);
                break;
            case 3:
                viewCart();
                break;
            case 4:
                placeOrder(scanner);
                break;
            case 5:
                viewOrders();
                break;
            case 6:
                addReview(scanner);
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();
        System.out.print("Enter product image URL: ");
        String image = scanner.nextLine();
        Product product = new Product(products.size() + 1, name, description, price, category, image);
        products.add(product);
        ((Seller) currentUser).addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter the product ID to remove: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = products.stream().filter(p -> p.getId() == productId).findFirst().orElse(null);

        if (product != null && ((Seller) currentUser).getProducts().contains(product)) {
            products.remove(product);
            ((Seller) currentUser).removeProduct(product);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found or you do not have permission to remove this product.");
        }
    }

    private static void viewRatings() {
        System.out.println("\nYour Product Ratings:");
        for (Product product : ((Seller) currentUser).getProducts()) {
            System.out.println(product.getName() + ": " + product.getRating() + " (" + product.getReviews().size() + " reviews)");
        }
    }

    private static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : products) {
            System.out.println(product.getDetails());
        }
    }

    private static void addProductToCart(Scanner scanner) {
        System.out.print("Enter the product ID to add to cart: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = products.stream().filter(p -> p.getId() == productId).findFirst().orElse(null);

        if (product != null) {
            currentCart.addProduct(product);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewCart() {
        System.out.println("\nYour Cart:");
        currentCart.viewCart();
    }

    private static void placeOrder(Scanner scanner) {
        if (currentCart.getProducts().isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        Order order = new Order(orderIdCounter++, currentUser, currentCart.getProducts());
        order.placeOrder();
        currentUser.addOrder(order);
        orderQueue.add(order);
        currentCart.clear();
        System.out.println("Order placed successfully. " + order.getTrackingInfo());
    }

    private static void viewOrders() {
        System.out.println("\nYour Orders:");
        for (Order order : currentUser.getOrders()) {
            System.out.println("Order ID: " + order.getId() + ", Status: " + order.getStatus());
        }
    }

    private static void addReview(Scanner scanner) {
        System.out.print("Enter the product ID to review: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = products.stream().filter(p -> p.getId() == productId).findFirst().orElse(null);

        if (product != null && !((Buyer) currentUser).hasPurchasedProduct(product)) {
            System.out.println("You cannot review a product you have not purchased.");
            return;
        }

        System.out.print("Enter your rating (0.0 to 5.0): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter your review comment: ");
        String comment = scanner.nextLine();
        Review review = new Review(reviewIdCounter++, currentUser, product, rating, comment, new Date());
        ((Buyer) currentUser).addReview(product, review);
        System.out.println("Review added successfully.");
    }

    private static void logout() {
        System.out.println("Logging out. Goodbye, " + currentUser.getName() + "!");
        currentUser = null;
        currentCart = null;
    }

    private static void exit() {
        System.out.println("Exiting the system. Goodbye!");
        System.exit(0);
    }
}
