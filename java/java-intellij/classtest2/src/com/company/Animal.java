package com.company;

public class Animal {
    String name = "unnamed";
    int age = 100;

    static String theClassname = "Animal";

    void introduce() {
        System.out.println("이름:" + name);
        System.out.println("나이:" + age);
    }

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void increaseAge() {
//        age = age + 1;
        age += 1;
//        age++;
    }
}
