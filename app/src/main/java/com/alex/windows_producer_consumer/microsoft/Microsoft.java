package com.alex.windows_producer_consumer.microsoft;


import com.alex.windows_producer_consumer.Log;
import com.alex.windows_producer_consumer.windows.Windows10;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class Microsoft {

    private final Log logger;
    private List<Windows10> mWindows10List = new CopyOnWriteArrayList<>();
    private CountDownLatch doAction = new CountDownLatch(3);

    public Microsoft(Log logger) {
        this.logger = logger;
    }

    public void addSystems(List<Windows10> systems, int month, int date) {
        synchronized (this) {
            mWindows10List.addAll(systems);
            logger.log("add:" + systems.size() +
                    ", all:" + mWindows10List.size() +
                    ", month:" + month +
                    ", date:" + date);
        }
        doAction.countDown();
    }

    public void buy(int needCount, int month, int date, String storeName) {
        await();
        synchronized (this) {
            int systemsIndex = mWindows10List.size() - 1;
            for (int i = systemsIndex ; i > systemsIndex - needCount; i--) {
                mWindows10List.remove(i);
            }
            if(mWindows10List.size() == 0){
                doAction = new CountDownLatch(1);
            }
            logger.log("buy:" + storeName +
                    ", count:"+needCount+
                    ", all:" + mWindows10List.size() +
                    ", month:" + month +
                    ", date:" + date);
        }
    }

    private void await() {
        try {
            doAction.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
