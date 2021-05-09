package com.mm.challenges.app1.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mm.challenges.app1.registration.model.User;

public class UserDao {

    public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO app1_users" +
            "  (id, firstname, lastname, email, address) VALUES " +
            " (?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
 
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "password");

           
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getAddress());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}