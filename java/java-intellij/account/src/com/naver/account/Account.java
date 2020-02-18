package com.naver.account;

public class Account {
    private String name;
    private String accountNumber;
    private long money;

    int draw(int amount) {
        if (amount < 0) {
            System.out.println("음수를 인출하려 했습니다.");
            return 0;
        }
        if (amount > money) {
            System.out.println(name + "가 잔액 " + money + "보다 많은 돈" + amount + "를 인출하려 했습니다.");
            return 0;
        }
        money -= amount;
        return amount;
    }

    int deposit(int amount) {
        if (amount < 0) {
            System.out.println("음수를 입금하려 했습니다.");
            return 0;
        }
        money += amount;
        return amount;
    }

    int send(int amount, Account target) {
        if(draw(amount) == 0) {
            System.out.println("송금 실패");
            return 0;
        }
        target.deposit(amount);
        return amount;
    }

    //    생성자(Constructor). 객체의 초기화를 담당
    private Account(String name, String accountNumber, long initMoney) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.money = initMoney;
    }

    void describe() {
        System.out.println(name + "의 계좌 정보=============");
        System.out.println("계좌번호:" + accountNumber);
        System.out.println("잔액:" + money);
    }

    static Account createAccount(String name, String accountNumber, long initMoney) {
        System.out.println("계좌생성");
        return new Account(name, accountNumber, initMoney);
    }
}
