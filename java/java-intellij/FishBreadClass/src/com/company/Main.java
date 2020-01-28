package com.company;

public class Main {

    public static void main(String[] args) {
        FishBread myBread = new FishBread("My bread", 100);
        FishBread yourBread = new FishBread("Your bread", 400);
        myBread.describe();
        yourBread.describe();
    }
}
