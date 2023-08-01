
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        DatabaseManager databaseManager = new DatabaseManager();
//
//        // Welcome message and menu options
//        System.out.println("Welcome to the Product Review Console Application!");
//        System.out.println("1. Register");
//        System.out.println("2. Log in");
//        System.out.println("3. View Products");
//        System.out.println("4. View Product Reviews");
//        System.out.println("5. Write a Review");
//        System.out.println("6. Exit");
//
//        User currentUser = null;
//
//        while (true) {
//            System.out.print("\nPlease enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter your username: ");
//                    String username = scanner.nextLine();
//                    System.out.print("Enter your email: ");
//                    String email = scanner.nextLine();
//                    User user = databaseManager.addUser(username, email);
//                    if (user != null) {
//                        currentUser = user;
//                        System.out.println("User registration successful!");
//                    } else {
//                        System.out.println("User registration failed!");
//                    }
//                    break;
//                case 2:
//                    System.out.print("Enter your username: ");
//                    String loginUsername = scanner.nextLine();
//                    User loggedInUser = databaseManager.getUserByUsername(loginUsername);
//                    if (loggedInUser != null) {
//                        currentUser = loggedInUser;
//                        System.out.println("User logged in successfully!");
//                    } else {
//                        System.out.println("User not found!");
//                    }
//                    break;
//                case 3:
//                    List<Product> products = databaseManager.getAllProducts();
//                    for (Product product : products) {
//                        System.out.println("---------------------------------");
//                        System.out.println("Product ID: " + product.getProductId());
//                        System.out.println("Product Name: " + product.getProductName());
//                        System.out.println("Description: " + product.getDescription());
//                        System.out.println("Price: $" + product.getPrice());
//                        System.out.println("---------------------------------");
//                    }
//                    break;
//                case 4:
//                    System.out.print("Enter the Product ID to view reviews: ");
//                    int productToViewReviews = scanner.nextInt();
//                    List<Review> reviews = databaseManager.getProductReviews(productToViewReviews);
//                    for (Review review : reviews) {
//                        System.out.println("---------------------------------");
//                        System.out.println("Review ID: " + review.getReviewId());
//                        System.out.println("Product ID: " + review.getProductId());
//                        System.out.println("User ID: " + review.getUserId());
//                        System.out.println("Rating: " + review.getRating());
//                        System.out.println("Comment: " + review.getComment());
//                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                        System.out.println("Date: " + dateFormat.format(review.getDate()));
//                        System.out.println("---------------------------------");
//                    }
//                    break;
//                case 5:
//                    if (currentUser == null) {
//                        System.out.println("You need to log in first to write a review.");
//                    } else {
//                        System.out.print("Enter the Product ID: ");
//                        int productIdForReview = scanner.nextInt();
//                        System.out.print("Enter your rating (1 to 5): ");
//                        int rating = scanner.nextInt();
//                        scanner.nextLine(); // Consume the newline character
//                        System.out.print("Enter your comment: ");
//                        String comment = scanner.nextLine();
//                        Date reviewDate = new Date();
//                        Review addedReview = databaseManager.addReview(productIdForReview, currentUser.getUserId(), rating, comment, reviewDate);
//                        if (addedReview != null) {
//                            System.out.println("Review submitted successfully!");
//                        } else {
//                            System.out.println("Failed to submit the review.");
//                        }
//                    }
//                    break;
//                case 6:
//                    databaseManager.closeConnection();
//                    System.out.println("Thank you for using the Product Review Console Application. Goodbye!");
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//}
package com.product.main;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        DatabaseManager databaseManager = new DatabaseManager();
//
//        // Welcome message and menu options
//        System.out.println("Welcome to the Product Review Console Application!");
//        System.out.println("1. Register");
//        System.out.println("2. Log in");
//        System.out.println("3. Add a Product");
//        System.out.println("4. View Products");
//        System.out.println("5. View Product Reviews");
//        System.out.println("6. Write a Review");
//        System.out.println("7. Exit");
//
//        while (true) {
//            System.out.print("Please enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//
//            switch (choice) {
//                case 1:
//                    // Code for user registration
//                    System.out.print("Enter your username: ");
//                    String username = scanner.nextLine();
//                    System.out.print("Enter your email: ");
//                    String email = scanner.nextLine();
//                    User user = new User(1, username, email); // Assume the user is already logged in with UserId = 1
//                    System.out.println("User registration successful!");
//                    break;
//                case 2:
//                    // Code for user login
//                    System.out.print("Enter your username: ");
//                    String loginUsername = scanner.nextLine();
//                    // Implement the login logic to verify the username and password.
//                    // You may need to fetch user details from the database and compare the provided username and password.
//                    // Assume the user is successfully logged in with UserId = 1.
//                    System.out.println("User logged in successfully!");
//                    break;
//                case 3:
//                    // Code to add a new product
//                    System.out.print("Enter the Product Name: ");
//                    String productName = scanner.nextLine();
//                    System.out.print("Enter the Description: ");
//                    String description = scanner.nextLine();
//                    System.out.print("Enter the Price: ");
//                    double price = scanner.nextDouble();
//                    Product newProduct = new Product(103, productName, description, price); // Assume a new product with ProductId = 103
//                    databaseManager.addProduct(newProduct);
//                    System.out.println("Product added successfully!");
//                    break;
//                case 4:
//                    // Code to view products
//                    List<Product> products = databaseManager.getAllProducts();
//                    System.out.println("Product Listing:");
//                    for (Product product : products) {
//                        System.out.println("---------------------------------");
//                        System.out.println("Product ID: " + product.getProductId());
//                        System.out.println("Product Name: " + product.getProductName());
//                        System.out.println("Description: " + product.getDescription());
//                        System.out.println("Price: $" + product.getPrice());
//                        System.out.println("---------------------------------");
//                    }
//                    break;
//                case 5:
//                    // Code to view product reviews
//                    System.out.print("Enter the Product ID to view reviews: ");
//                    int productId = scanner.nextInt();
//                    List<Review> reviews = databaseManager.getProductReviews(productId);
//                    System.out.println("Product Reviews:");
//                    for (Review review : reviews) {
//                        System.out.println("---------------------------------");
//                        System.out.println("Review ID: " + review.getReviewId());
//                        System.out.println("Product ID: " + review.getProductId());
//                        System.out.println("User ID: " + review.getUserId());
//                        System.out.println("Rating: " + review.getRating());
//                        System.out.println("Comment: " + review.getComment());
//                        System.out.println("Date: " + review.getDate());
//                        System.out.println("---------------------------------");
//                    }
//                    break;
//                case 6:
//                    // Code to write a review
//                    break;
//                case 7:
//                    System.out.println("Thank you for using the Product Review Console Application. Goodbye!");
//                    databaseManager.closeConnection();
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//}
import java.util.*;

import com.product.DBHandler.DatabaseManager;
import com.product.dao.Product;
import com.product.dao.Review;
import com.product.dao.User;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager databaseManager = new DatabaseManager();
        User currentUser = null;

        // Welcome message and menu options
        System.out.println("Welcome to the Product Review Console Application!");
        System.out.println("1. Register");
        System.out.println("2. Log in");
        System.out.println("3. Add a Product");
        System.out.println("4. View Products");
        System.out.println("5. View Product Reviews");
        System.out.println("6. Write a Review");
        System.out.println("7. Exit");

        while (true) {
            System.out.print("\nPlease enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    User user = new User(1, username, email); // Assume the user is already logged in with UserId = 1
                    databaseManager.addUser(username, email);
                    System.out.println("User registration successful!");
                    break;
                case 2:
                    System.out.print("Enter your username: ");
                    String loginUsername = scanner.nextLine();
                    // Implement the login logic to verify the username and password.
                    // You may need to fetch user details from the database and compare the provided username and password.
                    // Assume the user is successfully logged in with UserId = 1.
                    currentUser = new User(1, loginUsername, "user@example.com");
                    System.out.println("User logged in successfully!");
                    break;
                case 3:
                    System.out.print("Enter the Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter the Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter the Price: ");
                    double price = scanner.nextDouble();
                    Product newProduct = new Product(103, productName, description, price); // Assume a new product with ProductId = 103
                    databaseManager.addProduct(newProduct);
                    System.out.println("Product added successfully!");
                    break;
                case 4:
                    List<Product> products = databaseManager.getAllProducts();
                    System.out.println("Product Listing:");
                    for (Product product : products) {
                        System.out.println("---------------------------------");
                        System.out.println("Product ID: " + product.getProductId());
                        System.out.println("Product Name: " + product.getProductName());
                        System.out.println("Description: " + product.getDescription());
                        System.out.println("Price: $" + product.getPrice());
                        System.out.println("---------------------------------");
                    }
                    break;
                case 5:
                    System.out.print("Enter the Product ID to view reviews: ");
                    int productId = scanner.nextInt();
                    List<Review> reviews = databaseManager.getProductReviews(productId);
                    System.out.println("Product Reviews:");
                    for (Review review : reviews) {
                        System.out.println("---------------------------------");
                        System.out.println("Review ID: " + review.getReviewId());
                        System.out.println("Product ID: " + review.getProductId());
                        System.out.println("User ID: " + review.getUserId());
                        System.out.println("Rating: " + review.getRating());
                        System.out.println("Comment: " + review.getComment());
                        System.out.println("Date: " + review.getDate());
                        System.out.println("---------------------------------");
                    }
                    break;
                case 6:
                    if (currentUser == null) {
                        System.out.println("You need to log in first to write a review.");
                    } else {
                        System.out.print("Enter the Product ID: ");
                        int productIdForReview = scanner.nextInt();
                        System.out.print("Enter your rating (1 to 5): ");
                        int rating = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter your comment: ");
                        String comment = scanner.nextLine();
                        Date reviewDate = new Date();
                        Review addedReview = databaseManager.addReview(productIdForReview, currentUser.getUserId(), rating, comment, reviewDate);
                        if (addedReview != null) {
                            System.out.println("Review submitted successfully!");
                        } else {
                            System.out.println("Failed to submit the review.");
                        }
                    }
                    break;
                case 7:
                    databaseManager.closeConnection();
                    System.out.println("Thank you for using the Product Review Console Application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
