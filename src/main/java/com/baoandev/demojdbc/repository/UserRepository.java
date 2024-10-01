package com.baoandev.demojdbc.repository;

import com.baoandev.demojdbc.entity.User;
import com.baoandev.demojdbc.ulti.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final DBConnection dbConnection = new DBConnection();
    private final String INSERT_USER_SQL = "INSERT INTO users(name, email, country) VALUES(?,?,?)";
    private final String SELECT_USER_SQL = "SELECT id,name, email, country FROM users LIMIT ?,?";

    public Connection getConnection() {
        return dbConnection.getConnection();
    }

    public void insertUser(String name, String email, String country) {
        try {
            Connection connection = getConnection();
            connection.prepareStatement(INSERT_USER_SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> selectUser() { // select * from users; -> List<User>
        List<User> userList = new ArrayList<>(); // select * from users; -> List<User>
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, 10);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
