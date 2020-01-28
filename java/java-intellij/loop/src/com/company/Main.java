package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String correctPassword = "xidiednnvf";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("비밀번호를 입력하세요");
            String guess = scanner.next();
            if (correctPassword.equals(guess)) {
                break;
            }

        }

        System.out.println("맞았습니다");
    }
}

