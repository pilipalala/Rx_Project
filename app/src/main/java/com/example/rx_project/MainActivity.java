package com.example.rx_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RxUtils.flatMap();
//        RxUtils.range();
//        RxUtils.interval();
//        RxUtils.just();
//        RxUtils.createPrint();
//        RxUtils.createObservable();
//        RxUtils.asyncSubject();
//        RxUtils.behaviorSubject();
//        RxUtils.publishSubject();
        RxUtils.publishSubjectDemo();


//        dealWith();
    }

    private String param;

    private void dealWith() {
        new AsyncTaskUtils<ScaleInfo>(param, "", new ScaleInfoCallBack<ScaleInfo>() {
            @Override
            public void completeScale(ScaleInfo o) {

            }
        }).execute();
    }
}
