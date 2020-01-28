package com.company;

public class Main {

    public static void main(String[] args) {
        int[] scores;
        scores = new int[10];
        scores[0] = 34;
        scores[1] = 94;
        scores[2] = 20;
        scores[3] = 23;
        scores[4] = 56;
        scores[5] = 14;
        scores[6] = 24;
        scores[7] = 34;
        scores[8] = 88;
        scores[9] = 32;
        System.out.print('[');                    //[ 출력
        for (int i = 0; i < scores.length; i++) {      //i는 0부터 scores.length까지 변한다.
            System.out.print(scores[i]);        //i번째 요소 출력
            System.out.print(' ');              //스페이스 출력
        }

        for(int score : scores) {
            System.out.print(score);        //i번째 요소 출력
            System.out.print(' ');              //스페이스 출력
        }
        System.out.println(']');                //] 출력
    }
}
