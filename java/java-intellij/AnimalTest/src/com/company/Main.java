package com.company;

public class Main {

    public static void main(String[] args) {
        Animal animal1;
        Animal animal2;
        Animal animal3;

        animal1 = new Animal("그냥동물");
        animal2 = new Cat("고양");
        animal3 = new Dog("개개");

        animal1.breathe();
        animal2.drink();
        animal3.Say("Hello");

        Animal animal4 = animal2.breed(animal1);
        animal4.Say("I am baby");
    }
}
