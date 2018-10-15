package com.alex.windows_producer_consumer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alex.windows_producer_consumer.calendar.Calendar;
import com.alex.windows_producer_consumer.company.Company;
import com.alex.windows_producer_consumer.company.FirstCompany;
import com.alex.windows_producer_consumer.company.SecondCompany;
import com.alex.windows_producer_consumer.company.ThirdCompany;
import com.alex.windows_producer_consumer.microsoft.Microsoft;
import com.alex.windows_producer_consumer.store.FirstStore;
import com.alex.windows_producer_consumer.store.FifthStore;
import com.alex.windows_producer_consumer.store.FourthStore;
import com.alex.windows_producer_consumer.store.SecondStore;
import com.alex.windows_producer_consumer.store.Store;
import com.alex.windows_producer_consumer.store.ThirdStore;

public class MainActivity extends AppCompatActivity implements Log, View.OnClickListener {

    private Calendar mCalendar = new Calendar();
    private TextView mLogTv;
    private ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogTv = findViewById(R.id.tvLog);
        mScrollView = findViewById(R.id.scroll);
        findViewById(R.id.btStartStop).setOnClickListener(this);

        Microsoft microsoft = new Microsoft(this);

        Company firstCompany = new FirstCompany(microsoft);
        Company secondCompany = new SecondCompany(microsoft);
        Company thirdCompany = new ThirdCompany(microsoft);

        Store firstStore = new FirstStore(microsoft);
        Store secondStore = new SecondStore(microsoft);
        Store thirdStore = new ThirdStore(microsoft);
        Store fourthStore = new FourthStore(microsoft);
        Store fifthStore = new FifthStore(microsoft);

        firstCompany.start();
        secondCompany.start();
        thirdCompany.start();

        firstStore.start();
        secondStore.start();
        thirdStore.start();
        fourthStore.start();
        fifthStore.start();

        mCalendar.addListener(firstCompany);
        mCalendar.addListener(secondCompany);
        mCalendar.addListener(thirdCompany);

        mCalendar.addListener(firstStore);
        mCalendar.addListener(secondStore);
        mCalendar.addListener(thirdStore);
        mCalendar.addListener(fourthStore);
        mCalendar.addListener(fifthStore);

        mCalendar.start();
    }

    @Override
    public void log(final String message) {
        mLogTv.post(new Runnable() {
            @Override
            public void run() {
                mLogTv.append(message+"\n");
                mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    @Override
    public void onClick(View v) {
        mCalendar.startStop();
    }
}


