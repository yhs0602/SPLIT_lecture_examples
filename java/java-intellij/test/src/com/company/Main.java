package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int ordinalInWeek;
        switch (input) {
            case "월":
                ordinalInWeek = 1;
                break;
            case "화":
                ordinalInWeek = 2;
                break;
            case "수":
                ordinalInWeek = 3;
                break;
            case "목":
                ordinalInWeek = 4;
                break;
            case "금":
                ordinalInWeek = 5;
                break;
            case "토":
                ordinalInWeek = 6;
                break;
            case "일":
                ordinalInWeek = 7;
                break;
        }
    }
}