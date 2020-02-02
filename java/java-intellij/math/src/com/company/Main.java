package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int deg = sc.nextInt();
        double rad = Math.toRadians(deg);
        System.out.println(Math.sin(rad));
    }


}
