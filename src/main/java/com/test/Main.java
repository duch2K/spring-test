package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext"
        );

        ATM atm = context.getBean("atmBean", ATM.class);
        atm.run();
    }
}
