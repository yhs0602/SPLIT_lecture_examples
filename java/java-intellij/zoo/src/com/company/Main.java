package com.company;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("동물", "잎", 100);
        animal.introduce();
        Animal parrot = new Parrot(100);
        parrot.introduce();
//        parrot.shadow("안녕하세요");
    }

}
