package com.company;

public class Main {

    public static void main(String[] args) {
        int a = 0;
        int b = 10;
        int c = 0;
        try {
            c = b / a;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
//            System.out.println(e. e.getStackTrace());
        }

        System.out.println(c);
    }
}
