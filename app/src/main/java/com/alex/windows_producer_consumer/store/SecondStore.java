package com.alex.windows_producer_consumer.store;

import com.alex.windows_producer_consumer.microsoft.Microsoft;

public class SecondStore extends Store {

    public SecondStore(Microsoft microsoft) {
        super(microsoft);
    }

    @Override
    void buySystems(int month, int date, String storeName) {
        microsoft.buy(2, month, date, storeName);
    }
}
