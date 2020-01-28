package com.company;

        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("2+4=?");
        int answer = sc.nextInt();
        if(answer == 6) {
            System.out.println("맞앗습니다");
        }
    }
}
