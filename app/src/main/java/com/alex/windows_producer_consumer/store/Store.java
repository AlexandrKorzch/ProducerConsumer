package com.alex.windows_producer_consumer.store;

import com.alex.windows_producer_consumer.ThreadCountDownLatch;
import com.alex.windows_producer_consumer.microsoft.Microsoft;

public abstract class Store extends ThreadCountDownLatch {

    Store(Microsoft microsoft) {
        this.microsoft = microsoft;
    }

    abstract void buySystems(int month, int date, String storeName);

    @Override
    public void newDay(int month, int day) {
        if (month == 0 && day == 0) {
            run = false;
        } else {
            currentMonth = month;
            currentDate = day;
            doAction.countDown();
        }
    }

    @Override
    public void action() {
        buySystems(currentMonth, currentDate, this.getClass().getSimpleName());
    }
}
