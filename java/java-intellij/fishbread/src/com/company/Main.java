package com.company;

public class Main {

    public static void main(String[] args) {
        FishBread fb = new FishBread("생성자로 만든 빵", 200);
        fb.describe();
        FishBread.foo();
        fb.foo();
        Main.main(new String[]{"foo", "bar"});
//        Main.main(new String[]{"", ""});
    }
}
