package com.naver.account;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Student student = new Student("학생1", 1);
        student.describe();

        System.out.println(student.sum());
        System.out.println(student.avg());
//        Date date = new Date();
//        date.getHours()
        Calendar currentCalendar = Calendar.getInstance();

        this. minute = currentCalendar.get(Calendar.MINUTE)
    }
}
