package com.alex.windows_producer_consumer.store;

import com.alex.windows_producer_consumer.microsoft.Microsoft;

public class FourthStore extends Store {

    public FourthStore(Microsoft microsoft) {
        super(microsoft);
    }

    @Override
    void buySystems(int month, int date, String storeName) {
        microsoft.buy(6, month, date, storeName);
    }
}
