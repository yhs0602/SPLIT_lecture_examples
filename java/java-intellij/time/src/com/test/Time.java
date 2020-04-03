package com.test;

import java.util.Calendar;

public class Time {
    int hour;
    int minute;
    int second;

    Time add(Time other) {
        hour += other.hour;
        minute += other.minute;
        second += other.second;
        normalize();
        return this;
    }

    Time sub(Time other) {
        hour -= other.hour;
        minute -= other.minute;
        second -= other.second;
        normalize();
        return this;
    }

    Time() {
        Calendar currentCalendar = Calendar.getInstance();
        this.hour = currentCalendar.get(Calendar.HOUR);
        this.minute = currentCalendar.get(Calendar.MINUTE);
        this.second = currentCalendar.get(Calendar.SECOND);
    }

    Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        normalize();
    }

    void normalize() {
        minute += div(second, 60);    //second가 150초라면 150 = 60*2+30이므로 2를 더한다.
        second = mod(second, 60);           //second가 150초라면 150 = 60*2+30이므로 30이 된다.
        hour += div(minute, 60);
        minute = mod(minute, 60);
    }

    void describe() {
        System.out.println("time{" + hour + "시 " + minute + "분 " + second + "초}");
    }

    // https://stackoverflow.com/a/43953315/8614565
    int mod(int a, int b) {
        int ret = a % b;
        if (ret < 0)
            ret += b;
        return ret;
    }

    int div(int a, int b) {
        if (a >= 0)
            return a / b;
        return (a / b) - 1;
    }
}
