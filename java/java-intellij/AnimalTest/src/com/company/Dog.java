package com.company;

public class Dog extends  Animal {
    public Dog(String name) {
        super(name);
    }

    public void Bark() {
        System.out.println("BowWow");
    }

    @Override
    public void Say(String content) {
        Bark();
        super.Say(content);
    }

    public void Walk() {
        System.out.println(name + " walks");
    }
}
