package com.company;

import java.lang.annotation.Annotation;

public class Animal {
    String name;
    int weight;
    String food;

    public Animal(String name, String food, int weight){
        this.name = name;
        this.weight = weight;
        this.food = food;
    }

    public void introduce() {
        System.out.println("이름:" + name);
        System.out.println("무게:" + weight);
        System.out.println("먹이의 종류:" + food);
    }
}
