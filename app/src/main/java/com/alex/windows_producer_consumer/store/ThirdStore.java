package com.alex.windows_producer_consumer.store;

import com.alex.windows_producer_consumer.microsoft.Microsoft;

public class ThirdStore extends Store {

    public ThirdStore(Microsoft microsoft) {
        super(microsoft);
    }

    @Override
    void buySystems(int month, int date, String storeName) {
        microsoft.buy(4, month, date, storeName);
    }
}
