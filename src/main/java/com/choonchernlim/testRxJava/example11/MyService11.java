package com.choonchernlim.testRxJava.example11;

import com.choonchernlim.testRxJava.main.MyDAO;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyService11 {
    private MyDAO myDao = new MyDAO();

    public Observable<String> getAllUsers(final int... personIds) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                ExecutorService executorService = Executors.newFixedThreadPool(5);

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        queryUser(subscriber, personIds);
                    }
                });

                executorService.shutdown();
            }
        });
    }

    private void queryUser(Subscriber<? super String> subscriber, int[] personIds) {
        for (Integer personId : personIds) {
            String name = myDao.getUser(personId);
            subscriber.onNext(name);
        }

        subscriber.onCompleted();
    }

    public Observable<Integer> getAllPoints(final int... personIds) {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(final Subscriber<? super Integer> subscriber) {
                ExecutorService executorService = Executors.newFixedThreadPool(5);

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        queryPoint(subscriber, personIds);
                    }
                });

                executorService.shutdown();
            }
        });
    }

    private void queryPoint(Subscriber<? super Integer> subscriber, int[] personIds) {
        for (Integer personId : personIds) {
            Integer point = myDao.getPoint(personId);
            subscriber.onNext(point);
        }
        subscriber.onCompleted();
    }
}
