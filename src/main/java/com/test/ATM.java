package com.test;

import java.util.Scanner;

public class ATM implements BankService {
    private Bank bank;
    private Account account;
    private Scanner in;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        int ch = -1;

        while (ch != 0) {
            System.out.println("[1] Sign in");
            System.out.println("[0] Exit");

            ch = in.nextInt();

            if (ch == 1) {

            }
        }
    }
    public void mainMenu() {
        int ch = -1;

        while (ch != 0) {
            System.out.println("[1] Show balance");
            System.out.println("[2] Withdraw");
            System.out.println("[3] Top up");
            System.out.println("[0] Exit");
        }
    }

    @Override
    public void showBalance() {

    }
    @Override
    public void withdraw(double value) {

    }
    @Override
    public void topUp(double value) {

    }

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
