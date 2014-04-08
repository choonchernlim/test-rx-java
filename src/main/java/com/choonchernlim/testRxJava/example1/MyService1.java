package com.choonchernlim.testRxJava.example1;

import com.choonchernlim.testRxJava.main.MyDAO;
import rx.Observable;
import rx.Subscriber;

public class MyService1 {
    private final MyDAO myDao = new MyDAO();

    public Observable<String> getAllUsers(final int... personIds) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                query(subscriber, personIds);
            }
        });
    }

    private void query(Subscriber<? super String> subscriber, int[] personIds) {

        for (Integer personId : personIds) {
            final String name = myDao.getUser(personId);
            subscriber.onNext(name);
        }

        subscriber.onCompleted();
    }
}
