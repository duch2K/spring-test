package com.test;

public class Account {
    private int id;
    private String userName;
    private double balance;
    private int pin;

    private static int idCount = 1;

    public Account(String userName, double balance, int pin) {
        this.id = idCount;
        this.userName = userName;
        this.balance = balance;
        this.pin = pin;

        idCount++;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
}
