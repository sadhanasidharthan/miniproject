package com.product.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.product.dao.Product;
import com.product.dao.Review;
import com.product.dao.User;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/x";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "churchil";

    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User addUser(String username, String email) {
        String query = "INSERT INTO Users (Username, Email) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, username);
            statement.setString(2, email);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 1) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);
                        return new User(userId, username, email);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByUsername(String username) {
        String query = "SELECT * FROM Users WHERE Username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int userId = resultSet.getInt("UserId");
                    String email = resultSet.getString("Email");
                    return new User(userId, username, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductId");
                String productName = resultSet.getString("ProductName");
                String description = resultSet.getString("Description");
                double price = resultSet.getDouble("Price");
                Product product = new Product(productId, productName, description, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Review> getProductReviews(int productId) {
        List<Review> reviews = new ArrayList<>();
        String query = "SELECT * FROM Reviews WHERE ProductId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int reviewId = resultSet.getInt("ReviewId");
                    int userId = resultSet.getInt("UserId");
                    int rating = resultSet.getInt("Rating");
                    String comment = resultSet.getString("Comment");
                    Date date = resultSet.getDate("Date");
                    Review review = new Review(reviewId, productId, userId, rating, comment, date);
                    reviews.add(review);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public Review addReview(int productId, int userId, int rating, String comment, Date reviewDate) {
        String query = "INSERT INTO Reviews (ProductId, UserId, Rating, Comment, Date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, productId);
            statement.setInt(2, userId);
            statement.setInt(3, rating);
            statement.setString(4, comment);
            statement.setDate(5, new java.sql.Date(reviewDate.getTime()));
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 1) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int reviewId = generatedKeys.getInt(1);
                        return new Review(reviewId, productId, userId, rating, comment, reviewDate);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product newProduct) {
        String query = "INSERT INTO Products (ProductName, Description, Price) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newProduct.getProductName());
            statement.setString(2, newProduct.getDescription());
            statement.setDouble(3, newProduct.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
