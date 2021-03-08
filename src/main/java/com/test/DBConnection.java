package com.test;

import java.sql.*;

public class DBConnection {
  private String url;
  private String username;
  private String password;
  private Connection connection;

  public DBConnection(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public Connection getConnection() throws Exception {
    return this.connection = DriverManager.getConnection(url, username, password);
  }

  public void closeConnection() throws Exception {
    this.connection.close();
  }

  public void init() {
    System.out.println("Set Init DBConnection\n");

    try {
      getConnection();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void destroy() {
    System.out.println("\nWas destroy DBConnection");

    try {
      closeConnection();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public ResultSet getData(String sql) {
    ResultSet resultSet = null;

    try {
      PreparedStatement statement = this.connection.prepareStatement(sql);
      resultSet = statement.executeQuery();
    } catch (SQLException sqlEx) {
      sqlEx.printStackTrace();
    }
    return resultSet;
  }

  public void updateData(String sql) {
    try {
      PreparedStatement statement = this.connection.prepareStatement(sql);
      statement.executeUpdate();
    } catch (SQLException sqlEx) {
      sqlEx.printStackTrace();
    }
  }
}
