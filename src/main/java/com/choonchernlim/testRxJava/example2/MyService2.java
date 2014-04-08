package com.choonchernlim.testRxJava.example2;

import com.choonchernlim.testRxJava.main.MyDAO;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyService2 {
    private final MyDAO myDao = new MyDAO();

    // wrap `query(..)` with `ExecutorService`
    public Observable<String> getAllUsers(final int... personIds) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                final ExecutorService executorService = Executors.newFixedThreadPool(5);

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        query(subscriber, personIds);
                    }
                });

                executorService.shutdown();
            }
        });
    }

    // No change from Example 1
    private void query(Subscriber<? super String> subscriber, int[] personIds) {

        for (Integer personId : personIds) {
            final String name = myDao.getUser(personId);
            subscriber.onNext(name);
        }

        subscriber.onCompleted();
    }
}
