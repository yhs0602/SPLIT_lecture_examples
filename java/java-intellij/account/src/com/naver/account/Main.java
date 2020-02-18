package com.naver.account;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Account account1 = Account.createAccount("철수", "100-10100010-11111", 100000);
        Account account2 = Account.createAccount("영희", "102-10304010-12111", 200000);

        account1.describe();
        account2.describe();

//        account1.deposit(1000);
//        account2.deposit(1000);

        account1.send(5000000, account2);

//        account2.money = 100000000;
        account2.draw(1000000);
        account1.describe();
        account2.describe();
    }
}
