package com.test;

public class Main {

    public static void main(String[] args) {
        Time normalTime = new Time(1,30, 0);
        Time timeToAdd = new Time(1, 56, 34);
        Time timeToSub = new Time(2, 50, 40);
        normalTime.describe();
        normalTime.add(timeToAdd);
        normalTime.describe();
        normalTime.sub(timeToSub);
        normalTime.describe();
//        System.out.println(normalTime.mod(-5,8));
    }
}
