package com.company;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void Say(String content) {
        System.out.println(name + " says " + content);
    }

    public String getName() {
        return name;
    }

    public void drink() {
        System.out.println(name+" drinks");
    }

    public void breathe() {
        System.out.println(name+" breathes");
    }

    public Animal breed(Animal other) {
        System.out.println(name + " and " + other.name +" breeds");
        return new Animal(name + other.name);
    }
}
