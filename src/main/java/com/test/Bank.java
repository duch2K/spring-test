package com.test;

import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account getUser(int id) {
        for (Account acc : this.accounts) {
            if (acc.getId() == id)
                return acc;
        }

        System.out.println("ERROR! This user doesn't exist!");
        return null;
    }

    public Account verifyUser(String name, int pin) {
        for (Account acc : this.accounts) {
            if (acc.getUserName().equals(name) && acc.getPin() == pin)
                return acc;
        }

        return null;
    }

    public void userWithdraw(int id, double value) {
        Account user = this.getUser(id);

        if (value <= user.getBalance()) {
            user.setBalance(user.getBalance() - value);
            System.out.println("Success!");
        } else {
            System.out.println("ERROR! Not enough money!");
        }
    }

    public void userTopUp(int id, double value) {
        Account user = this.getUser(id);

        if (value <= 1000000) {
            user.setBalance(user.getBalance() + value);
            System.out.println("Success!");
        } else {
            System.out.println("ERROR! Too much money!");
        }
    }
}
