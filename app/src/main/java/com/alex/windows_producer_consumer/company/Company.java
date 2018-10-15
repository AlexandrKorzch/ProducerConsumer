package com.alex.windows_producer_consumer.company;

import com.alex.windows_producer_consumer.ThreadCountDownLatch;
import com.alex.windows_producer_consumer.microsoft.Microsoft;
import com.alex.windows_producer_consumer.windows.Windows10;
import com.alex.windows_producer_consumer.windows.Windows10A;
import com.alex.windows_producer_consumer.windows.Windows10B;
import com.alex.windows_producer_consumer.windows.Windows10C;

import java.util.ArrayList;
import java.util.List;

public abstract class Company extends ThreadCountDownLatch {

    Company(Microsoft microsoft) {
        this.microsoft = microsoft;
    }

    @Override
    public void newDay(int month, int day) {
        if (day == 1 || day == 10 || day == 20) {
            currentMonth = month;
            currentDate = day;
            doAction.countDown();
        }else if(month == 0 && day == 0) {
            run = false;
        }
    }

    @Override
    public void action() {
        createSystems();
    }

    private void createSystems() {
        List<Windows10> systems = new ArrayList<>();
        systems.addAll(createWindowsASystems());
        systems.addAll(createWindowsBSystems());
        systems.addAll(createWindowsCSystems());
        microsoft.addSystems(systems, currentMonth, currentDate);
    }

    private List<Windows10A> createWindowsASystems(){
        List<Windows10A> systemsA = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            systemsA.add(new Windows10A());
        }
        return systemsA;
    }

    private List<Windows10B> createWindowsBSystems(){
        List<Windows10B> systemsB = new ArrayList<>();
        for(int i = 0; i< 20; i++){
            systemsB.add(new Windows10B());
        }
        return systemsB;
    }

    private List<Windows10C> createWindowsCSystems(){
        List<Windows10C> systemsC = new ArrayList<>();
        for(int i = 0; i< 40; i++){
            systemsC.add(new Windows10C());
        }
        return systemsC;
    }
}
