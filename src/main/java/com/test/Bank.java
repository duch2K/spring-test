package com.test;

import java.util.List;

public class Bank {
    private List<Account> accounts;

    private int idCount = 1;

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account getUser(int idx) {
        return this.accounts.get(idx);
    }
}
