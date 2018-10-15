package com.alex.windows_producer_consumer.calendar;

import android.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Year {

    private Queue<Month> mMonths = new LinkedList<>();
    private Month mCurrentMonth;

    Year() {
        for (int i = 1; i < 13; i++) {
            mMonths.add(new Month(i));
        }
        mCurrentMonth = mMonths.poll();
    }

    Pair<Integer, Integer> getNextDate(){
        int monthNumber = 0;
        int dayNumber = 0;
        Month month = getMonth();
        if (month != null){
            monthNumber = month.getMonthNumber();
            dayNumber = month.getDay();
        }
        return new Pair<>(monthNumber, dayNumber);
    }

    private Month getMonth(){
        if (mCurrentMonth != null && mCurrentMonth.getRemainingDays() == 0) {
            mCurrentMonth = mMonths.poll();
        }
        return mCurrentMonth;
    }
}
