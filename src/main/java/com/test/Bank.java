package com.test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bank {
//  private List<Account> accounts;
  private DBConnection db;

  public Bank(DBConnection db) {
    this.db = db;
  }

  public Account getUser(int id) {
    String sql = "SELECT * FROM account WHERE id = " + id;

    try {
      Statement statement = this.db.getConnection().createStatement();
      ResultSet result = statement.executeQuery(sql);

      if (result.next()) {
        int id2 = result.getInt("id");
        String userName2 = result.getString("username");
        double balance = result.getDouble("balance");
        String pin2 = result.getString("pin");

        return new Account(id2, userName2, balance, pin2);
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  public Account getUser(String userName, String pin) {
    String sql = "SELECT * FROM account WHERE userName = '" + userName + "' and pin = '" + pin + "'";

    try {
      Statement statement = this.db.getConnection().createStatement();
      ResultSet result = statement.executeQuery(sql);

      if (result.next()) {
        int id = result.getInt("id");
        String userName2 = result.getString("username");
        double balance = result.getDouble("balance");
        String pin2 = result.getString("pin");

        return new Account(id, userName2, balance, pin2);
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  public boolean userWithdraw(int id, double value) {
    Account user = this.getUser(id);

    if (value <= user.getBalance()) {
      try {
        String sql = "UPDATE account SET balance = balance - " + value + " WHERE id = " + id;
        Statement statement = this.db.getConnection().createStatement();
        statement.executeUpdate(sql);
      } catch (Exception ex) {
        ex.printStackTrace();
        return false;
      }
      return true;
    }

    return false;
  }

  public boolean userTopUp(int id, double value) {
    if (value <= 1000000) {
      try {
        String sql = "UPDATE account SET balance = balance + " + value + " WHERE id = " + id;
        Statement statement = this.db.getConnection().createStatement();
        statement.executeUpdate(sql);
      } catch (Exception ex) {
        ex.printStackTrace();
        return false;
      }
      return true;
    }
    return false;
  }

  public List<Account> getUsers() {
    List<Account> users = new ArrayList();
    String sql = "SELECT * FROM account";
    try {
      Statement statement = this.db.getConnection().createStatement();
      ResultSet result = statement.executeQuery(sql);

      while (result.next()) {
        int id = result.getInt("id");
        String userName = result.getString("userName");
        double balance = result.getDouble("balance");
        String pin = result.getString("pin");

        users.add(new Account(id, userName, balance, pin));
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return users;
  }
}
