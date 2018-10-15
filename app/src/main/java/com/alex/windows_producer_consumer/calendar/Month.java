package com.alex.windows_producer_consumer.calendar;

import java.util.LinkedList;
import java.util.Queue;

class Month {

    private int monthNumber;
    private Queue<Integer> days = new LinkedList<>();

    Month(int monthNumber) {
        this.monthNumber = monthNumber;
        for (int i = 1; i < 31; i++) {
            days.add(i);
        }
    }

    int getMonthNumber() {
        return monthNumber;
    }

    int getDay() {
        return days.poll();
    }

    int getRemainingDays() {
        return days.size();
    }
}
