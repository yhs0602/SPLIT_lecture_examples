package com.company;

public class Cat extends Animal{

    public void Meow() {
        System.out.println("Meow");
    }

    @Override
    public void Say(String content) {
        Meow();
        super.Say(content);
    }

    public Cat(String name) {
        super(name);
    }
}
