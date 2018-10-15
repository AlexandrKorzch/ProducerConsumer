package com.alex.windows_producer_consumer;

import com.alex.windows_producer_consumer.calendar.TimeListener;
import com.alex.windows_producer_consumer.microsoft.Microsoft;

import java.util.concurrent.CountDownLatch;

public abstract class ThreadCountDownLatch extends Thread implements TimeListener {

    protected Microsoft microsoft;

    protected CountDownLatch doAction = new CountDownLatch(1);

    protected boolean run = true;

    protected volatile int  currentMonth;
    protected volatile int currentDate;

    public abstract void action();

    @Override
    public void run() {
        super.run();
        waitDate();
    }

    private void waitDate() {
        while (run){
            await();
            action();
        }
    }

    private void await() {
        try {
            doAction.await();
            doAction = new CountDownLatch(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
