package com.example.wangy.rx_project;


import android.icu.lang.UScript;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxUtils {
    private static final String TAG = RxUtils.class.getSimpleName();

    /**
     * 使用create方式
     */
    public static void createObservable() {
        //定义被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("hello");
                    subscriber.onNext("hi");
                    subscriber.onNext(downLoadJson());
                    subscriber.onNext("world");
                    subscriber.onCompleted();
                }
            }
        });
        //订阅者
        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext: " + s);
            }
        };
        observable.subscribe(subscriber);
    }

    private static String downLoadJson() {
        return "json data";
    }

    /**
     * create 第二种方式
     */
    public static void createPrint() {
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 0; i < 10; i++) {
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                }

            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext: " + integer);
            }
        });
    }

    /**
     * 使用在被观察者 返回的对象  一般都是数值类型
     */
    public static void from() {
        Integer[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Observable.from(items)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.e(TAG, "call: " + integer);
                    }
                });
    }

    /**
     * 指定某一时刻进行数据发送
     */
    public static void interval() {
        Observable.interval(0, 1, TimeUnit.SECONDS)//每隔一秒 发送一次数据
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.e(TAG, "call: " + aLong);
                    }
                });
    }

    /**
     * 处理数组集合
     */
    public static void just() {
        Integer[] items1 = {1, 2, 3, 4, 5, 6};
        Integer[] items2 = {3, 5, 2, 7, 8, 9};
        Observable.just(items1, items2)
                .subscribe(new Subscriber<Integer[]>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer[] integers) {
                        for (Integer integer : integers) {
                            Log.e(TAG, "onNext: " + integer);
                        }
                    }
                });
    }

    /**
     * 使用范围数据，指定输出数据的范围
     */
    public static void range() {
        Observable.range(1, 50)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                    }
                });
    }

    /**
     * 使用过滤功能
     */
    public static void filter() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integers) {
                        return 0 < 5;

                    }
                }).observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                    }
                });
    }
}
