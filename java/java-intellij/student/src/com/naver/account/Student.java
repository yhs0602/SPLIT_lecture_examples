package com.naver.account;

import java.util.Random;

public class Student {
    String name;
    int grade;
    int kor, math, eng;

    int sum() {
        return kor + math + eng;
    }

    double avg() {
        return sum() / 3.0;
    }

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        Random random = new Random();
        kor = random.nextInt(100);
        eng = random.nextInt(100);
        math = random.nextInt(100);
    }

    void describe() {
        System.out.println(name+"("+grade+"학년):");
        System.out.println("국어:"+kor);
        System.out.println("수학:"+math);
        System.out.println("영어:"+eng);
    }
}
