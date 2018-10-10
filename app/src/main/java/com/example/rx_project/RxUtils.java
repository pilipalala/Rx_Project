package com.example.rx_project;


import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

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
            public void onStart() {
                super.onStart();
                Log.e(TAG, "onStart: ");
            }

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
     * 第一个参数为起始值，第二个为发送的个数
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

    public static void map() {
        Observable.just("images/logo.png") // 输入类型 String
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String filePath) { // 参数类型 String
                        return getBitmapFromPath(filePath); // 返回类型 Bitmap
                    }
                })
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) { // 参数类型 Bitmap

                    }
                });
    }

    private static Bitmap getBitmapFromPath(String filePath) {
        return null;
    }

    public static List<Course> getCourseList(String name) {

        ArrayList<Course> courses = new ArrayList<>();
        Random random = new Random();
        int count = random.nextInt(20) + 10;
        for (int i = 0; i < count; i++) {
            courses.add(new Course(name + " --> " + i));
        }
        return courses;

    }

    private static Student[] students = {new Student(getCourseList("数学")),
            new Student(getCourseList("语文")), new Student(getCourseList("英语"))};

    public static void flatMap() {
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCourseList());
                    }
                })
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course course) {
                        Log.e(TAG, "RxUtils:254-->call: " + course.getName());
                    }
                });

    }

    public static void lift() {
        Observable.from(students)
                .lift(new Observable.Operator<Course, Student>() {
                    @Override
                    public Subscriber<? super Student> call(Subscriber<? super Course> subscriber) {
                        return new Subscriber<Student>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Student student) {
                                student.getCourseList();
                            }
                        };

                    }
                });
    }


    /**
     * Observer只会接收asyncSubject的onCompleted()被调用前的最后一个数据，
     * 即“asyncSubject5”，如果不调用onCompleted()，Subscriber将不接收任何数据。
     * <p>
     * 如果因异常而终止，AsyncSubject将不会释放任何数据，但是会向Observer传递一个异常通知
     */
    public static void asyncSubject() {
        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext("asyncSubject1");
        asyncSubject.onNext("asyncSubject2");
        asyncSubject.onNext("asyncSubject3");
        asyncSubject.onNext("asyncSubject4");
        asyncSubject.onNext("asyncSubject5");
        asyncSubject.onCompleted();
        asyncSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "RxUtils:301-->onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "RxUtils:306-->onError: ");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "RxUtils:311-->onNext: " + s);
            }
        });
    }

    /**
     * Observer会接收到BehaviorSubject被订阅之前的最后一个数据，
     * 再接收其他发射过来的数据，如果BehaviorSubject被订阅之前没有发送任何数据，
     * 则会发送一个默认数据。（注意跟AsyncSubject的区别，AsyncSubject要手动调用onCompleted()，
     * 且它的Observer会接收到onCompleted()前发送的最后一个数据，之后不会再接收数据，
     * 而BehaviorSubject不需手动调用onCompleted()，
     * 它的Observer接收的是BehaviorSubject被订阅前发送的最后一个数据，两个的分界点不一样，
     * 且之后还会继续接收数据。）
     * <p>
     * 如果在behaviorSubject.subscribe()之前不发送behaviorSubject1、behaviorSubject2，
     * 则Observer会先接收到default,再接收behaviorSubject3、behaviorSubject4。
     */
    public static void behaviorSubject() {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create("default");
        behaviorSubject.onNext("behaviorSubject1");
        behaviorSubject.onNext("behaviorSubject2");
        behaviorSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "RxUtils:331-->onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "RxUtils:336-->onError: " + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "RxUtils:341-->onNext: " + s);
            }
        });
        behaviorSubject.onNext("behaviorSubject3");
        behaviorSubject.onNext("behaviorSubject4");
    }

    /**
     * PublishSubject比较容易理解，相对比其他Subject常用，
     * 它的Observer只会接收到PublishSubject被订阅之后发送的数据。
     */
    public static void publishSubject() {
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.onNext("PublishSubject1");
        publishSubject.onNext("PublishSubject2");
        publishSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "RxUtils:372-->onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "RxUtils:382-->onNext: " + s);
            }
        });
        publishSubject.onNext("publishSubject3");
        publishSubject.onNext("publishSubject4");
    }

    public static void publishSubjectDemo() {
        PublishSubject<String> publishSubject = PublishSubject.create();

        publishSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "RxUtils:405-->onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "RxUtils:410-->onError: " + e);
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "RxUtils:415-->onNext: " + s);
            }
        });
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("publishSubject1");
                    subscriber.onNext("publishSubject2");
                    subscriber.onNext("publishSubject3");
                    subscriber.onCompleted();
                }

            }
        }).subscribe(publishSubject);

    }

}
