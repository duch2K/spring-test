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
        String name;
        int pin;

        System.out.println("Enter user name:");
        name = in.nextLine();

        System.out.println("Enter pin code:");
        pin = in.nextInt();

        if (this.bank.verifyUser(name, pin) != null) {
            this.setAccount(this.bank.verifyUser(name, pin));
            mainMenu();

        } else
            System.out.println("ERROR! Wrong user name or password!");
    }

    public void mainMenu() {
        int ch = -1;

        while (ch != 0) {
            System.out.println("[1] Show balance");
            System.out.println("[2] Withdraw");
            System.out.println("[3] Top up");
            System.out.println("[0] Exit");

            ch = in.nextInt();

            if (ch == 1) {
                showBalance();
            } else if (ch == 2) {
                System.out.println("Enter value: ");
                double wVal = in.nextDouble();
                withdraw(wVal);
            } else if (ch == 3) {
                System.out.println("Insert cash: ");
                double tVal = in.nextDouble();
                topUp(tVal);
            }
        }
    }

    @Override
    public void showBalance() {
        System.out.println(this.account.getBalance());
    }
    @Override
    public void withdraw(double value) {
        this.bank.userWithdraw(this.account.getId(), value);
    }
    @Override
    public void topUp(double value) {
        this.bank.userTopUp(this.account.getId(), value);
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
