package com.alex.windows_producer_consumer.calendar;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Calendar extends Thread {

    private List<TimeListener> timeListeners = new ArrayList<>();
    private CountDownLatch doAction = new CountDownLatch(1);

    private int currentMonth = -1;

    public void addListener(TimeListener timeListener){
        timeListeners.add(timeListener);
    }

    @Override
    public void run() {
        super.run();
        Year year = new Year();
        while (currentMonth != 0){
            await();
            Pair<Integer, Integer> date = year.getNextDate();
            notifyListeners(date.first, date.second);
            currentMonth = date.first;
            delay();
        }
    }

    private void notifyListeners(Integer month, Integer date){
        for (TimeListener listener: timeListeners){
            listener.newDay(month, date);
        }
    }

    private void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void await() {
        try {
            doAction.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startStop() {
        if(doAction.getCount() == 0){
            doAction = new CountDownLatch(1);
        }else {
            doAction.countDown();
        }
    }
}
