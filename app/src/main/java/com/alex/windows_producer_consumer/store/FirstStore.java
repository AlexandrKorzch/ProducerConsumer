package com.alex.windows_producer_consumer.store;

import com.alex.windows_producer_consumer.microsoft.Microsoft;

public class FirstStore extends Store {

    public FirstStore(Microsoft microsoft) {
        super(microsoft);
    }

    @Override
    void buySystems(int month, int date, String storeName) {
        microsoft.buy(1, month, date, storeName);
    }
}
