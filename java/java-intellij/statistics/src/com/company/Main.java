package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("입력하실 숫자의 개수");
        //java.awt.Toolkit.getDefaultToolkit().beep();
        System.out.println("\007");

        int randomnumber =  new Random().nextInt(100);

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        float[] numbers = new float[count];
        //입력받기
        for (int i = 0; i < numbers.length; i++) {
            float input = sc.nextFloat();
            numbers[i] = input;
        }

        //입력받은 배열 출력하기
        System.out.println(""+Arrays.toString(numbers));

        int[] a = {10,20,30,40,50};
        int sum = IntStream.of(a).sum();
        System.out.println("The sum is " + sum);
    }
}
