package com.company;

public class Parrot extends Animal {

    public Parrot(int weight) {
        super("앵무새", "콩", weight);
    }

    public void shadow(String utter) {
        System.out.println(utter);
        System.out.println(utter);
    }

}
