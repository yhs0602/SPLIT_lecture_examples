package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //몇 문제 풀 건지 물어보는 부분
        System.out.print("몇 문제를 풀 것인가요:");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count <= 0) {
            System.out.println("1 이상의 정수를 입력하세요");
            System.exit(0);
        }

        //물어보는 부분
        boolean[] ox = new boolean[count];

        for (int i = 0; i < count; i++) {
            int random1 = makeRandomInt();
            int random2 = makeRandomInt();
            int correct = random1 + random2;
            System.out.println(random1 + "+" + random2 + "= ?");
            int guess = scanner.nextInt();
            if (guess == correct) {
                System.out.println("Correct");
                ox[i] = true;
            } else {
                System.out.println("Wrong");
                ox[i] = false;
            }
        }

        //출력하는 부분
        System.out.println("# OX");
        System.out.println("=====");

        for (int i = 0; i < ox.length; i++) {
            System.out.println((i + 1) + " " + (ox[i] ? 'O' : 'X'));
        }

    }

    public static int makeRandomInt() {
        Random random = new Random();
        return random.nextInt(4000);
    }
}
