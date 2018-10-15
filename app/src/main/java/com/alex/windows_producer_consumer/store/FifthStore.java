package com.alex.windows_producer_consumer.store;

import com.alex.windows_producer_consumer.microsoft.Microsoft;

public class FifthStore extends Store {

    public FifthStore(Microsoft microsoft) {
        super(microsoft);
    }

    @Override
    void buySystems(int month, int date, String storeName) {
        microsoft.buy(8, month, date, storeName);
    }
}
