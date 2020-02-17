package com.company;

public class Main {

    public static void main(String[] args) {
        Animal animal =  new Animal("first animal",1);
//        animal.name = "first animal";
        Animal animal2 = new Animal("second animal",3);

        animal.introduce();
        animal2.introduce();

        animal.increaseAge();
        animal2.increaseAge();

        animal.introduce();
        animal2.introduce();


        System.out.println(Animal.theClassname);
        System.out.println(Animal.theClassname);
        System.out.println(Animal.theClassname);

        Animal.theClassname = "notAnAnimal";

        System.out.println(Animal.theClassname);
        System.out.println(Animal.theClassname);

        System.out.println(Animal.theClassname);

    }
}
